package Exercicio05.Pedidos.Repository;

import Exercicio05.Pedidos.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
