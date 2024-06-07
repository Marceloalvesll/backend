package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;


import br.unitins.topicos1.dto.AlterarNomeDTO;
import br.unitins.topicos1.dto.AlterarSenhaDTO;
import br.unitins.topicos1.dto.AlterarSobrenomeDTO;
import br.unitins.topicos1.service.ClienteService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.quarkus.test.security.jwt.Claim;
import io.quarkus.test.security.jwt.ClaimType;
import io.quarkus.test.security.jwt.JwtSecurity;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

@QuarkusTest
class ClienteLogadoResourceTest {
    @Inject
    ClienteService clienteService;

    @Test
    @TestSecurity(user = "testUser", roles = { "CLIENTE" })
    @JwtSecurity(claims = { @Claim(key = "sub", value = "1", type = ClaimType.LONG) })
    public void alterarSenhaTest() {

        AlterarSenhaDTO senhaDTO = new AlterarSenhaDTO("joao1234", "password");

        given()

                .contentType(ContentType.JSON)
                .body(senhaDTO)
                .when()
                .patch("clientelogado/alterar-senha")
                .then()
                .statusCode(204);
    }

       @Test
        @TestSecurity(user = "testUser", roles = {"CLIENTE"})
          @JwtSecurity(
        claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
    )
    public void alterarNomeTest() {


        AlterarNomeDTO nomeDTO = new AlterarNomeDTO("Maria Joaquina");

        given()
            
            .contentType(ContentType.JSON)
                .body(nomeDTO)
            .when()
                .patch("clientelogado/alterar-nome")
            .then()
                .statusCode(204);
    }

            @Test
        @TestSecurity(user = "testUser", roles = {"CLIENTE"})
          @JwtSecurity(
        claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
    )
    public void alterarCargoTest() {


        AlterarSobrenomeDTO cargoDTO = new AlterarSobrenomeDTO("Santos");

        given()
            
            .contentType(ContentType.JSON)
                .body(cargoDTO)
            .when()
                .patch("clientelogado/alterar-sobrenome")
            .then()
                .statusCode(204);
    }
}
