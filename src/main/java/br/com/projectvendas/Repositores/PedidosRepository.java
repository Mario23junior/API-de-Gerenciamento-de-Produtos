package br.com.projectvendas.Repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projectvendas.Model.Pedido;

public interface PedidosRepository extends JpaRepository<Pedido, Integer>{

}
