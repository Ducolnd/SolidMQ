package me.duco;

import me.duco.file.FileFormatter;
import me.duco.mqtt.MqttHandler;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Main {

    public static void main(String[] arg) throws InterruptedException, MqttException {

        MqttHandler t = new MqttHandler();
        FileFormatter log = new FileFormatter(false);

        t.handler();
        t.get();

        t.handler();
        log.log("First Date - Fred epic song lofi ");

        t.handler();

    }
}
