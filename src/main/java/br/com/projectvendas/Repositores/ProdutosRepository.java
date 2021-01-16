package br.com.projectvendas.Repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projectvendas.Model.Produto;

public interface ProdutosRepository extends JpaRepository<Produto, Integer> {

}
