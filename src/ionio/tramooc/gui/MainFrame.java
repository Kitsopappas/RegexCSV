package ionio.tramooc.gui;

import javax.swing.JFrame;

/**
 * @author Xristos Pappas
 * @uni Ionian University
 * @traMOOC
 */
public class MainFrame extends JFrame {

    public void init() {
        Nimbus.install();
        setTitle("CSV Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 250);
        setLocationRelativeTo(null);

        add(new InputOutputPanel());

    }
}
