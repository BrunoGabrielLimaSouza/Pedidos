package Exercicio05.Pedidos.Controller;

import Exercicio05.Pedidos.Entity.Dto.ClienteDTO;
import Exercicio05.Pedidos.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastrar")
    public ClienteDTO cadastrarCliente(@RequestBody ClienteDTO clienteDTO){
        return clienteService.cadastrarCliente(clienteDTO);
    }
}
