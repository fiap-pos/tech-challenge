package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.SpringIntegrationTest;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.models.UserResponse;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.models.UserRole;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.ItemPedidoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.PedidoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.ProdutoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.responses.ProdutoResponse;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.CategoriaEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.math.BigDecimal;
import java.util.List;
import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getProdutoRequest;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class PedidoControllerIT extends SpringIntegrationTest {

    @Test
    void criaUmPedidoComLancheEBebidaComClienteCadastrado() throws Exception {
        var authorization = "Bearer token-customer";
        var id = "user-id";

        mockAuthGatewayRequest(authorization, id, getCustomerResponseBody(id, UserRole.CUSTOMER));

        var lanche = getProdutoRequest(
                "HAMBURGER ANGUS",
                CategoriaEnum.LANCHE,
                BigDecimal.valueOf(35.90),
                "Hamburger Angus 200mg de carne"
        );
        var bebida = getProdutoRequest(
                "COCA-COLA LATA",
                CategoriaEnum.BEBIDA,
                BigDecimal.valueOf(7.50),
                "Coca-Cola Lata 350 ml"
        );

        var lancheId = cadastraUmNovoProduto(lanche);
        var bebidaId = cadastraUmNovoProduto(bebida);

        var itemPedidoRequest1 = new ItemPedidoRequest(lancheId, 2);
        var itemPedidoRequest2 = new ItemPedidoRequest(bebidaId, 2);
        var pedidoRequest = new PedidoRequest(List.of(itemPedidoRequest1, itemPedidoRequest2));

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("Authorization", authorization)
                .body(pedidoRequest)
        .when()
                .post("/pedidos")
        .then()
                .log().all()
                .statusCode(HttpStatus.CREATED.value())
                .body(matchesJsonSchemaInClasspath("schemas/pedido-com-cliente.schema.json"));
    }

    @Test
    void criaUmPedidoComLancheEBebidaSemClienteCadastrado() throws Exception {
        var authorization = "Bearer token-guest";
        var id = "user-id";

        mockAuthGatewayRequest(authorization, id, getCustomerResponseBody(id, UserRole.GUEST));

        var lanche = getProdutoRequest(
                "HAMBURGER ANGUS",
                CategoriaEnum.LANCHE,
                BigDecimal.valueOf(35.90),
                "Hamburger Angus 200mg de carne"
        );
        var bebida = getProdutoRequest(
                "COCA-COLA LATA",
                CategoriaEnum.BEBIDA,
                BigDecimal.valueOf(7.50),
                "Coca-Cola Lata 350 ml"
        );

        var lancheId = cadastraUmNovoProduto(lanche);
        var bebidaId = cadastraUmNovoProduto(bebida);

        var itemPedidoRequest1 = new ItemPedidoRequest(lancheId, 2);
        var itemPedidoRequest2 = new ItemPedidoRequest(bebidaId, 2);
        var pedidoRequest = new PedidoRequest(List.of(itemPedidoRequest1, itemPedidoRequest2));


        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("Authorization", authorization)
                .body(pedidoRequest)
        .when()
                .post("/pedidos")
        .then()
                .log().all()
                .statusCode(HttpStatus.CREATED.value());
    }

    private Long cadastraUmNovoProduto(ProdutoRequest produtoRequest) throws Exception {
        var responseBody = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(produtoRequest)
                .when()
                .post("/produtos")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.CREATED.value())
                .body(matchesJsonSchemaInClasspath("schemas/produto.schema.json"))
                .extract()
                .body();

        var produto = responseBody.as(ProdutoResponse.class);
        return produto.getId();
    }

    private void cadastraUmNovoProdutoBebida() throws Exception {
        var produtoRequest = getProdutoRequest(
                "COCA-COLA LATA",
                CategoriaEnum.BEBIDA,
                BigDecimal.valueOf(7.50),
                "Coca-Cola Lata 350 ml"
        );

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(produtoRequest)
        .when()
                .post("/produtos")
        .then()
                .log().all()
                .statusCode(HttpStatus.CREATED.value())
                .body(matchesJsonSchemaInClasspath("schemas/produto.schema.json"));

    }

    private void mockAuthGatewayRequest(String authorization, String id, String response) {
        wiremock.stubFor(
                WireMock.get(WireMock.urlEqualTo("/auth/info"))
                        .withHeader("Authorization", WireMock.equalTo(authorization))
                        .willReturn(
                                WireMock.aResponse()
                                    .withStatus(200)
                                    .withHeader("Content-Type", "application/json")
                                    .withBody(response)
                                )
                        );

        wiremock.stubFor(
                WireMock.get(WireMock.urlEqualTo("/users/" + id))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(200)
                                        .withHeader("Content-Type", "application/json")
                                        .withBody(response)
                                )
                        );
    }

    private String getCustomerResponseBody(String id, UserRole role) throws JsonProcessingException {
        return objectMapper.writeValueAsString(
                new UserResponse(
                    id,
                    "user-name",
                    "user-username",
                    "user-email",
                    List.of(role)
                )
            );
    }
}