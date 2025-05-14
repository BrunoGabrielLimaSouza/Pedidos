package Exercicio05.Pedidos.Entity.Dto;

import Exercicio05.Pedidos.Entity.Cliente;
import Exercicio05.Pedidos.Entity.Produto;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ProdutoDTO {

    private Long id;

    private String nomeProduto;

    private Double precoProduto;

    public ProdutoDTO(){}

    public ProdutoDTO(Long id, String nomeProduto, Double precoProduto){
        this.id=id;
        this.nomeProduto=nomeProduto;
        this.precoProduto=precoProduto;
    }

    public ProdutoDTO(Produto produto) {
        this.id= produto.getId();
        this.nomeProduto=produto.getNomeProduto();
        this.precoProduto=produto.getPrecoProduto();
    }

    public static Produto toEntity(ProdutoDTO produtoDTO, ModelMapper modelMapper) {
        return modelMapper.map(produtoDTO, Produto.class);
    }
    public static ProdutoDTO fromEntity(Produto produto, ModelMapper modelMapper) {
        return modelMapper.map(produto, ProdutoDTO.class);
    }

}
