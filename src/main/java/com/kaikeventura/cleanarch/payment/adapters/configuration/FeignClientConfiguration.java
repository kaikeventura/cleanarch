package com.kaikeventura.cleanarch.payment.adapters.configuration;

import com.kaikeventura.cleanarch.CleanarchApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableFeignClients(basePackageClasses = CleanarchApplication.class)
public class FeignClientConfiguration {
}
