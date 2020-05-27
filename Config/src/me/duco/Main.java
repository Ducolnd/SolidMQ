package me.duco;

import me.duco.file.FileHandler;
import me.duco.mqtt.MqttHandler;


import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] arg) {
        Path homedir = Paths.get(System.getProperty("user.home"), "SolidMQ");

        FileHandler files = new FileHandler(homedir.toString(), "/new.txt");
        files.appendLog("Fromage", "\t");
        //MqttHandler client = new MqttHandler();

    }
}
