// package br.unitins.topicos1.resource;

// import br.unitins.topicos1.dto.*;
// import br.unitins.topicos1.model.Estado;
// import br.unitins.topicos1.service.ClienteService;
// import io.quarkus.test.junit.QuarkusTest;
// import io.quarkus.test.security.TestSecurity;
// import io.quarkus.test.security.jwt.JwtSecurity;
// import io.restassured.http.ContentType;
// import jakarta.inject.Inject;

// import org.junit.jupiter.api.Test;
// import io.quarkus.test.security.jwt.Claim;
// import io.quarkus.test.security.jwt.ClaimType;

// import java.time.LocalDate;
// import java.util.List;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.*;
// import static org.hamcrest.MatcherAssert.assertThat;

// @QuarkusTest
// class ClienteResourceTest {

//         @Inject
//         ClienteService service;

//         @Test
//         @TestSecurity(user = "testUser", roles = { "ADMIN", "CLIENTE" })
//         @JwtSecurity(claims = { @Claim(key = "sub", value = "1", type = ClaimType.LONG) })
//         void insert() {
//                 ClienteDTO dto = new ClienteDTO(
//                                 "Sebastião",
//                                 "Drumond",
//                                 LocalDate.of(1984, 4, 13),
//                                 "768.957.726-18",
//                                 "sebastiao_drumond@bol.com",
//                                 "seb",
//                                 "12324235",
//                                 List.of(new EnderecoDTO("Farias Neves", 207, "São Lourenço da Mata", "54715-240",
//                                                 Estado.PE)),
//                                 List.of(new TelefoneDTO("12312-2131", "055", "TIM")));
//                 given()
//                                 .contentType(ContentType.JSON)
//                                 .body(dto)
//                                 .when().post("/cliente")
//                                 .then()
//                                 .statusCode(201)
//                                 .body(
//                                                 "id", notNullValue(),
//                                                 "nome", is("Sebastião"),
//                                                 "login", is("seb"),
//                                                 "cpf", is("768.957.726-18"));
//         }

//         @Test
//         @TestSecurity(user = "testUser", roles = { "ADMIN", "CLIENTE" })
//         @JwtSecurity(claims = { @Claim(key = "sub", value = "1", type = ClaimType.LONG) })
//         void update() {
//                 ClienteDTO dto = new ClienteDTO(
//                                 "Sebastião",
//                                 "Drumond",
//                                 LocalDate.of(1984, 4, 13),
//                                 "768.957.726-18",
//                                 "sebastiao_drumond@bol.com",
//                                 "seb",
//                                 "12324235",
//                                 List.of(new EnderecoDTO("Farias Neves", 207, "São Lourenço da Mata", "54715-240",
//                                                 Estado.PE)),
//                                 List.of(new TelefoneDTO("12312-2131", "055", "TIM")));

//                 ClienteResponseDTO cliente = service.insert(dto);

//                 ClienteDTO dtoUpdate = new ClienteDTO(
//                                 null,
//                                 null,
//                                 LocalDate.of(1984, 4, 23),
//                                 null,
//                                 null,
//                                 "tiao",
//                                 null,
//                                 null,
//                                 null);
//                 given()
//                                 .contentType(ContentType.JSON)
//                                 .body(dtoUpdate)
//                                 .when().put("/cliente/" + cliente.id())
//                                 .then()
//                                 .statusCode(204);


//         }

//         @Test
//         @TestSecurity(user = "testUser", roles = { "ADMIN", "CLIENTE" })
//         @JwtSecurity(claims = { @Claim(key = "sub", value = "1", type = ClaimType.LONG) })
//         void delete() {
//                 ClienteDTO dto = new ClienteDTO(
//                                 "Sebastião",
//                                 "Drumond",
//                                 LocalDate.of(1984, 4, 13),
//                                 "768.957.726-18",
//                                 "sebastiao_drumond@bol.com",
//                                 "seb",
//                                 "12324235",
//                                 List.of(new EnderecoDTO("Farias Neves", 207, "São Lourenço da Mata", "54715-240",
//                                                 Estado.PE)),
//                                 List.of(new TelefoneDTO("12312-2131", "055", "TIM")));

//                 service.insert(dto);

//                 given()
//                                 .when()
//                                 .then()
//                                 .statusCode(204);

//         }

//         @Test
//         @TestSecurity(user = "testUser", roles = { "ADMIN", "CLIENTE" })
//         @JwtSecurity(claims = { @Claim(key = "sub", value = "1", type = ClaimType.LONG) })
//         void findById() {
//                 ClienteDTO dto = new ClienteDTO(
//                                 "Sebastião",
//                                 "Drumond",
//                                 LocalDate.of(1984, 4, 13),
//                                 "768.957.726-18",
//                                 "sebastiao_drumond@bol.com",
//                                 "seb",
//                                 "12324235",
//                                 List.of(new EnderecoDTO("Farias Neves", 207, "São Lourenço da Mata", "54715-240",
//                                                 Estado.PE)),
//                                 List.of(new TelefoneDTO("12312-2131", "055", "TIM")));

//                 ClienteResponseDTO cliente = service.insert(dto);

//                 given()
//                                 .when()
//                                 .then()
//                                 .statusCode(200)
//                                 .body(
//                                                 "id", is(cliente.id().intValue()));
//         }

//         @Test
//         @TestSecurity(user = "testUser", roles = { "ADMIN", "CLIENTE" })
//         @JwtSecurity(claims = { @Claim(key = "sub", value = "1", type = ClaimType.LONG) })
//         void findByNome() {
//                 ClienteDTO dto = new ClienteDTO(
//                                 "Sebastião",
//                                 "Drumond",
//                                 LocalDate.of(1984, 4, 13),
//                                 "768.957.726-18",
//                                 "sebastiao_drumond@bol.com",
//                                 "seb",
//                                 "12324235",
//                                 List.of(new EnderecoDTO("Farias Neves", 207, "São Lourenço da Mata", "54715-240",
//                                                 Estado.PE)),
//                                 List.of(new TelefoneDTO("12312-2131", "055", "TIM")));

//                 ClienteResponseDTO cliente = service.insert(dto);

//                 assertThat(given()
//                                 .when().get("/cliente/busca/tião")
//                                 .then()
//                                 .statusCode(200)
//                                 .extract().body().jsonPath().getList(".", ClienteResponseDTO.class), hasItem(cliente));
//         }
// }