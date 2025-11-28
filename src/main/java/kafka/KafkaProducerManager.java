package kafka;

public class KafkaProducerManager {
    public static void send(String topic, String message) {
        // Here you set Producer config and send event
        System.out.println("Kafka Producer -> " + topic + ": " + message);
    }
}
