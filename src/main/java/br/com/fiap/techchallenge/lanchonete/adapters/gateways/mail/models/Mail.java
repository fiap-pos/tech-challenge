package br.com.fiap.techchallenge.lanchonete.adapters.gateways.mail.models;

import java.util.List;

public record Mail(MailId from, List<MailId> to, String subject, String text) {
}
