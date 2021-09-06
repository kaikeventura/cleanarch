package com.kaikeventura.cleanarch.payment.application.ports.outbound;

import com.kaikeventura.cleanarch.payment.application.domain.Payment;

public interface PaymentNotifierPort {
    void notifyPayment(String topicName, Payment payment);
}
