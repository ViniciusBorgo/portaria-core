package org.portaria.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.portaria.domain.Pessoa;
import org.portaria.persistence.util.CRUDUtil;

public class PessoaDAO implements Serializable {

	Pessoa pessoa;
	
	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager em;

	private CRUDUtil<Pessoa> crudUtil = new CRUDUtil<Pessoa>(em, null);

	@PostConstruct
	void init() {
		this.crudUtil = new CRUDUtil<Pessoa>(this.em, Pessoa.class);
	}

	public CRUDUtil<Pessoa> crudUtil() {
		return crudUtil;
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> listaTodos() throws Exception {
		List<Pessoa> obj = new ArrayList<Pessoa>();
		try {
			obj = (List<Pessoa>) em.createNamedQuery("Pessoa.listar").getResultList();
		} catch (NoResultException e) {
			obj = null;
		}
		return obj;
	}

	public Pessoa buscarPorId(Long id) throws Exception {
		pessoa = new Pessoa();
		return pessoa = (Pessoa) em.createNamedQuery("Pessoa.buscarPorId").setParameter("id", id).setMaxResults(1)
				.getSingleResult();
	}

	public Pessoa buscarPorCPF(String cpf) throws Exception {
		pessoa = new Pessoa();
		return pessoa = (Pessoa) em.createNamedQuery("Pessoa.buscarPorCPF").setParameter("cpf", cpf).setMaxResults(1)
				.getSingleResult();

	}

	public Pessoa buscaPorNome(String nome) throws Exception {
		pessoa = new Pessoa();
		return pessoa = (Pessoa) em.createNamedQuery("Pessoa.buscaPorNome").setParameter("nome", nome).setMaxResults(1)
				.getSingleResult();
	}

}
