package br.com.fiap.techchallenge.lanchonete.core.exceptions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UnexpectedDomainExceptionTest {
    @Test
    void testConstructor() {
        UnexpectedDomainException actualUnexpectedDomainException = new UnexpectedDomainException("An error occurred");
        assertThat("An error occurred").isEqualTo(actualUnexpectedDomainException.getMessage());
    }
}