package br.com.projectvendas.Repositores;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projectvendas.Model.Cliente;
import br.com.projectvendas.Model.Pedido;

@Repository
public interface PedidosRepository extends JpaRepository<Pedido, Integer>{
   
	List<Pedido> findByCliente(Cliente cliente);
	
	Optional<Pedido> findPedidoById (Integer id);

}
