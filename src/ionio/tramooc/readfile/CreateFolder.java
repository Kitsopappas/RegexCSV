package ionio.tramooc.readfile;

import java.io.File;

/**
 *
 * @author xristos
 */
public class CreateFolder {

    //see if the folder exist. If is not then create it
    public void isDir(String dir, String destination) {
        File f = new File(destination + "\\" + dir);
        if (f.exists() && f.isDirectory()) {
            System.out.println("true");
        } else {
            System.out.println("false");
            makeDir(dir, destination);
        }
    }

    //create a folder in documends
    public void makeDir(String dir, String destination) {

        File makeDir = new File(destination + "\\" + dir);
        makeDir.mkdir();
        if (makeDir.mkdir()) {
            System.out.println("Multiple directories are created!");
        } else {
            System.out.println("Failed to create multiple directories!");
        }

    }

}
