package br.com.fiap.techchallenge.lanchonete.core.domain.exception;

public class ErrorDetails {

    private String message;
    private int status;
    private long timestamp;

    public ErrorDetails() {
    }

    private ErrorDetails(String message, int status, long timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    public ErrorDetails message(String message) {
        this.message = message;
        return this;
    }

    public ErrorDetails status(int status) {
        this.status = status;
        return this;
    }

    public ErrorDetails timestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public ErrorDetails build() {
        return new ErrorDetails(message, status, timestamp);
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
