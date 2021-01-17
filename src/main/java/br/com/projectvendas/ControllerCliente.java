package br.com.projectvendas;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.projectvendas.Model.Cliente;
import br.com.projectvendas.Repositores.ClientesRepository;

@RequestMapping("/api/clientes/")
@RestController
public class ControllerCliente {
    
	 ClientesRepository clientesRepository;
	
	 public ControllerCliente(ClientesRepository clientesRepository ) {
		  this.clientesRepository = clientesRepository;
	}
     
	@GetMapping("/{id}")
    public Cliente ObterCliente(@PathVariable Integer id) {
		return clientesRepository
				           .findById(id)
				           .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
     }
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente SalvarDados(@RequestBody Cliente cliente) {
		return clientesRepository.save(cliente);
	}
}
