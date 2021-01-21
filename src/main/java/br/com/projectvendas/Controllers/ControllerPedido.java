package br.com.projectvendas.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projectvendas.Service.PedidoService;

@RestController
@RequestMapping("/api/produtos")
public class ControllerPedido {
      
	private PedidoService service;
	
	public ControllerPedido(PedidoService service) {
		this.service = service;
 	}
}
