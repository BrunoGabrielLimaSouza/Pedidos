package Exercicio05.Pedidos.Service;

import Exercicio05.Pedidos.Entity.Cliente;
import Exercicio05.Pedidos.Entity.Dto.ClienteDTO;
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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

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


    private Cliente cliente;


    public Pedido criarPedido(PedidoDTO pedidoDTO) {
        Cliente cliente = clienteRepository.findById(pedidoDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataHora(LocalDateTime.now());

        List<Item> itens = new ArrayList<>();
        BigDecimal valorTotal = BigDecimal.ZERO; // inicia em 0

        for (ItemDTO itemDTO : pedidoDTO.getItens()) {
            Produto produto = produtoRepository.findById(itemDTO.getProdutoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            Item item = new Item();
            item.setProduto(produto);
            item.setQuantidade(itemDTO.getQuantidade());
            item.setPedido(pedido);

            itens.add(item);

            BigDecimal preco = produto.getPrecoProduto();
            BigDecimal quantidade = BigDecimal.valueOf(itemDTO.getQuantidade());
            BigDecimal valorItem = preco.multiply(quantidade);

            valorTotal = valorTotal.add(valorItem);
        }

        pedido.setItens(itens);
        pedido.setValorTotal(valorTotal);

        return pedidoRepository.save(pedido);
    }

    public List<PedidoDTO> listarPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(PedidoDTO::new).toList();
    }

}
