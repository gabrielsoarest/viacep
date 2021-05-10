package com.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.Cliente;
import com.persistence.ClienteRepository;
import com.test.AzulTest;

@Service
public class ClienteServiceFacadeImpl implements ClienteServiceFacade {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PersistenceContext
	EntityManager em;
	
	
	/**
	 *{@inheritDoc}
	 */
	@Override
	public void cadastrarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	/**
	 *{@inheritDoc}
	 */
	@Override
	public Boolean isEmailCadastrado(String email) {
		boolean existeEmail = false;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
		Root<Cliente> rootEntry = cq.from(Cliente.class);
		Predicate emailCliente = rootEntry.get("email").in(email);
		cq.where(emailCliente);
		em.createQuery(cq).getResultList();
		
		if(!em.createQuery(cq).getResultList().isEmpty()) {
			existeEmail = true;
		}
		
		return existeEmail;
	}

	
	/**
	 *{@inheritDoc}
	 */
	@Override
	public Boolean isCpfCadastrado(String cpf) {
		boolean existeCpf = false;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		 
		CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
		Root<Cliente> rootEntry = cq.from(Cliente.class);
		Predicate cpfCliente = rootEntry.get("cpf").in(cpf);
		cq.where(cpfCliente);
		em.createQuery(cq).getResultList();
		
		if(!em.createQuery(cq).getResultList().isEmpty()) {
			existeCpf = true;
		}
		
		return existeCpf;
	}

	//AzulTest: public void testisCpfCadastrado()
	
}
