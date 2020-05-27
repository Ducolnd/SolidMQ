package me.duco.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private String installpath, filename;
    private File file;

    public FileHandler(String path, String name) {
        installpath = path;
        filename = name;
        emptyLog();
    }

    public void emptyLog() {
        file = new File(installpath + filename);
        try {
            if(!file.exists()) {
                if(new File(installpath).mkdirs()) { //Create dirs if no existant
                    System.out.println("Created directory: " + installpath);
                }
            }

            if(file.createNewFile()) {
                System.out.println("Created file: " + installpath + filename);
            }

        } catch (IOException e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        }
    }

    public void writelog() { // Will overwrite existing file
        try {
            FileWriter out = new FileWriter(installpath + filename);
            out.write("Written from class");
            out.close();

            System.out.println("Written to file");

        } catch (IOException e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        }
    }

    public void appendLog(String what, String endline) { // Will append to file
        try {
            FileWriter out = new FileWriter(installpath  + filename, true);
            out.append(what).append(endline);
            out.close();

            System.out.println("Appended to file");

        } catch (IOException e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        }
    }

    public void appendLog(String what) { // Overload appendLog method to allow default parameter.
        appendLog(what, "\t");
    }

    public String readLog() {

        //ToDo implement log reading
        return null;
    }
}
