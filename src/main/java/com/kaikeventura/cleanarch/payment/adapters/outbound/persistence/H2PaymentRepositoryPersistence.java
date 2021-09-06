package com.kaikeventura.cleanarch.payment.adapters.outbound.persistence;

import com.kaikeventura.cleanarch.payment.adapters.outbound.persistence.entities.PaymentEntity;
import com.kaikeventura.cleanarch.payment.adapters.outbound.persistence.repositories.PaymentRepositoryJPA;
import com.kaikeventura.cleanarch.payment.application.domain.Payment;
import com.kaikeventura.cleanarch.payment.application.ports.outbound.PaymentRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
@Primary
public class H2PaymentRepositoryPersistence implements PaymentRepositoryPort {

    private final PaymentRepositoryJPA paymentRepositoryJPA;

    @Override
    public Payment save(final Payment payment) {
        var paymentEntity = new PaymentEntity();
        BeanUtils.copyProperties(payment, paymentEntity);

        var savedPaymentEntity = paymentRepositoryJPA.save(paymentEntity);
        var savedPayment = new Payment();
        BeanUtils.copyProperties(savedPaymentEntity, savedPayment);

        return savedPayment;
    }

}
