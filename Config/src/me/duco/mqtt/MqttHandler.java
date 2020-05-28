package me.duco.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttHandler {

    final String broker = "tcp://192.168.178.135";
    final String clientId = "my-mqtt-device";

    public void handler() throws MqttException, InterruptedException {

        MqttClient client = new MqttClient(broker, "testtest32");
        client.connect();
        MqttMessage msg = new MqttMessage();
        msg.setPayload("infocom".getBytes());

        for(int i = 0; i < 5; i++) {
            client.publish("test", msg);
            Thread.sleep(1000);
        }

        client.disconnect();
    }

    public void get() throws MqttException {
        MqttClient client = new MqttClient(broker, clientId);

        client.setCallback(new Callback());
        client.connect();

        client.subscribe("topic");
    }
}
