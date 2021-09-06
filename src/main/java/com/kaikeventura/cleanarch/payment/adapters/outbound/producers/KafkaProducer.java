package com.kaikeventura.cleanarch.payment.adapters.outbound.producers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaikeventura.cleanarch.payment.application.domain.Payment;
import com.kaikeventura.cleanarch.payment.application.ports.outbound.PaymentNotifier;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class KafkaProducer implements PaymentNotifier {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void notifyPayment(final String topicName, final Payment payment) {
        try {
            var paymentJsonBody = this.buildSuccessPaymentJsonBody(payment);
            this.publish(topicName, paymentJsonBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
    }

    private String buildSuccessPaymentJsonBody(final Payment payment) throws JsonProcessingException {
        var objectMapper = new ObjectMapper();
        var paymentBody = Map.of(
            "payment_id", payment.getId(),
            "payment_value", payment.getValue()
        );

        return objectMapper.writeValueAsString(paymentBody);
    }

    private void publish(final String topicName, final String jsonBody) {
        this.kafkaTemplate.send(topicName, jsonBody);
    }

}
