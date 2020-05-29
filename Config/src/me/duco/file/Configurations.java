package me.duco.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configurations {

    private static String fileName = "/etc/solidmq.properties";

    public static Properties readPropertiesFile() throws IOException {
        FileInputStream fileIn = null;
        Properties property = null;

        try {
            fileIn = new FileInputStream(fileName);
            property = new Properties();
            property.load(fileIn);

        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fileIn.close();
        }
         System.out.println("Property:");
        return property;
    }
}
