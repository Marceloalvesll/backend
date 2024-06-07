package br.unitins.topicos1.resource;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import br.unitins.topicos1.dto.StatusPedidoDTO;
import br.unitins.topicos1.service.PedidoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/pedido")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({"CLIENTE"})
public class PedidoResource {
    @Inject
    PedidoService service;
 
    @Inject
    @Claim("sub")
    Long idCliente;

    @Inject
    JsonWebToken jwt;

    @POST
    @RolesAllowed({"CLIENTE"})
    @Transactional
    public Response insert(PedidoDTO dto) {

        String login = jwt.getSubject();
        
        PedidoResponseDTO retorno = service.insert(dto, login);
        return Response.status(201).entity(retorno).build();
    }



    // @POST
    // @Path("/criar/")
    // public Response insert(PedidoDTO dto) {
    //     return Response.status(Status.CREATED).entity(service.insert(dto, idCliente)).build();
    // }

    @PUT
    @Path("/atualizar/")
    public Response update(PedidoDTO dto) {
        service.update(dto, idCliente);
        return Response.noContent().build();
    }

    @PUT
    @Path("/atualizarStatus/")
    public Response updateStatus(StatusPedidoDTO dto) {
        service.insertStatus(dto, idCliente);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {

        service.delete(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/buscaPorPedido/")
    public Response findById() {
        return Response.ok(service.findById(idCliente)).build();
    }

    @GET
    @Path("/buscaPorCliente/")
    public Response findByClienteId() {
        return Response.ok(service.findByClienteId(idCliente)).build();
    }

    
}