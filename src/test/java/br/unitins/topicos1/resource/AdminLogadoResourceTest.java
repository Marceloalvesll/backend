package br.unitins.topicos1.resource;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.AlterarCargoDTO;
import br.unitins.topicos1.dto.AlterarNomeDTO;
import br.unitins.topicos1.dto.AlterarSenhaDTO;
import br.unitins.topicos1.service.AdministradorService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.quarkus.test.security.jwt.Claim;
import io.quarkus.test.security.jwt.ClaimType;
import io.quarkus.test.security.jwt.JwtSecurity;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

@QuarkusTest
class AdminLogadoResourceTest {
    
    @Inject
    AdministradorService adminService;
  
    @Test
        @TestSecurity(user = "testUser", roles = {"ADMIN"})
          @JwtSecurity(
        claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
    )
    public void alterarSenhaTest() {


        AlterarSenhaDTO senhaDTO = new AlterarSenhaDTO("joao1234", "password");

        given()
            
            .contentType(ContentType.JSON)
                .body(senhaDTO)
            .when()
                .patch("adminlogado/alterar-senha")
            .then()
                .statusCode(204);
    }

        @Test
        @TestSecurity(user = "testUser", roles = {"ADMIN"})
          @JwtSecurity(
        claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
    )
    public void alterarNomeTest() {


        AlterarNomeDTO nomeDTO = new AlterarNomeDTO("Maria Joaquina");

        given()
            
            .contentType(ContentType.JSON)
                .body(nomeDTO)
            .when()
                .patch("adminlogado/alterar-nome")
            .then()
                .statusCode(204);
    }

            @Test
        @TestSecurity(user = "testUser", roles = {"ADMIN"})
          @JwtSecurity(
        claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
    )
    public void alterarCargoTest() {


        AlterarCargoDTO cargoDTO = new AlterarCargoDTO("SUPERVISOR");

        given()
            
            .contentType(ContentType.JSON)
                .body(cargoDTO)
            .when()
                .patch("adminlogado/alterar-cargo")
            .then()
                .statusCode(204);
    }
}

