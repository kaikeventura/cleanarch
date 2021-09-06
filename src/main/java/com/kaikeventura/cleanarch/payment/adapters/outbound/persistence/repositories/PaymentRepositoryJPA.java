package com.kaikeventura.cleanarch.payment.adapters.outbound.persistence.repositories;

import com.kaikeventura.cleanarch.payment.adapters.outbound.persistence.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepositoryJPA extends JpaRepository<PaymentEntity, Long> {
}
