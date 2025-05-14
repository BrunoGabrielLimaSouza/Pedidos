package Exercicio05.Pedidos.Service;

import Exercicio05.Pedidos.Entity.Cliente;
import Exercicio05.Pedidos.Entity.Dto.ItemDTO;
import Exercicio05.Pedidos.Entity.Dto.PedidoDTO;
import Exercicio05.Pedidos.Entity.Item;
import Exercicio05.Pedidos.Entity.Pedido;
import Exercicio05.Pedidos.Entity.Produto;
import Exercicio05.Pedidos.Repository.ClienteRepository;
import Exercicio05.Pedidos.Repository.PedidoRepository;
import Exercicio05.Pedidos.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {


    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;


    @Autowired
    public PedidoService(PedidoRepository pedidoRepository){this.pedidoRepository = pedidoRepository;
    }

    @Autowired
    private Cliente cliente;

    public Pedido criarPedido(PedidoDTO pedidoDTO) {
        Cliente cliente = clienteRepository.findById(pedidoDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataHora(LocalDateTime.now());

        List<Item> itens = new ArrayList<>();

        for (ItemDTO itemDTO : pedidoDTO.getItens()) {
            Produto produto = produtoRepository.findById(itemDTO.getProdutoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            Item item = new Item();
            item.setProduto(produto);
            item.setQuantidade(itemDTO.getQuantidade());
            item.setPedido(pedido);

            itens.add(item);
        }

        pedido.setItens(itens);

        return pedidoRepository.save(pedido);
    }



}
