package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.SpringIntegrationTest;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.AuthGateway;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.ItemPedidoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.PedidoRequest;
import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.CategoriaEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.math.BigDecimal;
import java.util.List;
import static br.com.fiap.techchallenge.lanchonete.utils.ProdutoHelper.getProdutoRequest;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.mockito.Mockito.when;

class PedidoControllerIT extends SpringIntegrationTest {

    @MockBean
    private AuthGateway authGateway;

    @Test
    void criaUmPedidoComLancheEBebidaComClienteCadastrado() throws Exception {
        var authorization = "Bearer token";


        cadastraUmNovoProdutoLanche();
        cadastraUmNovoProdutoBebida();

        var clienteDTO = new ClienteDTO(
                "id-cliente",
                "Novo Cliente",
                "12345678901",
                "email@cliente.com"
        );

        when(authGateway.buscarPorToken(authorization)).thenReturn(clienteDTO);
        when(authGateway.buscarPorId(clienteDTO.id())).thenReturn(clienteDTO);

        var itemPedidoRequest1 = new ItemPedidoRequest(1L, 2);
        var itemPedidoRequest2 = new ItemPedidoRequest(2L, 2);
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
        cadastraUmNovoProdutoLanche();
        cadastraUmNovoProdutoBebida();

        var itemPedidoRequest1 = new ItemPedidoRequest(1L, 2);
        var itemPedidoRequest2 = new ItemPedidoRequest(2L, 2);
        var pedidoRequest = new PedidoRequest(List.of(itemPedidoRequest1, itemPedidoRequest2));
        var authorization = "Bearer token";

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

    @Test
    void cadastraUmNovoProdutoLanche() throws Exception {
        var produtoRequest = getProdutoRequest(
                "HAMBURGER ANGUS",
                CategoriaEnum.LANCHE,
                BigDecimal.valueOf(35.90),
                "Hamburger Angus 200mg de carne"
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

    @Test
    void cadastraUmNovoProdutoBebida() throws Exception {
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
}