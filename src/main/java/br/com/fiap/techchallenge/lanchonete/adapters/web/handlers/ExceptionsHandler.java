package br.com.fiap.techchallenge.lanchonete.adapters.web.handlers;

import br.com.fiap.techchallenge.lanchonete.core.domain.exceptions.BadRequestException;
import br.com.fiap.techchallenge.lanchonete.core.domain.exceptions.EntityAlreadyExistException;
import br.com.fiap.techchallenge.lanchonete.core.domain.exceptions.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.ConnectException;
import java.util.Objects;

@ControllerAdvice
public class ExceptionsHandler {
    Logger logger = LoggerFactory.getLogger(ExceptionsHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDetails> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        var errorDetails = new ErrorDetails.Builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(e.getAllErrors().get(0).getDefaultMessage())
                .timestamp(System.currentTimeMillis())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDetails> handlerHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
        var errorDetails = new ErrorDetails.Builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(Objects.requireNonNull(e.getRootCause()).getMessage())
                .timestamp(System.currentTimeMillis())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDetails> handlerBadRequestException(BadRequestException e, HttpServletRequest request) {
        var errorDetails = new ErrorDetails.Builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(e.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    @ExceptionHandler(EntityAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorDetails> handlerEntityAlreadyExistException(EntityAlreadyExistException e, HttpServletRequest request) {
        var errorDetails = new ErrorDetails.Builder()
                .status(HttpStatus.CONFLICT.value())
                .message(e.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDetails> handlerEntityNotFoundException(EntityNotFoundException e, HttpServletRequest request) {
        var errorDetails = new ErrorDetails.Builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<ErrorDetails> handlerNoResourceFoundException(IllegalArgumentException e, HttpServletRequest request) {
        var errorDetails = new ErrorDetails.Builder()
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .message(e.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();
        logger.error(e.getMessage(), e);

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorDetails);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ResponseEntity<ErrorDetails> handlerNoResourceFoundException(ConnectException e, HttpServletRequest request) {
        var errorDetails = new ErrorDetails.Builder()
                .status(HttpStatus.SERVICE_UNAVAILABLE.value())
                .message(e.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();
        logger.error(e.getMessage(), e);

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorDetails);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDetails> handlerException(Exception e, HttpServletRequest request) {
        var errorDetails = new ErrorDetails.Builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();
        logger.error(e.getMessage(), e);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }

}
