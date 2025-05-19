package Exercicio05.Pedidos.Entity.Dto;

import Exercicio05.Pedidos.Entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


@Data
public class ClienteDTO {

    private Long id;

    private String nome;

    private String email;

    public ClienteDTO() {}

    public ClienteDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
    }

    public static Cliente toEntity(ClienteDTO clienteDTO, ModelMapper modelMapper) {
        return modelMapper.map(clienteDTO, Cliente.class);
    }
    public static ClienteDTO fromEntity(Cliente cliente, ModelMapper modelMapper) {
        return modelMapper.map(cliente, ClienteDTO.class);
    }

}
