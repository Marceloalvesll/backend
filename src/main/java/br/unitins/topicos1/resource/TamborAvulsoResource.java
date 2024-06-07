package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.TamborAvulsoDTO;
import br.unitins.topicos1.service.TamborAvulsoService;
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

@Path("/tamboravulso")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TamborAvulsoResource {

    @Inject
    TamborAvulsoService tamborAvulsoService;

    @POST
    public Response insert(@Valid TamborAvulsoDTO dto) {
        return Response.status(Status.CREATED).entity(tamborAvulsoService.insert(dto)).build();
    }


    @GET
    public Response findAll() {

        return Response.ok(tamborAvulsoService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long idTamborAvulso) {
        return Response.ok(tamborAvulsoService.findById(idTamborAvulso)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(TamborAvulsoDTO dto, @PathParam("id") Long idTamborAvulso) {
        

        tamborAvulsoService.update(dto, idTamborAvulso);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long idTamborAvulso) {
       
        tamborAvulsoService.delete(idTamborAvulso);
        return Response.noContent().build();
    }

}
