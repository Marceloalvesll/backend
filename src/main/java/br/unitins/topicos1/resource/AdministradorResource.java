package br.unitins.topicos1.resource;

import org.eclipse.microprofile.jwt.Claim;


import br.unitins.topicos1.dto.AdministradorDTO;
import br.unitins.topicos1.service.AdministradorService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/administrador")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({ "ADMIN" })
public class AdministradorResource {

    @Inject
    @Claim("sub")
    Long idAdmin;

    @Inject
    AdministradorService service;

    @POST
    public Response insert(@Valid AdministradorDTO dto) {
        return Response.status(Status.CREATED).entity(service.insert(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(AdministradorDTO dto) {
        
        service.update(dto, idAdmin);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete() {
        
        service.delete(idAdmin);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Response findById() {
      
        return Response.ok(service.findById(idAdmin)).build();
    }

    @GET
    @Path("/busca/{nome}")
    public Response findByName(@PathParam("nome") String nome) {
        return Response.ok(service.findByName(nome)).build();
    }

}