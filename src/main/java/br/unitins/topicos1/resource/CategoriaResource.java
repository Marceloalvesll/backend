package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.CategoriaDTO;
import br.unitins.topicos1.service.CategoriaService;
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

@Path("/categoria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @Inject
    CategoriaService categoriaService;

    @POST
    public Response insert(@Valid CategoriaDTO dto) {
        return Response.status(Status.CREATED).entity(categoriaService.insert(dto)).build();
    }


    @GET
    public Response findAll() {

        return Response.ok(categoriaService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long idCategoria) {
        return Response.ok(categoriaService.findById(idCategoria)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(CategoriaDTO dto, @PathParam("id") Long idCategoria) {
        

        categoriaService.update(dto, idCategoria);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long idCategoria) {
       
        categoriaService.delete(idCategoria);
        return Response.noContent().build();
    }

}
