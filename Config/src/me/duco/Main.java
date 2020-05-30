package me.duco;

import me.duco.file.Configurations;
import me.duco.file.FileFormatter;
import me.duco.mqtt.MqttHandler;

import org.eclipse.paho.client.mqttv3.MqttException;

import java.io.IOException;
import java.lang.module.Configuration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class Main {

    private static final Logger LOGGER = Logger.getLogger( Main.class.getName() );

    public static void main(String[] args) throws InterruptedException, MqttException, IOException {

        MqttHandler broker = new MqttHandler();
        FileFormatter log = new FileFormatter(false);

        if (!(args.length > 0)) { // No arguments so subscribing to everyting
            broker.get("/home/#");

        } else if (args[0] == "get") {
            if (args.length < 2) {
                System.out.println("You must select a topic to listen to");
                exit(0);
            }

            broker.get(args[1]); // Sub to given topic

        } else if (args[0] == "config") {


        } else if (args[0] == "read") {

        } else {
            LOGGER.log(Level.WARNING, "Error, wrong usage. Usage: ");
        }

    }
}
