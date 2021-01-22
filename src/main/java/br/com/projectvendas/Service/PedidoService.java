package br.com.projectvendas.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projectvendas.Dto.PedidoDTO;
import br.com.projectvendas.Enums.StatusPedido;
import br.com.projectvendas.Model.Pedido;

@Service
public interface PedidoService {
	
	Pedido salvarPedido(PedidoDTO dto);
	
	Optional<Pedido> ObterDetalhesPedido(Integer id);
	
	void AtualizarStatus(Integer id, StatusPedido statusPedido);
 }
