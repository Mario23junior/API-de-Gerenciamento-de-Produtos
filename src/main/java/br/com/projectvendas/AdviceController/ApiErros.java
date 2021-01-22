package br.com.projectvendas.AdviceController;

import java.util.Arrays;
import java.util.List;

public class ApiErros {
   
	private List<String> erros;
	
	public ApiErros(String menssage) {
		 this.erros = Arrays.asList(menssage);
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}
	
	
}
