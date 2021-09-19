package com.kaikeventura.cleanarch.common.adapters.inbound.logging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Log
public class LoggingService {

    public void logRequest(HttpServletRequest httpServletRequest, Object body) throws JsonProcessingException {
        var stringBuilder = new StringBuilder();
        var mapper = new ObjectMapper();

        stringBuilder.append("REQUEST ");
        stringBuilder.append("method=[").append(httpServletRequest.getMethod()).append("] ");
        stringBuilder.append("path=[").append(httpServletRequest.getRequestURI()).append("] ");

        if (body != null) {
            stringBuilder
                    .append("body=[")
                    .append(body.getClass().getSimpleName())
                    .append(" => ")
                    .append(mapper.writeValueAsString(body))
                    .append("]");
        }

        log.info(stringBuilder.toString());
    }

    public void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object body) throws JsonProcessingException {
        var stringBuilder = new StringBuilder();
        var mapper = new ObjectMapper();

        stringBuilder.append("RESPONSE ");
        stringBuilder.append("method=[").append(httpServletRequest.getMethod()).append("] ");
        stringBuilder.append("path=[").append(httpServletRequest.getRequestURI()).append("] ");

        if (body != null) {
            stringBuilder
                    .append("body=[")
                    .append(body.getClass().getSimpleName())
                    .append(" => ")
                    .append(mapper.writeValueAsString(body))
                    .append("]");
        }

        log.info(stringBuilder.toString());
    }
}
