package br.com.projectvendas.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.projectvendas.Model.Produto;
import br.com.projectvendas.Repositores.ProdutosRepository;

@RestController
@RequestMapping("/api/produtos")
public class ControllerProduto {
    
	private ProdutosRepository produtoRepository;
	
	public ControllerProduto(ProdutosRepository produtosRepository) {
		this.produtoRepository = produtosRepository;
 	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto savePro(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@PutMapping("{id}")
	public void update(@PathVariable Integer id, @RequestBody Produto produto) {
		produtoRepository
		           .findById(id)
		           .map(atualizar -> {
		        	    produto.setId(atualizar.getId());
		        	    produtoRepository.save(produto);
		        	    return produto;
 		           }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Produto inserido não encontrado"));
 	}
	
}
