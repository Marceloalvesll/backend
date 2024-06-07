package br.unitins.topicos1.resource;

import org.eclipse.microprofile.jwt.Claim;

import br.unitins.topicos1.dto.AlterarCargoDTO;
import br.unitins.topicos1.dto.AlterarNomeDTO;
import br.unitins.topicos1.dto.AlterarSenhaDTO;
import br.unitins.topicos1.service.AdministradorService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/adminlogado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({ "ADMIN" })
public class AdminLogadoResource {

    @Inject
    @Claim("sub")
    Long idAdmin;

    @Inject
    AdministradorService administradorService;

    @GET
    public Response getAdmin() {

        return Response.ok(administradorService.findById(idAdmin)).build();
    }

    @PATCH
    @Path("/alterar-senha")
    public Response alterarSenha(@Valid AlterarSenhaDTO dto) {
        try {

            administradorService.alterarSenha(dto, idAdmin);

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

            administradorService.alterarNome(dto, idAdmin);

            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro interno do servidor ao alterar o nome.").build();
        }
    }

     @PATCH
    @Path("/alterar-cargo")
    public Response alterarCargo(@Valid AlterarCargoDTO dto) {
        try {

            administradorService.alterarCargo(dto, idAdmin);

            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro interno do servidor ao alterar o cargo.").build();
        }
    }

}