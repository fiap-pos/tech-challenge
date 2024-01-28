package br.com.fiap.techchallenge.lanchonete.bdd.cliente;

import br.com.fiap.techchallenge.lanchonete.bdd.SpringIntegrationTest;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static br.com.fiap.techchallenge.lanchonete.utils.ClienteHelper.getClienteRequest;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CadastraCliente extends SpringIntegrationTest {

    private Response response;

    private final String ENDPOINT_API_CLIENTES = "http://localhost:8080/clientes";

    @Quando("cadastrar um novo cliente")
    public void cadastrar_um_novo_cliente() {
        var clienteRequest = getClienteRequest(
                "Cliente 1",
                "94187479015",
                "cliente1@gmail.com"
        );

        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(clienteRequest)
                .post(ENDPOINT_API_CLIENTES);
    }
    @Então("o cliente cadastrado deve retornar sucesso")
    public void o_cliente_cadastrado_deve_retornar_sucesso() {
        response.then()
                .statusCode(HttpStatus.CREATED.value());
    }
    @E("este cliente deve ser apresentado")
    public void este_cliente_deve_ser_apresentado() {
        response.then()
                .log().all()
                .body(matchesJsonSchemaInClasspath("schemas/cliente.schema.json"));
    }

}
