package com.kaikeventura.cleanarch.common.adapters.inbound.logging;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;

@ControllerAdvice
@AllArgsConstructor
public class RequestLogging extends RequestBodyAdviceAdapter {

    private final LoggingService loggingService;
    private final HttpServletRequest httpServletRequest;

    @Override
    public boolean supports(
        final MethodParameter methodParameter,
        final Type targetType,
        final Class<? extends HttpMessageConverter<?>> converterType
    ) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object afterBodyRead(
        final Object body,
        final HttpInputMessage inputMessage,
        final MethodParameter parameter,
        final Type targetType,
        final Class<? extends HttpMessageConverter<?>> converterType
    ) {
        loggingService.logRequest(httpServletRequest, body);

        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }

}
