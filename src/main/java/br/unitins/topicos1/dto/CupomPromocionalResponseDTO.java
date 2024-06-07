package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.CupomPromocional;

import java.time.LocalDate;

public record CupomPromocionalResponseDTO(
        Long id,
        String codigo,
        Double valorDesconto,
        LocalDate dataExpiracao
) {
    public static CupomPromocionalResponseDTO valueOf(CupomPromocional cupom) {
        return new CupomPromocionalResponseDTO(
                cupom.getId(),
                cupom.getCodigo(),
                cupom.getValorDesconto(),
                cupom.getDataExpiracao()
        );
    }
}
