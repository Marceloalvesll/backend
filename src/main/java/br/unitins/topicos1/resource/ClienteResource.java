package br.unitins.topicos1.resource;

import org.eclipse.microprofile.jwt.Claim;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.service.ClienteService;
// import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    @Claim("sub")
    Long idCliente;

    @Inject
    ClienteService service;

    @POST
    public Response insert(@Valid ClienteDTO dto) {
        return Response.status(Status.CREATED).entity(service.insert(dto)).build();
    }

    
    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
    
    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(ClienteDTO dto, @PathParam("id") Long idCliente) {

        service.update(dto, idCliente);
        return Response.noContent().build();
    }


    @GET
    @Path("/{id}")
    public Response findById() {

        return Response.ok(service.findById(idCliente)).build();
    }

    @GET
    @Path("/busca/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(service.findByName(nome)).build();
    }

    @GET
    public Response findAll() {

        return Response.ok(service.getAll()).build();
    }

}