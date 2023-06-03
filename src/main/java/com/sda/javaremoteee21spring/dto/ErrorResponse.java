package com.sda.javaremoteee21spring.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ErrorResponse(
        LocalDate timestamp,
        int status,
        String error,
        String message,
        String path

) {
}
