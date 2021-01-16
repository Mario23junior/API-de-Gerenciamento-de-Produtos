package br.com.projectvendas.Repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projectvendas.Model.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

}
