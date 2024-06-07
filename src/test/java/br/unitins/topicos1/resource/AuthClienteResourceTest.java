package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.LoginDTO;
import io.restassured.http.ContentType;

class AuthClienteResourceTest {
    
     @Test
    public void loginClienteTest() {

        LoginDTO authCliente = new LoginDTO("joao", "senha123");

        given()
            .contentType(ContentType.JSON)
            .body(authCliente)
            .when().post("/auth/admin")
            .then()
            .statusCode(200);
    }

    @Test
    public void loginClienteFailed() {

        LoginDTO authCliente = new LoginDTO("JoaoA", "joao12345");

        given()
            .contentType(ContentType.JSON)
            .body(authCliente)
            .when().post("/auth")
            .then()
            .statusCode(404);
    }
}
