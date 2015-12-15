package ionio.tramooc.readfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * @author Xristos Pappas
 * @uni Ionian University
 * @traMOOC
 */
public class ReadFile {

    private String data = null;
    // Read file line by line and save it to a string
    public ReadFile(String fileName) throws IOException {
        try {
            File fileDir = new File(fileName);

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"))) {
                StringBuilder sb = new StringBuilder();
                String line = in.readLine();
                
                while (line != null) {
                    sb.append(line);
                    sb.append("\n");
                    line = in.readLine();
                }
                data = sb.toString();
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
