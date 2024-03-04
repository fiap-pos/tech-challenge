package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.SpringIntegrationTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getProdutoSemID;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class ProdutoControllerIT extends SpringIntegrationTest {

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