package br.com.fiap.techchallenge.lanchonete.core.domain.exception;

public class ProdutoNotFoundException extends RuntimeException {

    public ProdutoNotFoundException(String message) {
        super(message);
    }

    public ProdutoNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ProdutoNotFoundException(Throwable throwable) {
        super(throwable);
    }

}
