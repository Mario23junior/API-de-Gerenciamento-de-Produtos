package br.com.projectvendas.AdviceController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.projectvendas.Exception.RegrasNegocioException;


@RestControllerAdvice
public class ApplicationControllerAdvice {
     
	 @ExceptionHandler(RegrasNegocioException.class)
	 @ResponseStatus(HttpStatus.BAD_REQUEST)
	 public ApiErros handleRegraNegocioException(RegrasNegocioException ex) {
		  String menssagemErro = ex.getMessage();
		  return new ApiErros(menssagemErro);
		  
	 }
}
