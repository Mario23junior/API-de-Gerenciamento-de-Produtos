package br.com.projectvendas.Dto;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.projectvendas.Validation.NotEmptyList;

public class PedidoDTO {
    
	@NotNull(message = "Informe o codigo do cliente")
	private Integer cliente;
	
	@NotNull(message = "Campo total e obrigatorio")
	private BigDecimal total;
	
	@NotEmptyList(message = "Pedido não pode ser Realizado sem itens")
	private List<ItemPedidoDTO> items; 
	
	
	public Integer getCliente() {
		return cliente;
	}
	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public List<ItemPedidoDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemPedidoDTO> items) {
		this.items = items;
	}
	
	
	
	
}
