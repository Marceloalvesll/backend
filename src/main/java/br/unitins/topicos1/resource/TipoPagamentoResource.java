package br.unitins.topicos1.resource;

import br.unitins.topicos1.repository.TipoPagamentoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoPagamentoResource {
    @Inject
    TipoPagamentoRepository tipoPagamentoRepository;


    @GET
    public Response findAll() {
        return Response.ok(tipoPagamentoRepository.findAll()).build();
    }
}
