package me.duco;

import me.duco.file.FileHandler;
import me.duco.mqtt.MqttHandler;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;


import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] arg) throws MqttException, InterruptedException {
        Path homedir = Paths.get(System.getProperty("user.home"), "SolidMQ");

        MqttHandler t = new MqttHandler();
        t.get();

    }
}
