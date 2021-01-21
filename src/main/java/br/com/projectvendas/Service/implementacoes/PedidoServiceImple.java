package br.com.projectvendas.Service.implementacoes;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import br.com.projectvendas.Dto.PedidoDTO;
import br.com.projectvendas.Exception.RegrasNegocioException;
import br.com.projectvendas.Model.Cliente;
import br.com.projectvendas.Model.Pedido;
import br.com.projectvendas.Repositores.ClientesRepository;
import br.com.projectvendas.Repositores.PedidosRepository;
import br.com.projectvendas.Repositores.ProdutosRepository;
import br.com.projectvendas.Service.PedidoService;

@Service
public class PedidoServiceImple implements PedidoService{
    
	private PedidosRepository pedidoRepository;
	private ClientesRepository clienteRepository;
	private ProdutosRepository produtoRepository;
 
	public PedidoServiceImple(PedidosRepository perdidoRepository,
			                    ClientesRepository clienteRepository, 
			                        ProdutosRepository produtoRepository) {
		this.pedidoRepository = perdidoRepository;
		this.clienteRepository = clienteRepository;
		this.produtoRepository = produtoRepository;
	}
	
	@Override
	public Pedido salvarPedido(PedidoDTO pedidoDto) {
 			
		Integer idcliente = pedidoDto.getCliente();
		Cliente clienteInsert = clienteRepository
				                 .findById(idcliente)
				                 .orElseThrow(() -> new RegrasNegocioException("Codigo de cliente invalido"));
		
		Pedido p = new Pedido();
		p.setTotal(pedidoDto.getTotal() );
		p.setDataPedido(LocalDate.now() );
		p.setCliente(clienteInsert);
		return null;
		
 	}



}
