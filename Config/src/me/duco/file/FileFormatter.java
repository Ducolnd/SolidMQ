package me.duco.file;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FileFormatter {

    boolean secret;

    public FileFormatter(boolean safe) {
        secret = safe;
    }

    public void log(String data) {
        Path homedir = Paths.get(System.getProperty("user.home"), "SolidMQ");
        FileHandler file = new FileHandler(homedir.toString(), "mainlog.txt", "Mainlog.txt file. Main logging file.");

        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        file.appendLog(String.format("[%s] {%s}", currentTime.format(date), data));
    }

}
