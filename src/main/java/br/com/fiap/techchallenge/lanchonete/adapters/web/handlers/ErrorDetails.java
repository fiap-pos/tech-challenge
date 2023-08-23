package br.com.fiap.techchallenge.lanchonete.adapters.web.handlers;

public record ErrorDetails(String message, int status, long timestamp) {

    public static class Builder {

        String message;
        int status;
        long timestamp;

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorDetails build() {
            return new ErrorDetails(message, status, timestamp);
        }
    }

}
