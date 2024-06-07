// package br.unitins.topicos1.resource;

// import br.unitins.topicos1.dto.*;
// import br.unitins.topicos1.model.Estado;
// import br.unitins.topicos1.service.ClienteService;
// import br.unitins.topicos1.service.EnderecoService;
// import io.quarkus.test.junit.QuarkusTest;
// import io.quarkus.test.security.TestSecurity;
// import io.restassured.http.ContentType;
// import jakarta.inject.Inject;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import java.time.LocalDate;
// import java.util.List;
// import java.util.Objects;
// import java.util.Optional;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.*;
// import static org.hamcrest.MatcherAssert.assertThat;
// import static org.junit.jupiter.api.Assertions.*;

// @QuarkusTest
// class EnderecoResourceTest {

//     @Inject
//     EnderecoService service;

//     @Inject
//     ClienteService clienteService;

//     EnderecoDTO dto;

//     Long idCliente;

//     @BeforeEach
//     void setUp(){
//         dto = new EnderecoDTO(
//                 "Livreiro Tisi",
//                 859,
//                 "São Paulo",
//                 "05030-110",
//                 Estado.SP
//         );

//         ClienteDTO clienteDTO = new ClienteDTO(
//                 "Sebastião",
//                 "Drumond",
//                 LocalDate.of(1984, 4, 13),
//                 "768.957.726-18",
//                 "sebastiao_drumond@bol.com",
//                 "seb",
//                 "12324235",
//                 List.of(new EnderecoDTO("Farias Neves", 207, "São Lourenço da Mata", "54715-240", Estado.PE)),
//                 List.of(new TelefoneDTO("12312-2131", "055", "TIM"))
//         );

//         idCliente = clienteService.insert(clienteDTO).id();
//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     void insert() {
//         given()
//                 .contentType(ContentType.JSON)
//                 .body(dto)
//                 .when().post("/endereco/" + idCliente)
//                 .then()
//                 .statusCode(201)
//                 .body(
//                         "id", notNullValue(),
//                         "cep", is("05030-110")
//                 );

//         assertNotEquals(clienteService.findById(idCliente).enderecos().stream()
//                 .filter(e -> Objects.equals(e.cep(), "05030-110") && Objects.equals(e.rua(), "Livreiro Tisi")).findFirst(), Optional.empty());

//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     void update() {
//         EnderecoResponseDTO endereco = service.insert(dto, idCliente);
//         EnderecoDTO dtoUpdate = new EnderecoDTO(
//                 null,
//                 405,
//                 null,
//                 null,
//                 null
//         );

//         given()
//                 .contentType(ContentType.JSON)
//                 .body(dtoUpdate)
//                 .when().put("/endereco/" + endereco.id())
//                 .then()
//                 .statusCode(204);

//         EnderecoResponseDTO e = service.findById(endereco.id());
//         assertThat(e.numero(), is(405));
//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     void delete() {
//         EnderecoResponseDTO endereco = service.insert(dto, idCliente);

//         given()
//                 .when().delete("/endereco/" + endereco.id())
//                 .then()
//                 .statusCode(204);

//         assertNull(service.findById(endereco.id()));
//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     void findById() {
//         EnderecoResponseDTO endereco = service.insert(dto, idCliente);

//         given()
//                 .when().get("/endereco/" + endereco.id())
//                 .then()
//                 .statusCode(200)
//                 .body(
//                         "id", is(endereco.id().intValue())
//                 );
//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     void findByCep() {
//         EnderecoResponseDTO endereco = service.insert(dto, idCliente);
//         assertThat(given()
//                 .when().get("/endereco/busca/05030-110" )
//                 .then()
//                 .statusCode(200)
//                 .extract().body().jsonPath().getList(".", EnderecoResponseDTO.class), hasItem(endereco));
//     }
// }