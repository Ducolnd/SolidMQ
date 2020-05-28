package me.duco;

import me.duco.file.FileFormatter;
import me.duco.mqtt.MqttHandler;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Main {

    public static void main(String[] arg) throws InterruptedException {

        MqttHandler t = new MqttHandler();
        FileFormatter log = new FileFormatter(false);

        log.log("Testing on time");
        log.log("Testing some time later");
        Thread.sleep(1000);
        log.log("1 Second later");

    }
}
