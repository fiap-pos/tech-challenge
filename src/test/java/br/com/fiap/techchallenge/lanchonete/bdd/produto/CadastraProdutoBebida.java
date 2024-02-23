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

public class CadastraProdutoBebida extends CucumberSpringIntegrationTest {

    private Response response;

    private final String ENDPOINT_API_PRODUTOS = "http://localhost:8080/produtos";

    @Quando("criar cadastrar um novo produto do tipo bebida")
    public void criar_cadastrar_um_novo_produto_do_tipo_bebida() {
        var produtoRequest = getProdutoRequest(
                "COCA-COLA LATA",
                CategoriaEnum.BEBIDA,
                BigDecimal.valueOf(7.50),
                "Coca-Cola Lata 350 ml"
        );

        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(produtoRequest)
                .post(ENDPOINT_API_PRODUTOS);
    }
    @Então("o produto do tipo bebida retornar com sucesso")
    public void o_produto_do_tipo_bebida_retornar_com_sucesso() {
        response.then()
                .statusCode(HttpStatus.CREATED.value());
    }
    @E("este produto do tipo bebida deve ser apresentado")
    public void este_produto_do_tipo_bebida_deve_ser_apresentado() {
        response.then()
                .log().all()
                .body(matchesJsonSchemaInClasspath("schemas/produto.schema.json"));
    }

}
