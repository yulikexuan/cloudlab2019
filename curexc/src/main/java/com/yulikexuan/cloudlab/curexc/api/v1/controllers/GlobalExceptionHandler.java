//: com.yulikexuan.cloudlab.curexc.api.v1.controllers.GlobalExceptionHandler.java


package com.yulikexuan.cloudlab.curexc.api.v1.controllers;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(
            NotFoundException exception, WebRequest webRequest) {

        return new ResponseEntity<>(exception.toString(), new HttpHeaders(),
                HttpStatus.NOT_FOUND);
    }

}///:~