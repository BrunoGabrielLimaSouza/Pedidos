package Exercicio05.Pedidos.Entity.Dto;


import Exercicio05.Pedidos.Entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Long produtoId;
    private Integer quantidade;



    public ItemDTO(Item item) {
        this.produtoId = item.getProduto().getId();
        this.quantidade = item.getQuantidade();
    }
}
