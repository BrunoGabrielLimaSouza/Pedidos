package Exercicio05.Pedidos.Service;

import Exercicio05.Pedidos.Entity.Cliente;
import Exercicio05.Pedidos.Entity.Dto.ClienteDTO;
import Exercicio05.Pedidos.Entity.Dto.ProdutoDTO;
import Exercicio05.Pedidos.Entity.Produto;
import Exercicio05.Pedidos.Repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO){
        Cliente cliente = ClienteDTO.toEntity(clienteDTO, modelMapper);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ClienteDTO.fromEntity(clienteSalvo, modelMapper);
    }

    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(ClienteDTO::new).toList();
    }

}
