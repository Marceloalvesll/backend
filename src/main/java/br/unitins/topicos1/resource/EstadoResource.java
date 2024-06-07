package br.unitins.topicos1.resource;

import br.unitins.topicos1.repository.EstadoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/estados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoResource {

    @Inject
    EstadoRepository estadoRepository;

    @GET
    public Response findAll() {
        
        return Response.ok(estadoRepository.findAll()).build();
    }
}