package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.io.Closeable;
import java.io.IOException;

public class FraudDetectorService {

    public static void main(String[] args) throws InterruptedException {
        var fraudService = new FraudDetectorService();
        try (var service = new KafkaService(FraudDetectorService.class.getName(),
                "ECOMMERCE_NEW_ORDER",
                fraudService::parse)) {
             service.run();
        }
    }

    private void parse(ConsumerRecord<String, String> record) throws InterruptedException {
        System.out.println("----------------------------------------");
        System.out.println("Processing new order, checking for fraud");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());
        Thread.sleep(5000);
        System.out.println("Order processed");
    }
}
