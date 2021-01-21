package br.com.projectvendas.Service.implementacoes;

import org.springframework.stereotype.Service;

import br.com.projectvendas.Repositores.PedidosRepository;
import br.com.projectvendas.Service.PedidoService;

@Service
public class PedidoServiceImple implements PedidoService{
    
	private PedidosRepository perdidoRepository;
 
	public PedidoServiceImple(PedidosRepository perdidoRepository) {
		this.perdidoRepository = perdidoRepository;
	}
	
 
}
