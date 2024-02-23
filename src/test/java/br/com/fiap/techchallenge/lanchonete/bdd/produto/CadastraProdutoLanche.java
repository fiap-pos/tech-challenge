package br.com.fiap.techchallenge.lanchonete.bdd.produto;

import br.com.fiap.techchallenge.lanchonete.bdd.CucumberSpringIntegrationTest;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.CategoriaEnum;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.math.BigDecimal;

import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getProdutoRequest;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CadastraProdutoLanche extends CucumberSpringIntegrationTest {

    private Response response;

    private final String ENDPOINT_API_PRODUTOS = "http://localhost:8080/produtos";

    @Quando("cadastrar um novo produto do tipo lanche")
    public void cadastrar_um_novo_produto_do_tipo_lanche() {
        var produtoRequest = getProdutoRequest(
                "HAMBURGER ANGUS",
                CategoriaEnum.LANCHE,
                BigDecimal.valueOf(35.90),
                "Hamburger Angus 200mg de carne"
        );

        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(produtoRequest)
                .post(ENDPOINT_API_PRODUTOS);
    }

    @Então("o produto do tipo lanche retornar sucesso")
    public void o_produto_do_tipo_lanche_retornar_sucesso() {
        response.then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @E("este produto do tipo lanche deve ser apresentado")
    public void este_produto_do_tipo_lanche_deve_ser_apresentado() {
        response.then()
                .log().all()
                .body(matchesJsonSchemaInClasspath("schemas/produto.schema.json"));
    }

}
