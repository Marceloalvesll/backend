package br.unitins.topicos1.resource;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.topicos1.dto.AlterarNomeDTO;
import br.unitins.topicos1.dto.AlterarSenhaDTO;
import br.unitins.topicos1.dto.AlterarSobrenomeDTO;
import br.unitins.topicos1.service.ClienteService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;

@Path("/clientelogado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({ "CLIENTE" })
public class ClienteLogadoResource {

    @Inject
    @Claim("sub")
    Long idCliente;

    @Inject
    JsonWebToken jwt;

    @Inject
    ClienteService clienteService;

    @GET
    public Response getCliente() {

        return Response.ok(clienteService.findById(idCliente)).build();
    }

    @PATCH
    @Path("/alterar-senha")
    public Response alterarSenha(@Valid AlterarSenhaDTO dto) {
        try {

            clienteService.alterarSenha(dto, idCliente);

            return Response.noContent().build();
        } catch (Exception e) {

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro interno do servidor ao alterar a senha.").build();
        }
    }

    @PATCH
    @Path("/alterar-nome")
    public Response alterarNome(@Valid AlterarNomeDTO dto) {
        try {

            clienteService.alterarNome(dto, idCliente);

            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro interno do servidor ao alterar o nome.").build();
        }
    }

     @PATCH
    @Path("/alterar-sobrenome")
    public Response alterarSobrenome(@Valid AlterarSobrenomeDTO dto) {
        try {

            clienteService.alterarSobrenome(dto, idCliente);

            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro interno do servidor ao alterar o nome.").build();
        }
    }
}
