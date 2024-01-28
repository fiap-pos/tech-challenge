package br.com.fiap.techchallenge.lanchonete.bdd.pedido;

import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.ItemPedidoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.PedidoRequest;
import br.com.fiap.techchallenge.lanchonete.bdd.SpringIntegrationTest;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class FazPedidoSemCliente extends SpringIntegrationTest {

    private Response response;

    private final String ENDPOINT_API_PEDIDOS = "http://localhost:8080/pedidos";

    @Quando("criar um novo pedido sem informar o cliente")
    public void criar_um_novo_pedido_sem_informar_o_cliente() {
        var itemPedidoRequest1 = new ItemPedidoRequest(1L, 2);
        var itemPedidoRequest2 = new ItemPedidoRequest(2L, 2);
        var pedidoRequest = new PedidoRequest(List.of(itemPedidoRequest1, itemPedidoRequest2));

        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(pedidoRequest)
                .post(ENDPOINT_API_PEDIDOS);
    }
    @Então("o pedido é criado com sucesso sem cliente apresentado")
    public void o_pedido_é_criado_com_sucesso_sem_cliente_apresentado() {
        response.then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @E("deve ser apresentado sem cliente")
    public void deve_ser_apresentado_sem_cliente() {
        response.then()
                .log().all()
                .body(matchesJsonSchemaInClasspath("schemas/pedido-sem-cliente.schema.json"));
    }

}
