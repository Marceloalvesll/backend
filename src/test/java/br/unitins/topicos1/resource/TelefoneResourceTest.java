// package br.unitins.topicos1.resource;

// import br.unitins.topicos1.dto.*;
// import br.unitins.topicos1.model.Estado;
// import br.unitins.topicos1.service.AdministradorService;
// import br.unitins.topicos1.service.ClienteService;
// import br.unitins.topicos1.service.TelefoneService;
// import io.quarkus.test.junit.QuarkusTest;
// import io.quarkus.test.security.TestSecurity;
// import io.restassured.http.ContentType;
// import jakarta.inject.Inject;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import java.time.LocalDate;
// import java.util.List;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.*;
// import static org.hamcrest.MatcherAssert.assertThat;
// import static org.junit.jupiter.api.Assertions.*;

// @QuarkusTest
// class TelefoneResourceTest {

//     @Inject
//     TelefoneService service;

//     @Inject
//     AdministradorService administradorService;

//     @Inject
//     ClienteService clienteService;

//     TelefoneDTO dto;

//     Long idCliente;

//     @BeforeEach
//     void setUp() {
//         dto = new TelefoneDTO(
//                 "40028922",
//                 "011",
//                 "TIM"
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
//     void insertCliente() {


//         given()
//                 .contentType(ContentType.JSON)
//                 .body(dto)
//                 .when().post("/telefone/criar/cliente/" + idCliente)
//                 .then()
//                 .statusCode(201)
//                 .body(
//                         "id", notNullValue(),
//                         "numero", is("40028922")
//                 );

//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     void insertAdmin() {
//         AdministradorDTO administradorDTO = new AdministradorDTO(
//                 "Maria Luzia Nunes",
//                 "marialuiza",
//                 "243.705.128-75",
//                 "marialuzianunes@gmail.com",
//                 "12345688",
//                 "Gerente",
//                 List.of(new TelefoneDTO("3966-0150", "63", "Vivo"))
//         );
//         AdministradorResponseDTO admin = administradorService.insert(administradorDTO);

//         given()
//                 .contentType(ContentType.JSON)
//                 .body(dto)
//                 .when().post("/telefone/criar/administrador/" + admin.id())
//                 .then()
//                 .statusCode(201)
//                 .body(
//                         "id", notNullValue(),
//                         "numero", is("40028922")
//                 );
//     }



//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     void update() {
//         TelefoneResponseDTO telefone = service.insertCliente(dto, idCliente);
//         TelefoneDTO dtoUpdate = new TelefoneDTO(
//                 null,
//                 null,
//                 "Claro"
//         );
//         given()
//                 .contentType(ContentType.JSON)
//                 .body(dtoUpdate)
//                 .when().put("/telefone/" + telefone.id())
//                 .then()
//                 .statusCode(204);

//         TelefoneResponseDTO t = service.findById(telefone.id());
//         assertThat(t.operadora(), is("Claro"));
//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     void delete() {
//         TelefoneResponseDTO telefone = service.insertCliente(dto, idCliente);
//         given()
//                 .when().delete("/telefone/" + telefone.id())
//                 .then()
//                 .statusCode(204);

//         assertNull(service.findById(telefone.id()));

//         AdministradorDTO administradorDTO = new AdministradorDTO(
//                 "Maria Luzia Nunes",
//                 "marialuiza",
//                 "243.705.128-75",
//                 "marialuzianunes@gmail.com",
//                 "12345688",
//                 "Gerente",
//                 List.of(new TelefoneDTO("3966-0150", "63", "Vivo"))
//         );
//         AdministradorResponseDTO admin = administradorService.insert(administradorDTO);

//         TelefoneResponseDTO telefone2 = service.insertAdmin(dto, admin.id());

//         given()
//                 .when().delete("/telefone/" + telefone2.id())
//                 .then()
//                 .statusCode(204);

//         assertNull(service.findById(telefone2.id()));

//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     void findById() {
//         TelefoneResponseDTO telefone = service.insertCliente(dto, idCliente);
//         given()
//                 .when().get("/telefone/" + telefone.id())
//                 .then()
//                 .statusCode(200)
//                 .body(
//                         "id", is(telefone.id().intValue())
//                 );
//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     void findByDDDeNumero() {
//         TelefoneResponseDTO telefone = service.insertCliente(dto, idCliente);

//         assertThat(given()
//                 .when().get("/telefone/busca/011/40028922" )
//                 .then()
//                 .statusCode(200)
//                 .extract().body().as(TelefoneResponseDTO.class), is(telefone));
//     }
// }