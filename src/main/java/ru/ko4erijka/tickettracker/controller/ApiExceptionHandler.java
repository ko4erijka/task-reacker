package ru.ko4erijka.tickettracker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.ko4erijka.tickettracker.dto.ErrorDTO;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleException(Exception e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        List<String> messages = e.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> String.format("Поле [%s] не прошло валидацию. [%s]"
                        , fieldError.getField()
                        , fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(new ErrorDTO(HttpStatus.UNPROCESSABLE_ENTITY.value(), messages), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
