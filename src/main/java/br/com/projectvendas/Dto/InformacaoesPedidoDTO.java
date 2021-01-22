package br.com.projectvendas.Dto;

import java.math.BigDecimal;
import java.util.List;

public class InformacaoesPedidoDTO {
   
	private Integer codigo;
	private String cpf;
	private String nome;
	private BigDecimal total;
	private List<InformacoesItemPedidoDTO> items;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public List<InformacoesItemPedidoDTO> getItems() {
		return items;
	}
	public void setItems(List<InformacoesItemPedidoDTO> items) {
		this.items = items;
	} 
	
	
	
}
