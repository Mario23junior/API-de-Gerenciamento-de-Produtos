package br.com.projectvendas.Repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projectvendas.Model.Pedido;

@Repository
public interface PedidosRepository extends JpaRepository<Pedido, Integer>{

}
