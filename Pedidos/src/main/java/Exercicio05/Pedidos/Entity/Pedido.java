package Exercicio05.Pedidos.Entity;


import jakarta.persistence.*;

@Table(name = "tb_Pedidos")
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
