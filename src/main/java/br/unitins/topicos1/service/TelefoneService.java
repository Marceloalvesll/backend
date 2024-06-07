package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.TelefoneResponseDTO;

public interface TelefoneService {
    TelefoneResponseDTO insertCliente(TelefoneDTO dto, Long idCliente);

    TelefoneResponseDTO insertAdmin(TelefoneDTO dto, Long idAdmin);

    TelefoneResponseDTO update(TelefoneDTO dto, Long id);

    void delete(Long id);

    TelefoneResponseDTO findById(Long id);

    TelefoneResponseDTO findByDDDeNumero(String ddd, String numero);

}
