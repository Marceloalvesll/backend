package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.MarcaDTO;
import br.unitins.topicos1.service.MarcaService;
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

@Path("/marca")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MarcaResource {

    @Inject
    MarcaService marcaService;

    @POST
    public Response insertMarca(@Valid MarcaDTO dto) {
        return Response.status(Status.CREATED).entity(marcaService.insertMarca(dto)).build();
    }


    @GET
    public Response findAll() {

        return Response.ok(marcaService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long idMarca) {
        return Response.ok(marcaService.findById(idMarca)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateMarca(MarcaDTO dto, @PathParam("id") Long idMarca) {
        

        marcaService.updateMarca(dto, idMarca);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long idMarca) {
       
        marcaService.delete(idMarca);
        return Response.noContent().build();
    }

}
