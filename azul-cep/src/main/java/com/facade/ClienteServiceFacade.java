package com.facade;

import com.model.Cliente;

/**
 * Cliente ServiceFacade
 * @author Gabriel
 *
 */
public interface ClienteServiceFacade {

	/** 
	 * Cadastra cliente na base de dados
	 * @param cliente - cliente
	 */
	public void cadastrarCliente(Cliente cliente);
	
	/**
	 * Verifica se existe email cadastrado
	 * @param cliente - cliente
	 * @return Boolean
	 */
	public Boolean isEmailCadastrado(String email);
	
	/**
	 * Verifica se existe cpf cadastrado
	 * @param cliente - cliente
	 * @return Boolean
	 */
	public Boolean isCpfCadastrado(String cpf);
	
	
	
}
