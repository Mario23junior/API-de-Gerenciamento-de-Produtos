package br.com.projectvendas.Repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projectvendas.Model.Produto;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Integer> {

}
