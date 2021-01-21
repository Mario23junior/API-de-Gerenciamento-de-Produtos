package br.com.projectvendas.Repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projectvendas.Model.Cliente;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

}
