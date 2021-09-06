package com.kaikeventura.cleanarch.payment.adapters.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentDTO {
    private BigDecimal value;
}