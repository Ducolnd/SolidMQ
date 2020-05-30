package me.duco.file;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static java.lang.System.exit;

public class FileFormatter {

    boolean secret;

    public FileFormatter(boolean safe) {
        secret = safe;
    }

    public void log(String data, String topic) {
        Path homedir = Paths.get(System.getProperty("user.home"), "SolidMQ");

        String[] tdir = topic.split("/");

        String topicdir = Paths.get(homedir.toString(), String.join("/", Arrays.copyOfRange(tdir, 0, tdir.length - 1))).toString();

        FileHandler log = new FileHandler(topicdir, tdir[tdir.length - 1] + "Log.txt",  String.format("Topic: None"));

        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        log.appendLog(String.format("[%s] %s", currentTime.format(date), data));
    }
}
