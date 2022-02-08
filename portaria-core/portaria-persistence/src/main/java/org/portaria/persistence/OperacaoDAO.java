package org.portaria.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.portaria.domain.OperacaoPort;
import org.portaria.persistence.util.CRUDUtil;

@Named
public class OperacaoDAO implements Serializable {

	OperacaoPort operacao;
	
	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager em;

	private CRUDUtil<OperacaoPort> crudUtil = new CRUDUtil<OperacaoPort>(em, null);

	@PostConstruct
	void init() {
		this.crudUtil = new CRUDUtil<OperacaoPort>(this.em, OperacaoPort.class);
	}

	public CRUDUtil<OperacaoPort> crudUtil() {
		return crudUtil;
	}

	@SuppressWarnings("unchecked")
	public List<OperacaoPort> listaTodos() throws Exception {
		List<OperacaoPort> obj = new ArrayList<OperacaoPort>();
		try {
			obj = (List<OperacaoPort>) em.createNamedQuery("OperacaoPort.listar").getResultList();
		} catch (NoResultException e) {
			obj = null;
		}
		return obj;
	}

	public OperacaoPort buscarPorId(Long id) throws Exception {
		operacao = new OperacaoPort();
		return operacao = (OperacaoPort) em.createNamedQuery("OperacaoPort.buscarPorId").setParameter("id", id).setMaxResults(1)
				.getSingleResult();
	}


	public OperacaoPort buscaPorNome(String nome) throws Exception {
		operacao = new OperacaoPort();
		return operacao = (OperacaoPort) em.createNamedQuery("OperacaoPort.buscarPorNome").setParameter("nome", nome).setMaxResults(1)
				.getSingleResult();
	}
	
}
