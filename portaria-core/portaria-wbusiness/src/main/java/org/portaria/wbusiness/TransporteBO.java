package org.portaria.wbusiness;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.portaria.domain.Transporte;
import org.portaria.persistence.TransporteDAO;
import org.portaria.persistence.util.JPAUtil;

public class TransporteBO {

	@Inject
	TransporteDAO transporteDAO;

	public void salvar(Transporte transporte) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();
		em.persist(transacao);
		transacao.commit();
		em.close();
	}

	public Transporte buscarPorId(Long id) {
		try {
			return this.transporteDAO.crudUtil().buscaPorId(id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return null;
		}
	}

	public Transporte findTransporte(String placa) {
		try {
			return this.transporteDAO.crudUtil().buscarPorNome(placa);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return null;
		}
	}
	
	public List<Transporte> pessoaListar() {
		return this.transporteDAO.crudUtil().listaTodos();
	}
	
	public void transporteRemover(Transporte transporte) {
		try {
			this.transporteDAO.crudUtil().remove(transporte);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
