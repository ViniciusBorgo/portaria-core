package org.portaria.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.portaria.domain.Empresa;
import org.portaria.persistence.util.CRUDUtil;

@Named
public class EmpresaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	Empresa empresa;

	@Inject
	EntityManager em;

	private CRUDUtil<Empresa> crudUtil = new CRUDUtil<Empresa>(em, null);

	@PostConstruct
	void init() {
		this.crudUtil = new CRUDUtil<Empresa>(this.em, Empresa.class);
	}

	public CRUDUtil<Empresa> crudUtil() {
		return crudUtil;
	}

	@SuppressWarnings("unchecked")
	public List<Empresa> listaTodos() throws Exception {
		List<Empresa> obj = new ArrayList<Empresa>();
		try {
			obj = (List<Empresa>) em.createNamedQuery("Empresa.listar").getResultList();
		} catch (NoResultException e) {
			obj = null;
		}
		return obj;
	}

	public Empresa buscarPorId(Long id) throws Exception {
		empresa = new Empresa();
		return empresa = (Empresa) em.createNamedQuery("Empresa.buscarPorId").setParameter("id", id).setMaxResults(1)
				.getSingleResult();
	}

	public Empresa buscarPorCPF(String cnpj) throws Exception {
		empresa = new Empresa();
		return empresa = (Empresa) em.createNamedQuery("Empresa.buscarPorCNPJ").setParameter("cnpj", cnpj)
				.setMaxResults(1).getSingleResult();

	}

	public Empresa buscaPorNome(String nome) throws Exception {
		empresa = new Empresa();
		return empresa = (Empresa) em.createNamedQuery("Empresa.buscaPorNome").setParameter("nome", nome)
				.setMaxResults(1).getSingleResult();
	}

}
