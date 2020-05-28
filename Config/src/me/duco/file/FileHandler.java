package me.duco.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {
    private final String installpath, filename, topmsg;
    private File file;
    private String filepath;

    FileHandler(final String path, String name, String top) {
        installpath = path;
        filename = name;
        topmsg = top;
        filepath = Paths.get(installpath, filename).toString();
        emptyLog();
    }

    public void emptyLog() {
        file = new File(filepath);
        try {
            if(!file.exists()) {
                if( new File(installpath).mkdirs()) { //Create dirs if non existent
                    System.out.println("Created directory: " + installpath);
                }
            }

            if(file.createNewFile()) {
                writelog(topmsg);
                System.out.println("Created file: " + filepath);
            }

        } catch (IOException e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        }
    }

    public void writelog(String data) { // Will overwrite existing file
        try {
            FileWriter out = new FileWriter(filepath);
            out.write(data);
            out.close();

            System.out.println("Written to file");

        } catch (IOException e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        }
    }

    public void appendLog(String what, String delimiter) { // Will append to file
        try {
            FileWriter out = new FileWriter(filepath, true);
            out.append(what).append(delimiter);
            out.close();

            System.out.println("Appended to file");

        } catch (IOException e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        }
    }

    public void appendLog(String what) { // Overload appendLog method to allow default parameter.
        appendLog(what, "\n");
    }

    public String readLog() {

        //ToDo implement log reading
        return null;
    }
}
