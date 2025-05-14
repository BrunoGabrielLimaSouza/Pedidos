package Exercicio05.Pedidos.Controller;


import Exercicio05.Pedidos.Entity.Dto.PedidoDTO;
import Exercicio05.Pedidos.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping("/realizarPedido")
    public PedidoDTO

}
