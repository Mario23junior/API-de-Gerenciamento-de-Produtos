package br.com.projectvendas.Controllers;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.projectvendas.Dto.InformacaoesPedidoDTO;
import br.com.projectvendas.Dto.InformacoesItemPedidoDTO;
import br.com.projectvendas.Dto.PedidoDTO;
import br.com.projectvendas.Model.ItemPedido;
import br.com.projectvendas.Model.Pedido;
import br.com.projectvendas.Service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class ControllerPedido {
      
	private PedidoService service;
	
	public ControllerPedido(PedidoService service) {
		this.service = service;
 	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Integer save(@RequestBody PedidoDTO pedidoDto) {
		Pedido pedido = service.salvarPedido(pedidoDto);
		return pedido.getId();
	}
	
	@GetMapping("/{id}")
	public InformacaoesPedidoDTO AllInformation(@PathVariable Integer id) {
		return service
				   .ObterDetalhesPedido(id)
		           .map( p -> converter(p))
		           .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Pedido não encontrado"));
		           
	}
	
	private InformacaoesPedidoDTO converter(Pedido pedido) {
		 return InformacaoesPedidoDTO
		                  .builder()
		                  .codigo(pedido.getId())
		                  .dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
		                  .cpf(pedido.getCliente().getCpf())
		                  .nomeCliente(pedido.getCliente().getNome())
		                  .total(pedido.getTotal())
		                  .status(pedido.getStatus().name())
		                  .items(converter(pedido.getItens()))
		                  .build();
		                  
		  
	}
	
	private List<InformacoesItemPedidoDTO> converter(List<ItemPedido> itens) {
	         if(CollectionUtils.isEmpty(itens)) {
	        	 return Collections.emptyList();
	         }
	         
	         return itens
	        		    .stream()
	        		    .map(item -> InformacoesItemPedidoDTO
		        		    .builder() 
		        		    .descricaoProduto(item.getProduto().getDescricao())
		        		    .precoUnitario(item.getProduto().getPreco())
		        		    .quantidade(item.getQuantidade())
		        		    .build()
	        		   ).collect(Collectors.toList());
	}
	
     
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
