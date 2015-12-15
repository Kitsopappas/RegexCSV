package ionio.tramooc.gui;

import ionio.tramooc.csv.GenerateCSV;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Xristos Pappas
 * @uni Ionian University
 * @traMOOC
 */
public class InputOutputPanel extends JPanel {

    private JTextField inputFolder, outputFolder;
    private JLabel in, out;
    private JButton generate;
    private String inFile, outFile;

    public InputOutputPanel() {
        in = new JLabel("choose file");
        out = new JLabel("file name");
        inputFolder = new JTextField(20);
        outputFolder = new JTextField(20);
        generate = new JButton("Generate CSV");
        //listeners
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                inFile = inputFolder.getText();
                outFile = outputFolder.getText();
                if (outFile.endsWith(".csv")) {
                    GenerateCSV gcsv = new GenerateCSV();
                    gcsv.writeCSVFile(inFile, outFile);
                } else {
                    GenerateCSV gcsv = new GenerateCSV();
                    gcsv.writeCSVFile(inFile, outFile + ".csv");
                }

            }
        });

        add(in);
        add(inputFolder);
        add(out);
        add(outputFolder);
        add(generate);
    }

}
