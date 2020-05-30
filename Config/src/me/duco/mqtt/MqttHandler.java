package me.duco.mqtt;

import me.duco.file.FileFormatter;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttHandler {

    final String broker;
    final String clientId;
    final MqttClient client;

    public MqttHandler() throws MqttException {
        // Init mqtt connection with broker
        broker = "tcp://192.168.178.135";
        clientId = "my-mqtt-device";
        client = new MqttClient(broker, clientId);

        client.connect();
        client.setCallback(new Callback());
    }

    public void get(String topic) throws MqttException {
        if (client.isConnected()) {
            client.subscribe(topic);
            System.out.println("Subscribed to topic(s) " + topic);
        }
    }
}
