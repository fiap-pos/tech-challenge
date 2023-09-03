package br.com.fiap.techchallenge.lanchonete.core.domain.exceptions;

public class PaymentErrorException extends RuntimeException{
    public PaymentErrorException(String message) {
        super(message);
    }

    public PaymentErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public PaymentErrorException(Throwable cause) {
        super(cause);
    }
}
