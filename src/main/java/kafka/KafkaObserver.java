package kafka;

import observer.LoginObserver;

public class KafkaObserver implements LoginObserver {

    @Override
    public void onLoginEvent(String message) {
        System.out.println("Sending to Kafka: " + message);

        // Actual Kafka producer call
        // (Simplified)
        KafkaProducerManager.send("login-events", message);
    }
}
