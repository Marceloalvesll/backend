package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.LoginDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
class AuthAdminResourceTest {
    
    @Test
    public void AdminLoginTest() {

        LoginDTO authAdmin = new LoginDTO("joao", "senha123");

        given()
            .contentType(ContentType.JSON)
            .body(authAdmin)
            .when().post("/auth/admin")
            .then()
            .statusCode(200);
    }

    @Test
    public void loginAdminFailed() {

        LoginDTO authAdmin = new LoginDTO("JoaoA", "joao12345");

        given()
            .contentType(ContentType.JSON)
            .body(authAdmin)
            .when().post("/auth")
            .then()
            .statusCode(404);
    }

}
