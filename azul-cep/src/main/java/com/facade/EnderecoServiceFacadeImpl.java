package com.facade;


import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.model.Endereco;

@Service
public class EnderecoServiceFacadeImpl implements EnderecoServiceFacade {
	
	@Override
	public Endereco obterCep(String cep) {
		try {
			RestTemplate template = new RestTemplate();
			return template.getForObject("https://viacep.com.br/ws/{cep}/json",Endereco.class, cep);
			
		} catch(HttpClientErrorException e){
			 e.getMessage();
		}
		return null;
	}
}


