package br.com.projectvendas;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.projectvendas.Model.Cliente;
import br.com.projectvendas.Repositores.ClientesRepository;
 
@RestController
@RequestMapping("/api/clientes")
public class ControllerCliente {
    
	 ClientesRepository clientesRepository;
	
	 public ControllerCliente(ClientesRepository clientesRepository ) {
		  this.clientesRepository = clientesRepository;
	}
     
	@GetMapping("/{id}")
    public Cliente ObterCliente(@PathVariable Integer id) {
		 return clientesRepository
				 .findById(id)
				 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
     }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente SalvarDados(@RequestBody Cliente cliente) {
		   return clientesRepository.save(cliente);
 	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
		return clientesRepository.findById(id)
				            .map(deleteUser -> {
				              clientesRepository.deleteById(id);
				              return ResponseEntity.ok().build();
				     }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
	}
	
	
	@PutMapping("/{id}")
	public void updateUser(@PathVariable Integer id, @RequestBody Cliente cliente) {
		    clientesRepository
		                 .findById(id)
		                 .map(clienteExistente -> {
		                	 cliente.setId(clienteExistente.getId());
		                	 clientesRepository.save(cliente);
		                	 return ResponseEntity.noContent().build();
		                 }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));

		                 
	}
	
	
	
	@GetMapping
	public ResponseEntity<?> BuscarTodos(Cliente filtro) {

		 ExampleMatcher matcher = ExampleMatcher
				                      .matching()
				                      .withIgnoreCase()
				                      .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		 
		 Example<Cliente> example = Example.of(filtro,matcher);
		 List<Cliente> lista = clientesRepository.findAll(example);
		 return ResponseEntity.ok(lista);
 	}
	
}























