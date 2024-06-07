package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.service.TelefoneService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/telefone")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TelefoneResource {

    @Inject
    TelefoneService service;

    @POST
    @Path("/criar/administrador/{id_admin}")
    public Response insertAdmin(@Valid TelefoneDTO dto, @PathParam("id_admin") Long idAdmin) {
        return Response.status(Status.CREATED).entity(service.insertAdmin(dto, idAdmin)).build();
    }

    @POST
    @Path("/criar/cliente/{id_cliente}")
    public Response insertCliente(@Valid TelefoneDTO dto, @PathParam("id_cliente") Long idCliente) {
        return Response.status(Status.CREATED).entity(service.insertCliente(dto, idCliente)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(TelefoneDTO dto, @PathParam("id") Long id) {
        service.update(dto, id);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @Path("/busca/{ddd}/{numero}")
    public Response findByDDDeNumero(@PathParam("ddd") String ddd, @PathParam("numero") String numero) {
        return Response.ok(service.findByDDDeNumero(ddd, numero)).build();
    }
}