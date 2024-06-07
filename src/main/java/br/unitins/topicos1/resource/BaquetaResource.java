package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.BaquetaDTO;
import br.unitins.topicos1.service.BaquetaService;
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

@Path("/baqueta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BaquetaResource {

    @Inject
    BaquetaService baquetaService;

    @POST
    public Response insert(@Valid BaquetaDTO dto) {
        return Response.status(Status.CREATED).entity(baquetaService.insert(dto)).build();
    }


    @GET
    public Response findAll() {

        return Response.ok(baquetaService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long idBaqueta) {
        return Response.ok(baquetaService.findById(idBaqueta)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(BaquetaDTO dto, @PathParam("id") Long idBaqueta) {
        

        baquetaService.update(dto, idBaqueta);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long idBaqueta) {
       
        baquetaService.delete(idBaqueta);
        return Response.noContent().build();
    }

}
