package com.cep.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.facade.ClienteServiceFacade;
import com.facade.EnderecoServiceFacade;
import com.model.Cliente;
import com.model.Endereco;
import com.test.AzulTest;

@RestController
public class IndexController {
	
	@Autowired
	private EnderecoServiceFacade enderecoService;
	
	@Autowired
	private ClienteServiceFacade clienteService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView form() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView form(Cliente cliente) {
		
		if((clienteService.isCpfCadastrado(cliente.getCpf()) != Boolean.TRUE && 
				clienteService.isEmailCadastrado(cliente.getEmail()) !=Boolean.TRUE)) {
			
			Endereco endereco = enderecoService.obterCep(cliente.getCep());
			
			if(endereco!=null) {
				cliente.setLogradouro(endereco.getLogradouro());
				cliente.setCep(endereco.getCep());
				clienteService.cadastrarCliente(cliente);
				System.out.println("Cliente cadastrado");
			}
			
		} else {
			System.out.println("Usuario nao cadastrado. Verifique seu email ou cpf");
		}
		
		return new ModelAndView("index");
	}


	
}
