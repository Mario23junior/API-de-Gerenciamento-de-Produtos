package br.com.projectvendas.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.projectvendas.Model.Produto;
import br.com.projectvendas.Repositores.ProdutosRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    
	private ProdutosRepository produtoRepository;
	
	public ProdutoController(ProdutosRepository produtosRepository) {
		this.produtoRepository = produtosRepository;
 	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto savePro(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
