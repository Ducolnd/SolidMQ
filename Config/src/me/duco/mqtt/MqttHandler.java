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

    public void set(String data, String topic) throws MqttException {
        if(client.isConnected()) {
            MqttMessage msg = new MqttMessage();
            msg.setPayload(data.getBytes());

            client.publish(topic, msg);

            FileFormatter log = new FileFormatter(false);
            log.log(data, topic, FileFormatter.Flag.PUB);
            System.out.println("Published message");
        }
    }

    public void get(String topic) throws MqttException {
        if (client.isConnected()) {
            client.subscribe(topic);
            System.out.println("Subscribed to topic(s) " + topic);
        }
    }
}
