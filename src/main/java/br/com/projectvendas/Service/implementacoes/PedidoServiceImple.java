package br.com.projectvendas.Service.implementacoes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.projectvendas.Dto.ItemPedidoDTO;
import br.com.projectvendas.Dto.PedidoDTO;
import br.com.projectvendas.Exception.RegrasNegocioException;
import br.com.projectvendas.Model.Cliente;
import br.com.projectvendas.Model.ItemPedido;
import br.com.projectvendas.Model.Pedido;
import br.com.projectvendas.Model.Produto;
import br.com.projectvendas.Repositores.ClientesRepository;
import br.com.projectvendas.Repositores.ItemsRepository;
import br.com.projectvendas.Repositores.PedidosRepository;
import br.com.projectvendas.Repositores.ProdutosRepository;
import br.com.projectvendas.Service.PedidoService;

@Service
public class PedidoServiceImple implements PedidoService{
    
	private PedidosRepository pedidoRepository;
	private ClientesRepository clienteRepository;
	private ProdutosRepository produtoRepository;
	private ItemsRepository itemsPedidoRepository;
 
	public PedidoServiceImple(PedidosRepository pedidoRepository,
			                    ClientesRepository clienteRepository, 
			                     ProdutosRepository produtoRepository,
			                     ItemPedido itemsPedidoRepository) {
		this.pedidoRepository = pedidoRepository;
		this.clienteRepository = clienteRepository;
		this.produtoRepository = produtoRepository;
	}
	
	@Override
	@Transactional
	public Pedido salvarPedido(PedidoDTO pedidoDto) {
 			
		Integer idcliente = pedidoDto.getCliente();
		Cliente clienteInsert = clienteRepository
				                 .findById(idcliente)
				                 .orElseThrow(() -> new RegrasNegocioException("Codigo de cliente invalido"));
		
		Pedido pedido = new Pedido();
		pedido.setTotal(pedidoDto.getTotal() );
		pedido.setDataPedido(LocalDate.now() );
		pedido.setCliente(clienteInsert);
		
		List<ItemPedido> itemPedidos = converterItems(pedido, pedidoDto.getItems());
		pedidoRepository.save(pedido);
		itemsPedidoRepository.saveAll(itemPedidos);
		pedido.setItens(itemPedidos);
 		
		return pedido;
 	}
	
	private List<ItemPedido> converterItems(Pedido pedido , List<ItemPedidoDTO> items) {
		 if(items.isEmpty()) {
			 throw new RegrasNegocioException("Não possivel realizar um pedido sem items");
		 }
		 
		 return items
				  .stream()
				  .map(dto -> {
					  
					  Integer idProduto = dto.getProduto();
				      Produto produto = produtoRepository
							              .findById(idProduto)
							              .orElseThrow( () -> new RegrasNegocioException("Codigo cliente invalido"));
					  
					  ItemPedido itemPedido = new ItemPedido();
					  itemPedido.setQuantidade(dto.getQuantidade());
					  itemPedido.setPedido(pedido);
					  itemPedido.setProduto(produto);
					  
					   return itemPedido;
				  }).collect(Collectors.toList());
	}
}





















