package com.kaikeventura.cleanarch.payment.application.services;

import com.kaikeventura.cleanarch.payment.application.domain.Payment;
import com.kaikeventura.cleanarch.payment.application.ports.inbound.PaymentServicePort;
import com.kaikeventura.cleanarch.payment.application.ports.outbound.PaymentNotifierPort;
import com.kaikeventura.cleanarch.payment.application.ports.outbound.PaymentRepositoryPort;

public class PaymentServiceImpl implements PaymentServicePort {

    private static final String REGISTERED_PAYMENT_SUCCESS_TOPIC_NAME = "registered_payment_success";

    private final PaymentRepositoryPort paymentRepositoryPort;
    private final PaymentNotifierPort paymentNotifierPort;

    public PaymentServiceImpl(
        final PaymentRepositoryPort paymentRepositoryPort,
        final PaymentNotifierPort paymentNotifierPort
    ) {
        this.paymentRepositoryPort = paymentRepositoryPort;
        this.paymentNotifierPort = paymentNotifierPort;
    }

    @Override
    public Payment registerPayment(final Payment payment) {
        var registeredPayment = this.paymentRepositoryPort.save(payment);
        paymentNotifierPort.notifyPayment(REGISTERED_PAYMENT_SUCCESS_TOPIC_NAME, payment);

        return registeredPayment;
    }

}
