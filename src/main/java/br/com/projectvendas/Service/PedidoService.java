package br.com.projectvendas.Service;

import org.springframework.stereotype.Service;

import br.com.projectvendas.Dto.PedidoDTO;
import br.com.projectvendas.Model.Pedido;

@Service
public interface PedidoService {
	
	Pedido salvarPedido(PedidoDTO dto);
 }
