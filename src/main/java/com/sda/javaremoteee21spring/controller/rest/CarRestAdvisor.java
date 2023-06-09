package com.sda.javaremoteee21spring.controller.rest;


import com.sda.javaremoteee21spring.dto.ErrorResponse;
import com.sda.javaremoteee21spring.exception.CarNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;

@RestControllerAdvice("com.sda.javaremoteee21spring.controller.rest")
public class CarRestAdvisor {


    @ExceptionHandler(CarNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundCarException(CarNotFoundException exception) {


        String currentRequestPath = ServletUriComponentsBuilder.fromCurrentRequest()
                .build()
                .getPath();

        return ErrorResponse.builder()
                .timestamp(LocalDate.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Car no found")
                .message(exception.getMessage())
                .path(currentRequestPath)
                .build();
    }


}
