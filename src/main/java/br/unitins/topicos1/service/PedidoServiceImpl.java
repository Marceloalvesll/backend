package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.ItemPedidoDTO;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import br.unitins.topicos1.dto.StatusPedidoDTO;
import br.unitins.topicos1.model.*;
import br.unitins.topicos1.repository.ClienteRepository;
import br.unitins.topicos1.repository.CupomRepository;
import br.unitins.topicos1.repository.PedidoRepository;
import br.unitins.topicos1.repository.BateriaCompletaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.criteria.Order;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    PedidoRepository repository;
    @Inject
    ClienteRepository clienteRepository;

    @Inject
    CupomRepository cupomRepository;

    @Inject
    BateriaCompletaRepository produtoRepository;

    @Override
    @Transactional
    public PedidoResponseDTO insert(PedidoDTO dto, String login) {
        Pedido pedido = new Pedido();
        Double total = 0.0;
        pedido.setItensPedido(new ArrayList<ItemPedido>());
        
       

        for (ItemPedidoDTO itemPedido : dto.itens()) {
            ItemPedido item = new ItemPedido();
            item.setQuantidade(itemPedido.quantidade());
            BateriaCompleta bateriaCompleta = new BateriaCompleta();
            bateriaCompleta = produtoRepository.findById(itemPedido.idProduto());
            item.setProduto(bateriaCompleta);

            pedido.getItensPedido().add(item);
            
        }
                

            pedido.setCliente(clienteRepository.findByLogin(login));

            
        

        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setTipoPagamento(TipoPagamento.valueOf(1));

        StatusPedido statusPedido = new StatusPedido();
        statusPedido.setData(LocalDateTime.now());
        statusPedido.setStatus(Status.EM_PROCESSAMENTO);
        pedido.setHistoricoStatus(List.of(statusPedido));

        // salvando pedido
        repository.persist(pedido);

        return PedidoResponseDTO.valueOf(pedido);
    }

    // Order order = new Order();
    //     order.setDataHora(LocalDateTime.now());

    //     // calculo do total do order
    //     Double total = 0.0;
    //     for (ItemCarrinhoDTO itemDto : dto.itens()) {
    //         total += (itemDto.preco() * itemDto.quantidade());
    //     }
    //     order.setTotalPedido(total);

    //     // adicionando os itens do order
    //     order.setItens(new ArrayList<ItemCarrinho>());
    //     for (ItemCarrinhoDTO itemDto : dto.itens()) {
    //         ItemCarrinho item = new ItemCarrinho();
    //         item.setPreco(itemDto.preco());
    //         item.setQuantidade(itemDto.quantidade());
    //         item.setPedido(order);
    //         Product product = productRepository.findById(itemDto.idProduct());
    //         item.setProduct(product);

    //         // atualizado o estoque
    //         product.setEstoque(product.getEstoque() - item.getQuantidade());

    //         order.getItens().add(item);
    //     }

    //     // buscando o usuario pelo login
    //     order.setUsuario(usuarioRepository.findByLogin(login));

    //     // salvando no banco
    //     orderRepository.persist(order);

    //     // atualizando o estoque

    //     return OrderResponseDTO.valueOf(order);





    // private void configurarPedido(PedidoDTO dto, Pedido pedido) {



    //     if (dto.itens() != null) {
    //         if (pedido.getItensPedido() == null) {
    //             pedido.setItensPedido(new ArrayList<>());
    //         } else {
    //             pedido.getItensPedido().clear();
    //         }

    //         pedido.getItensPedido().addAll(dto.itens().stream().map(itemPedidoDTO -> {
    //             ItemPedido itemPedido = new ItemPedido();
    //             BateriaCompleta produto = produtoRepository.findById(itemPedidoDTO.idProduto());

    //             if ((produto.getQuantidadeEstoque() - itemPedido.getQuantidade()) >= 0) {
    //                 itemPedido.setQuantidade(itemPedidoDTO.quantidade());
    //                 produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - itemPedido.getQuantidade());
    //             } else {

    //                 throw new ValidationException("Estoque", "Quantidade de estoque insuficiente");

    //             }

    //             itemPedido.setPrecoUnitario(produto.getPreco());
    //             itemPedido.setSubTotal(produto.getPreco() * itemPedidoDTO.quantidade());
    //             itemPedido.setProduto(produto);
    //             return itemPedido;
    //         }).toList());
    //     }
    // }

    // @Override
    // @Transactional
    // public OrderResponseDTO insert(OrderDTO dto, String login) {
    // Order order = new Order();

    // order.setDataHora(LocalDateTime.now());

    // // calculo do total do order
    // Double total = 0.0;
    // for (ItemCarrinhoDTO itemDto : dto.itens()) {
    // total += (itemDto.preco() * itemDto.quantidade());
    // }
    // order.setTotalPedido(total);

    // // adicionando os itens do order
    // order.setItens(new ArrayList<ItemCarrinho>());
    // for (ItemCarrinhoDTO itemDto : dto.itens()) {
    // ItemCarrinho item = new ItemCarrinho();
    // item.setPreco(itemDto.preco());
    // item.setQuantidade(itemDto.quantidade());
    // item.setPedido(order);
    // Product product = productRepository.findById(itemDto.idProduct());
    // item.setProduct(product);

    // // atualizado o estoque
    // product.setEstoque(product.getEstoque() - item.getQuantidade());

    // order.getItens().add(item);
    // }

    // // buscando o usuario pelo login
    // order.setUsuario(usuarioRepository.findByLogin(login));

    // // salvando no banco
    // orderRepository.persist(order);

    // // atualizando o estoque

    // return OrderResponseDTO.valueOf(order);
    // }

    // @Override
    // @Transactional
    // public PedidoResponseDTO update(PedidoDTO dto, Long id) {
    // Pedido pedido = repository.findById(id);
    // if (pedido != null) {
    // configurarPedido(dto, pedido);
    // repository.persist(pedido);
    // return PedidoResponseDTO.valueOf(pedido);
    // }
    // return null;
    // }

    @Override
    @Transactional
    public PedidoResponseDTO insertStatus(StatusPedidoDTO dto, Long id) {
        Pedido pedido = repository.findById(id);
        pedido.getHistoricoStatus().add(dto.valueOf());
        repository.persist(pedido);
        return PedidoResponseDTO.valueOf(pedido);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        return PedidoResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<PedidoResponseDTO> findByClienteId(Long idCliente) {
        return repository.findByClienteId(idCliente).stream().map(PedidoResponseDTO::valueOf).toList();
    }

    @Override
    public PedidoResponseDTO update(PedidoDTO dto, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
