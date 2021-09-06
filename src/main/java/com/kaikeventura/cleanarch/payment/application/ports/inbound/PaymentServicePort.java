package com.kaikeventura.cleanarch.payment.application.ports.inbound;

import com.kaikeventura.cleanarch.payment.application.domain.Payment;

public interface PaymentServicePort {
    Payment registerPayment(Payment payment);
}
