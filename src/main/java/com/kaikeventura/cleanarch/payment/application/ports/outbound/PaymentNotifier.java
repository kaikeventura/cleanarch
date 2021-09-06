package com.kaikeventura.cleanarch.payment.application.ports.outbound;

import com.kaikeventura.cleanarch.payment.application.domain.Payment;

public interface PaymentNotifier {
    void notifyPayment(String topicName, Payment payment);
}
