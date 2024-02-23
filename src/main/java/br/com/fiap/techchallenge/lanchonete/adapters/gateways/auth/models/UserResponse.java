package br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserResponse (
    String id,
    String name,
    String username,
    String email,
    List<UserRole> roles
) {

}
