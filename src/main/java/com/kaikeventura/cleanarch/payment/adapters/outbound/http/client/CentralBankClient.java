package com.kaikeventura.cleanarch.payment.adapters.outbound.http.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "CentralBank", url = "${external.central-bank.url}")
public interface CentralBankClient {

    @GetMapping
    ResponseEntity<Void> confirmPayment();
}
