package br.com.fiap.techchallenge.lanchonete.adapters.web;

import io.restassured.RestAssured;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getProdutoSemID;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@Transactional
class ProdutoControllerIT {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void cadastraUmNovoProduto() throws Exception {
        var produto = getProdutoSemID();

        given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(produto)
        .when()
            .post("/produtos")
        .then()
            .log().all()
            .statusCode(HttpStatus.CREATED.value())
            .body(matchesJsonSchemaInClasspath("schemas/produto.schema.json"));

    }

}