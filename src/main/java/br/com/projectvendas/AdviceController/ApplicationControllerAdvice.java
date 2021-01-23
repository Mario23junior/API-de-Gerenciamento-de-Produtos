package br.com.projectvendas.AdviceController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.projectvendas.Exception.PedidoNaoEncontradoException;
import br.com.projectvendas.Exception.RegrasNegocioException;


@RestControllerAdvice
public class ApplicationControllerAdvice {
     
	 @ExceptionHandler(RegrasNegocioException.class)
	 @ResponseStatus(HttpStatus.BAD_REQUEST)
	 public ApiErros handleRegraNegocioException(RegrasNegocioException ex) {
		  String menssagemErro = ex.getMessage();
		  return new ApiErros(menssagemErro);  
	 }
	 
	 @ResponseStatus(HttpStatus.NOT_FOUND)
	 @ExceptionHandler(PedidoNaoEncontradoException.class)
	 public ApiErros hendlePedidoNaoEncontradoException(PedidoNaoEncontradoException ex) {
		 return new ApiErros(ex.getMessage());   
	 }
	 
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	 @ResponseStatus(HttpStatus.BAD_REQUEST)
	 public ApiErros handleMethodNotValidException(MethodArgumentNotValidException ex) {
		List<String> ResultDefauterros = ex.getBindingResult().getAllErrors()
				        .stream()
		                  .map(erro -> erro.getDefaultMessage())
		                  .collect(Collectors.toList());
		return new ApiErros(ResultDefauterros);
		 
		 
	 }
}
