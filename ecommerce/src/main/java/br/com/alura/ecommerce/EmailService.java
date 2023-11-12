package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class EmailService {

    public static void main(String[] args) throws InterruptedException {
        var emailService = new EmailService();
        var service = new KafkaService(EmailService.class.getName(), "ECOMMERCE_SEND_EMAIL",
                emailService::parse);
        service.run();
    }

    private void parse(ConsumerRecord<String, String> record) throws InterruptedException {
        System.out.println("----------------------------------------");
        System.out.println("Send email");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());
        Thread.sleep(5000);
        System.out.println("Email sent");
    }
}

