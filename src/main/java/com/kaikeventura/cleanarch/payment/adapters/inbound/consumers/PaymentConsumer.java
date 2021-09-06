package com.kaikeventura.cleanarch.payment.adapters.inbound.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaikeventura.cleanarch.payment.application.domain.Payment;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kaikeventura.cleanarch.payment.adapters.outbound.http.client.CentralBankClient;

@Component
@AllArgsConstructor
public class PaymentConsumer {

    private final CentralBankClient centralBankClient;

    @KafkaListener(topics = "registered_payment_success", groupId = "clean-arch")
    public void registeredPaymentSuccess(ConsumerRecord<String, String> payload) {
        var objectMapper = new ObjectMapper();
        try {
            var payment = objectMapper.readValue(payload.value(), Payment.class);
            centralBankClient.confirmPayment();
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
    }

}
