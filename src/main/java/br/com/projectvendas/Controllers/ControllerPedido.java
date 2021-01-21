package br.com.projectvendas.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.projectvendas.Dto.PedidoDTO;
import br.com.projectvendas.Service.PedidoService;

@RestController
@RequestMapping("/api/produtos")
public class ControllerPedido {
      
	private PedidoService service;
	
	public ControllerPedido(PedidoService service) {
		this.service = service;
 	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Integer save(@RequestBody PedidoDTO pedidoDto) {
		return null;
	}
}
