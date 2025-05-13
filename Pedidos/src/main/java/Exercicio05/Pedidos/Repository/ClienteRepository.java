package Exercicio05.Pedidos.Repository;


import Exercicio05.Pedidos.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
