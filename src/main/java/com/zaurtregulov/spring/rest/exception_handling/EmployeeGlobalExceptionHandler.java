package com.zaurtregulov.spring.rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<ExceptionInformation> handleException(NoSuchEmployeeException exception){

        ExceptionInformation exceptionInformation = new ExceptionInformation();

        exceptionInformation.setInformation(exception.getMessage());

        return new ResponseEntity<>(exceptionInformation, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<ExceptionInformation> handleException(Exception exception){
        ExceptionInformation exceptionInformation = new ExceptionInformation();
        exceptionInformation.setInformation(exception.getMessage());

        return new ResponseEntity<>(exceptionInformation, HttpStatus.BAD_REQUEST);
    }




}
