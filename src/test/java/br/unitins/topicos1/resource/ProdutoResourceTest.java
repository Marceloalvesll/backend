// package br.unitins.topicos1.resource;


// import br.unitins.topicos1.dto.BateriaCompletaDTO;
// import br.unitins.topicos1.dto.BateriaCompletaResponseDTO;
// import br.unitins.topicos1.model.CategoriaInstrumento;
// import br.unitins.topicos1.service.BateriaCompletaService;

// import io.quarkus.test.junit.QuarkusTest;
// import io.quarkus.test.security.TestSecurity;
// import io.quarkus.test.security.jwt.Claim;
// import io.quarkus.test.security.jwt.ClaimType;
// import io.quarkus.test.security.jwt.JwtSecurity;
// import io.restassured.http.ContentType;
// import jakarta.inject.Inject;
// import org.junit.jupiter.api.Test;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.*;
// import static org.hamcrest.MatcherAssert.assertThat;
// import static org.junit.jupiter.api.Assertions.*;

// @QuarkusTest
// class ProdutoResourceTest {
//     @Inject
//     BateriaCompletaService service;

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//           @JwtSecurity(
//         claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
//     )
//     void insert() {
//         BateriaCompletaDTO dto = new BateriaCompletaDTO(
//                 "AC-39",
//                 "Violão",
//                 499.99,
//                 10,
//                 "Tagima",
//                 "VIOAC39",
//                 "ac39.png",
//                 CategoriaInstrumento.CORDAS
//         );
//         given()
//                 .contentType(ContentType.JSON)
//                 .body(dto)
//                 .when().post("/produto")
//                 .then()
//                 .statusCode(201)
//                 .body(
//                         "id", notNullValue(),
//                         "nome", is("AC-39"),
//                         "codigo", is("VIOAC39"),
//                         "marca", is("Tagima")
//                 );
//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     @JwtSecurity(
//         claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
//     )
//     void update() {
//         BateriaCompletaDTO dto = new BateriaCompletaDTO(
//                 "AC-39",
//                 "Violão",
//                 499.99,
//                 10,
//                 "Tagima",
//                 "VIOAC39",
//                 "ac39.png",
//                 CategoriaInstrumento.SOPRO
//         );
//         BateriaCompletaResponseDTO produto = service.insert(dto);

//         BateriaCompletaDTO dtoUpdate = new BateriaCompletaDTO(
//                 null,
//                 null,
//                 459.99,
//                 5,
//                 null,
//                 null,
//                 null,
//                 CategoriaInstrumento.CORDAS
//         );

//         given()
//                 .contentType(ContentType.JSON)
//                 .body(dtoUpdate)
//                 .when().put("/produto/" + produto.id())
//                 .then()
//                 .statusCode(204);

//         BateriaCompletaResponseDTO prod = service.findById(produto.id());
//         assertThat(prod.preco(), is(459.99));
//         assertThat(prod.estoque(), is(5));
//         assertThat(prod.categoriaInstrumento(), is(CategoriaInstrumento.CORDAS));
//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     @JwtSecurity(
//         claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
//     )
//     void delete() {
//         BateriaCompletaDTO dto = new BateriaCompletaDTO(
//                 "AC-39",
//                 "Violão",
//                 499.99,
//                 10,
//                 "Tagima",
//                 "VIOAC39",
//                 "ac39.png",
//                 CategoriaInstrumento.CORDAS
//         );
//         BateriaCompletaResponseDTO produto = service.insert(dto);

//         given()
//                 .when().delete("/produto/" + produto.id())
//                 .then()
//                 .statusCode(204);

//         assertNull(service.findById(produto.id()));
//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     @JwtSecurity(
//         claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
//     )
//     void findById() {
//         BateriaCompletaDTO dto = new BateriaCompletaDTO(
//                 "AC-39",
//                 "Violão",
//                 499.99,
//                 10,
//                 "Tagima",
//                 "VIOAC39",
//                 "ac39.png",
//                 CategoriaInstrumento.CORDAS
//         );
//         BateriaCompletaResponseDTO produto = service.insert(dto);

//         given()
//                 .when().get("/produto/" + produto.id())
//                 .then()
//                 .statusCode(200)
//                 .body(
//                         "id", is(produto.id().intValue())
//                 );
//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     @JwtSecurity(
//         claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
//     )
//     void findByName(){
//         BateriaCompletaDTO dto = new BateriaCompletaDTO(
//                 "AC-39",
//                 "Violão",
//                 499.99,
//                 10,
//                 "Tagima",
//                 "VIOAC39",
//                 "ac39.png",
//                 CategoriaInstrumento.CORDAS
//         );
//         BateriaCompletaResponseDTO produto = service.insert(dto);
//         assertThat(given()
//                 .when().get("/produto/busca/ac")
//                 .then()
//                 .statusCode(200)
//                 .extract().body().jsonPath().getList(".", BateriaCompletaResponseDTO.class), hasItem(produto));

//     }
// }