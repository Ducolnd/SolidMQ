package me.duco.file;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FileFormatter {

    public enum Flag {
        PUB,
        SUB
    }

    boolean secret;

    public FileFormatter(boolean safe) {
        secret = safe;
    }

    public void log(String data, String topic, Flag flag) {
        Path homedir = Paths.get(System.getProperty("user.home"), "SolidMQ");
        String topicdir = Paths.get(homedir.toString(), topic).toString();

        FileHandler log = new FileHandler(topicdir, flag.toString() + "log.txt", "Mainlog.txt file. Main logging file.");

        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        log.appendLog(String.format("[%s] %s", currentTime.format(date), data));
    }

}
