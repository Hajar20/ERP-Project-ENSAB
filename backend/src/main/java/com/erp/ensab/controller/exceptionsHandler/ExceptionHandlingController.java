package com.erp.ensab.controller.exceptionsHandler;

import com.erp.ensab.exceptions.CandidateAlreadyExistsException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandlingController {


    @ExceptionHandler(value = {CandidateAlreadyExistsException.class})
    public ResponseEntity<String> handleProductAlreadyExists(CandidateAlreadyExistsException  ex) {
        return ResponseEntity.badRequest().body("Candidate already exists.");
    }

}
