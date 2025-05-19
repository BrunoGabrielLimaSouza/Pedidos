package Exercicio05.Pedidos.Controller;

import Exercicio05.Pedidos.Entity.Dto.PedidoDTO;
import Exercicio05.Pedidos.Entity.Dto.ProdutoDTO;
import Exercicio05.Pedidos.Entity.Pedido;
import Exercicio05.Pedidos.Service.PedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/realizarPedido")
    public ResponseEntity<PedidoDTO> realizarPedido(@RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoService.criarPedido(pedidoDTO);

        PedidoDTO resposta = modelMapper.map(pedido, PedidoDTO.class);

        return ResponseEntity.ok(resposta);
    }


    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarPedidos(){
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }
}
