package ionio.tramooc.split;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Xristos Pappas
 * @uni Ionian University
 * @traMOOC
 */
public class Sentences {

    private String str = null;
    private List<String> inSentencesdData;

    public List<String> getInSentencesdData() {
        return inSentencesdData;
    }

    public void setInSentencesdData(List<String> inSentencesdData) {
        this.inSentencesdData = inSentencesdData;
    }
    
    private final String TAG_SENTENCE_REGEX = "<content>(.+?)</content>";

    public Sentences(String str) {
        this.str = str;
        regexData();
    }
    
    private void regexData(){
        inSentencesdData = new ArrayList<>();
        Pattern re = Pattern.compile(TAG_SENTENCE_REGEX, Pattern.MULTILINE | Pattern.COMMENTS);
        Matcher reMatcher = re.matcher(str);
        while (reMatcher.find()) {
            inSentencesdData.add(reMatcher.group(1));
            System.out.println(reMatcher.group(1));
        }
    }
    
    

}
