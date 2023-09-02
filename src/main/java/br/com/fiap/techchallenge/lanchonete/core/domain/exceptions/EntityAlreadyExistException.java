package br.com.fiap.techchallenge.lanchonete.core.domain.exceptions;

public class EntityAlreadyExistException extends RuntimeException {

    public EntityAlreadyExistException(String message) {
        super(message);
    }

    public EntityAlreadyExistException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public EntityAlreadyExistException(Throwable throwable) {
        super(throwable);
    }
}
