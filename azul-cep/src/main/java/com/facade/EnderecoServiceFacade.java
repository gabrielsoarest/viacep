package com.facade;
import com.model.Endereco;

public interface EnderecoServiceFacade {

	/**
	 * Obtem cep via cep Api
	 * @param cep - cep
	 * @return obtem cep
	 */
	public Endereco obterCep(String cep);
	
	
}
