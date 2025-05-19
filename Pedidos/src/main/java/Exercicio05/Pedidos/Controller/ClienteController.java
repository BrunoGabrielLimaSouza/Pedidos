package Exercicio05.Pedidos.Controller;

import Exercicio05.Pedidos.Entity.Dto.ClienteDTO;
import Exercicio05.Pedidos.Entity.Dto.ProdutoDTO;
import Exercicio05.Pedidos.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastrar")
    public ClienteDTO cadastrarCliente(@RequestBody ClienteDTO clienteDTO){
        return clienteService.cadastrarCliente(clienteDTO);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClienntes(){
        return ResponseEntity.ok(clienteService.listarClientes());
    }
}
