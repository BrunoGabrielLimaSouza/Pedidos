package Exercicio05.Pedidos.Entity.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Long produtoId;
    private Integer quantidade;
}
