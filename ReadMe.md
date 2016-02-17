## RegexCSV

![alt tag](http://icons.iconarchive.com/icons/pelfusion/flat-file-type/32/doc-icon.png)
> Convert text data to csv format.
> Regex string have to change if you want to parse other files

## Screenshots

![alt tag](https://i.gyazo.com/2b9edf0f4f460f5faff0d216d66b5dda.png)


## Code
```sh
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
```
