package ionio.tramooc.csv;

import ionio.tramooc.readfile.CreateFolder;
import ionio.tramooc.readfile.ReadFile;
import ionio.tramooc.split.Sentences;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 * @author Xristos Pappas
 * @uni Ionian University
 * @traMOOC
 */
public class GenerateCSV {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";

    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "\"" + "id" + "\"" + "," + "\"" + "sentence" + "\"";

    private File docDir;
    private FileSystemView destination;
    private int id = 0;

    public GenerateCSV() {
        JFileChooser fr = new JFileChooser();
        destination = fr.getFileSystemView();
        docDir = destination.getDefaultDirectory();
        CreateFolder cf = new CreateFolder();
        System.out.println(docDir);
        cf.isDir("Sentence Data", docDir.toString());
    }

    public void writeCSVFile(String input, String fileName) {
        FileWriter fileWriter = null;
        File file = new File(docDir + "\\traMOOC data\\" + fileName);

        try {

            fileWriter = new FileWriter(file);
            //Write the CSV file header
            fileWriter.append(FILE_HEADER);
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
            //Write a new student object list to the CSV file
            ReadFile rf = new ReadFile(input);
            System.out.println(rf.getClass());
            String data = rf.getData().replace("\n", "");
            data = data.replace("\"", "");
            Sentences s = new Sentences(data);
            for (String inSentencesdData : s.getInSentencesdData()) {
                id += 1;
                fileWriter.append(String.valueOf("\"" + id + "\""));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("\"" + inSentencesdData + "\"");
                fileWriter.append(NEW_LINE_SEPARATOR);

            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {

            System.out.println("Error in CsvFileWriter !!!");

            e.printStackTrace();

        } finally {

            try {

                fileWriter.flush();

                fileWriter.close();

            } catch (IOException e) {

                System.out.println("Error while flushing/closing fileWriter !!!");

                e.printStackTrace();

            }

        }

    }

}
