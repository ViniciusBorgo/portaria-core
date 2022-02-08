package org.portaria.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.portaria.domain.Transporte;
import org.portaria.persistence.util.CRUDUtil;

@Named
public class TransporteDAO implements Serializable {

	Transporte transporte;

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager em;

	private CRUDUtil<Transporte> crudUtil = new CRUDUtil<Transporte>(em, null);

	@PostConstruct
	void init() {
		this.crudUtil = new CRUDUtil<Transporte>(this.em, Transporte.class);
	}

	public CRUDUtil<Transporte> crudUtil() {
		return crudUtil;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public List<Transporte> listaTodos() throws Exception {
		List<Transporte> list = new ArrayList<Transporte>();
		return list = ((List<Transporte>) em.createNamedQuery("Transporte.listar").getResultList());
	}

	public Transporte buscarPorId(Long id) throws Exception {
		transporte = new Transporte();
		return transporte = (Transporte) em.createNamedQuery("Transporte.buscarPorId").setParameter("id", id)
				.setMaxResults(1).getSingleResult();
	}

	public Transporte buscarPorPlaca(String placa) throws Exception {
		transporte = new Transporte();
		return transporte = (Transporte) em.createNamedQuery("Transporte.buscarPorPlaca").setParameter("placa", placa)
				.setMaxResults(1).getSingleResult();
	}

}
