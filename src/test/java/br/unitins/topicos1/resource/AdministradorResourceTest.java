package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.AdministradorDTO;
import br.unitins.topicos1.dto.AdministradorResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.service.AdministradorService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.quarkus.test.security.jwt.Claim;
import io.quarkus.test.security.jwt.ClaimType;
import io.quarkus.test.security.jwt.JwtSecurity;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.given;

@QuarkusTest
class AdministradorResourceTest {
    @Inject
    AdministradorService service;

    @Test
    @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
          @JwtSecurity(
        claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
    )
    void insert() {
        AdministradorDTO dto = new AdministradorDTO(
                "Maria Luzia Nunes",
                "marialuiza",
                "243.705.128-75",
                "marialuzianunes@gmail.com",
                "12345688",
                "Gerente",
                List.of(new TelefoneDTO("3966-0150", "63", "Vivo"))
        );

        given()
                .contentType(ContentType.JSON)
                .body(dto)
                .when().post("/administrador")
                .then()
                .statusCode(201)
                .body(
                        "id", notNullValue(),
                        "nome", is("Maria Luzia Nunes"),
                        "cpf", is("243.705.128-75")
                );
    }

    @Test
    @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
    @JwtSecurity(
        claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
    )
    void update() {
        new AdministradorDTO(
                "Maria Luzia Nunes",
                "marialuiza",
                "243.705.128-75",
                "marialuzianunes@gmail.com",
                "221312333",
                "Gerente",
                List.of(new TelefoneDTO("3966-0150", "63", "Vivo"))
        );
      

        AdministradorDTO dtoUpdate = new AdministradorDTO(
                null,
                null,
                null,
                "marialuzia@gmail.com",
                null,
                "Diretora",
                null
        );
        given()
                .contentType(ContentType.JSON)
                .body(dtoUpdate)
                .when()
                .then()
                .statusCode(204);

    }

    @Test
    @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
    @JwtSecurity(
        claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
    )
    void delete() {
        AdministradorDTO dto = new AdministradorDTO(
                "Maria Luzia Nunes",
                "marialuiza",
                "243.705.128-75",
                "marialuzianunes@gmail.com",
                "12232a13",
                "Gerente",
                List.of(new TelefoneDTO("3966-0150", "63", "Vivo"))
        );
        AdministradorResponseDTO admin = service.insert(dto);

        given()
                .when().delete("/administrador/" + admin.id())
                .then()
                .statusCode(204);


    }

    @Test
     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
     @JwtSecurity(
        claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
    )
    void findById() {
        AdministradorDTO dto = new AdministradorDTO(
                "Maria Luzia Nunes",
                "marialuiza",
                "243.705.128-75",
                "marialuzianunes@gmail.com",
                "null",
                "Gerente",
                List.of(new TelefoneDTO("3966-0150", "63", "Vivo"))
        );
        AdministradorResponseDTO admin = service.insert(dto);
        given()
                .when()
                .then()
                .statusCode(200)
                .body(
                        "id", is(admin.id().intValue())
                );
    }

    @Test
    @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
    @JwtSecurity(
        claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
    )
    void findByName() {
        AdministradorDTO dto = new AdministradorDTO(
                "Anaurivan",
                "marialuiza",
                "181.895.747-79",
                "anaurivan@gmail.com",
                "321321321",
                "Fiscal",
                List.of(new TelefoneDTO("3966-0150", "63", "Vivo"))
        );
        AdministradorResponseDTO admin = service.insert(dto);


        assertThat(given()
                .when().get("/administrador/busca/anauri")
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getList(".", AdministradorResponseDTO.class), hasItem(admin));
    }
}