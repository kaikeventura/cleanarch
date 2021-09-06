package com.kaikeventura.cleanarch.payment.adapters.configuration;

import com.kaikeventura.cleanarch.CleanarchApplication;
import com.kaikeventura.cleanarch.payment.adapters.outbound.persistence.H2PaymentRepositoryPersistence;
import com.kaikeventura.cleanarch.payment.adapters.outbound.producers.KafkaProducer;
import com.kaikeventura.cleanarch.payment.application.services.PaymentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CleanarchApplication.class)
public class BeanConfiguration {

    @Bean
    public PaymentServiceImpl paymentServiceImpl(
        final H2PaymentRepositoryPersistence paymentRepositoryPort,
        final KafkaProducer paymentNotifier
    ) {
        return new PaymentServiceImpl(paymentRepositoryPort, paymentNotifier);
    }

}
