package br.com.projectvendas.Repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projectvendas.Model.ItemPedido;

@Repository
public interface ItemsRepository extends JpaRepository<ItemPedido, Integer> {

}
