package me.duco.mqtt;

import me.duco.file.FileFormatter;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Callback implements MqttCallback {
    public void connectionLost(Throwable throwable) {
        System.out.println("Connecting was lost.");
    }

    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        System.out.println("Message received: " + new String(mqttMessage.getPayload()));

        FileFormatter log = new FileFormatter(false);

        log.log(new String(mqttMessage.getPayload()), topic);
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
