package Exercicio05.Pedidos.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "tb_Produtos")
@Data
@AllArgsConstructor
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nomeProduto")
    private String nomeProduto;

    @Column(name = "precoProduto")
    private Double precoProduto;


}
