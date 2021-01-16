package br.com.projectvendas.Repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projectvendas.Model.ItemPedido;

public interface ItemsRepository extends JpaRepository<ItemPedido, Integer> {

}
