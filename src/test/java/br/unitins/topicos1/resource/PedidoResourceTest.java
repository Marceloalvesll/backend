// package br.unitins.topicos1.resource;

// import br.unitins.topicos1.dto.*;
// import br.unitins.topicos1.model.CategoriaInstrumento;
// import br.unitins.topicos1.model.Estado;
// import br.unitins.topicos1.model.Status;
// import br.unitins.topicos1.model.TipoPagamento;
// import br.unitins.topicos1.service.ClienteService;
// import br.unitins.topicos1.service.CupomService;
// import br.unitins.topicos1.service.PedidoService;
// import br.unitins.topicos1.service.BateriaCompletaService;

// import io.quarkus.test.junit.QuarkusTest;
// import io.quarkus.test.security.TestSecurity;
// import io.quarkus.test.security.jwt.Claim;
// import io.quarkus.test.security.jwt.ClaimType;
// import io.quarkus.test.security.jwt.JwtSecurity;
// import io.restassured.http.ContentType;
// import jakarta.inject.Inject;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;


// import java.time.LocalDate;
// import java.util.List;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.*;


// @QuarkusTest
// class PedidoResourceTest {
//     @Inject
//     PedidoService service;

//     @Inject
//     BateriaCompletaService produtoService;

//     @Inject
//     CupomService cupomService;

//     @Inject
//     ClienteService clienteService;

//     PedidoDTO dto;

//     Long idCliente;


//     @BeforeEach
//     void setup(){
//         BateriaCompletaDTO produtoDTO = new BateriaCompletaDTO(
//                 "AC-39",
//                 "Violão",
//                 499.99,
//                 10,
//                 "Tagima",
//                 "VIOAC39",
//                 "ac39.png",
//                 CategoriaInstrumento.CORDAS
//         );
//         BateriaCompletaResponseDTO produto = produtoService.insert(produtoDTO);
//         CupomPromocionalResponseDTO cupom;
//         try{
//             CupomPromocionalDTO cupomPromocionalDTO = new CupomPromocionalDTO(
//                     "TESTE123",
//                     19.99,
//                     LocalDate.now().plusDays(30)
//             );
//             cupom = cupomService.insert(cupomPromocionalDTO);
//         }catch (Exception e){
//             cupom = cupomService.findByCodigo("TESTE123");
//         }

//         dto = new PedidoDTO(
//                 TipoPagamento.PIX,
//                 List.of(new ItemPedidoDTO(2,produto.id())),
//                 cupom.codigo()
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
//     @JwtSecurity(
//         claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
//     )
//     void insert() {
//         given()
//                 .contentType(ContentType.JSON)
//                 .body(dto)
//                 .when()
//                 .then()
//                 .statusCode(201)
//                 .body(
//                         "id", notNullValue(),
//                         "tipoPagamento", is(TipoPagamento.PIX.name()),
//                         "cupom.codigo", is("TESTE123")
//                 );
//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     @JwtSecurity(
//         claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
//     )
//     void update() {

//         service.insert(dto, idCliente);

//         BateriaCompletaDTO produtoDTO = new BateriaCompletaDTO(
//                 "GSR 200",
//                 "Baixo",
//                 2499.99,
//                 2,
//                 "Ibanez",
//                 "BAIXGSR",
//                 "gsr200.png",
//                 CategoriaInstrumento.CORDAS
//         );
//         BateriaCompletaResponseDTO produto = produtoService.insert(produtoDTO);

//         PedidoDTO dtoUpdate = new PedidoDTO(
//                 TipoPagamento.CARTAO_DE_DEBITO,
//                 List.of(new ItemPedidoDTO(2,produto.id())),
//                 "CUPOMINVALIDO"
//         );

//         given()
//                 .contentType(ContentType.JSON)
//                 .body(dtoUpdate)
//                 .when()
//                 .then()
//                 .statusCode(204);

//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     @JwtSecurity(
//         claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
//     )
//     void updateStatus() {
//         service.insert(dto, idCliente);

//         StatusPedidoDTO statusPedidoDTO = new StatusPedidoDTO(
//                 Status.EM_PROCESSAMENTO
//         );
//         given()
//                 .contentType(ContentType.JSON)
//                 .body(statusPedidoDTO)
//                 .when()
//                 .then()
//                 .statusCode(204);
      
//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     @JwtSecurity(
//         claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
//     )
//     void delete() {
//         PedidoResponseDTO pedido = service.insert(dto, idCliente);
//         given()
//                 .when().delete("/pedido/delete/" + pedido.id())
//                 .then()
//                 .statusCode(204);

//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//     @JwtSecurity(
//         claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
//     )
//     void findById() {
//         PedidoResponseDTO pedido = service.insert(dto, idCliente);
//         given()
//                 .when()
//                 .then()
//                 .statusCode(200)
//                 .body(
//                         "id", is(pedido.id().intValue())
//                 );
//     }

//     @Test
//     @TestSecurity(user = "testUser", roles = {"ADMIN", "CLIENTE"})
//           @JwtSecurity(
//         claims = {@Claim(key = "sub", value = "1", type = ClaimType.LONG) } 
//     )
//     void findByClienteId() {
//         PedidoResponseDTO pedido = service.insert(dto, idCliente);
//                 given()
//                 .when()
//                 .then()
//                 .statusCode(200)
//                 .body(
//                         "id", is(pedido.id().intValue())
//                 );
//     }
// }