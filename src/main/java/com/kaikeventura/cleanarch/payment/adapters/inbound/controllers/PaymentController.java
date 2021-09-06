package com.kaikeventura.cleanarch.payment.adapters.inbound.controllers;

import com.kaikeventura.cleanarch.payment.adapters.infra.dtos.PaymentDTO;
import com.kaikeventura.cleanarch.payment.application.domain.Payment;
import com.kaikeventura.cleanarch.payment.application.ports.inbound.PaymentServicePort;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentServicePort paymentServicePort;

    @PostMapping
    public ResponseEntity<Payment> registerPayment(@RequestBody final PaymentDTO paymentDTO) {
        var payment = new Payment();
        BeanUtils.copyProperties(paymentDTO, payment);
        var registeredPayment = this.paymentServicePort.registerPayment(payment);

        return ResponseEntity.ok(registeredPayment);
    }

}
