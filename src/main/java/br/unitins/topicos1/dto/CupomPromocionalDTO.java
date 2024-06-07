package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.CupomPromocional;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CupomPromocionalDTO(
        @NotBlank
        String codigo,
        @NotNull
        Double valorDesconto,
        @Future
        @NotNull
        LocalDate dataExpiracao
) {
    public CupomPromocional valueOf() {
        CupomPromocional cupom = new CupomPromocional();
        cupom.setCodigo(codigo());
        cupom.setValorDesconto(valorDesconto());
        cupom.setDataExpiracao(dataExpiracao());
        return cupom;
    }
}
