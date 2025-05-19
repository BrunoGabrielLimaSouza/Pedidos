package Exercicio05.Pedidos.Entity.Dto;

import Exercicio05.Pedidos.Entity.Pedido;
import Exercicio05.Pedidos.Entity.Produto;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Long clienteId;
    private List<ItemDTO> itens;
    private BigDecimal valorTotal;



    public static Pedido toEntity(PedidoDTO pedidoDTO, ModelMapper modelMapper) {
        return modelMapper.map(pedidoDTO, Pedido.class);
    }
    public static PedidoDTO fromEntity(Pedido pedido, ModelMapper modelMapper) {
        return modelMapper.map(pedido, PedidoDTO.class);
    }

}
