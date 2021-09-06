package com.kaikeventura.cleanarch.payment.application.domain;

import java.math.BigDecimal;

public class Payment {

    private Long id;
    private BigDecimal value;

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(final BigDecimal value) {
        this.value = value;
    }

}
