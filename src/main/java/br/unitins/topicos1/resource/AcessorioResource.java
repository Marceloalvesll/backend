package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.AcessorioDTO;
import br.unitins.topicos1.service.AcessorioService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.MediaType;

@Path("/acessorio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AcessorioResource {

    @Inject
    AcessorioService acessorioService;

    @POST
    public Response insertMarca(@Valid AcessorioDTO dto) {
        return Response.status(Status.CREATED).entity(acessorioService.insert(dto)).build();
    }


    @GET
    public Response findAll() {

        return Response.ok(acessorioService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long idAcessorio) {
        return Response.ok(acessorioService.findById(idAcessorio)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(AcessorioDTO dto, @PathParam("id") Long idAcessorio) {
        

        acessorioService.update(dto, idAcessorio);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long idAcessorio) {
       
        acessorioService.delete(idAcessorio);
        return Response.noContent().build();
    }

}
