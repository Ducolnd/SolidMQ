package me.duco;

import me.duco.file.Configurations;
import me.duco.file.FileFormatter;
import me.duco.mqtt.MqttHandler;

import org.eclipse.paho.client.mqttv3.MqttException;

import java.io.IOException;
import java.lang.module.Configuration;
import java.util.Properties;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) throws InterruptedException, MqttException, IOException {

        MqttHandler broker = new MqttHandler();
        FileFormatter log = new FileFormatter(false);

        if (!(args.length > 0)) { // No arguments so subscribing to everyting
            Properties config = Configurations.readPropertiesFile();
            System.out.println(config.getProperty("username"));
            //broker.get("#");

        } else if (args[0] == "get") {
            if (args.length < 2) {
                System.out.println("You must select a topic to listen to");
                exit(0);
            }

            broker.get(args[1]); // Sub to given topic

        } else if (args[0] == "pub") {
            if (args.length < 3) {
                System.out.println("You must select a topic and message respectively");
                exit(0);
            }

            broker.set(args[2], args[1]); // data, topic
        }
    }
}
