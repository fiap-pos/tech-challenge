package br.com.fiap.techchallenge.lanchonete.core.domain.entities;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class QrCode {

    private final String value;

    private final String base64Pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$";

    public QrCode(String value) {
        this.value = value;
    }

    public String getDecodedBase64Value() {
        if (valueIsBase64Encoded()) {
            return new String(Base64.getDecoder().decode(value));
        }
        return value;
    }

    public String getEncodedBase64Value() {
        if (valueIsBase64Encoded()) {
            return value;
        }
        return Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
    }

    private Boolean valueIsBase64Encoded() {
        return value.matches(base64Pattern);
    }
}
