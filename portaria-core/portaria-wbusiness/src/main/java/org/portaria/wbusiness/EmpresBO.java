package org.portaria.wbusiness;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.portaria.domain.Empresa;
import org.portaria.persistence.EmpresaDAO;
import org.portaria.persistence.util.JPAUtil;

public class EmpresBO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	Empresa empresa;

	@Inject
	EmpresaDAO empresaDAO;

	// Classe Pessoa
	public void salvar(Empresa pessoa) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();
		em.persist(pessoa);
		transacao.commit();
		em.close();
	}

	public Empresa pessoaBuscarPorId(Long value) throws Exception {
		return this.empresaDAO.crudUtil().buscaPorId(value);
	}

	public Empresa findPessoa(String nome) throws Exception {
		empresa = (Empresa) empresaDAO.buscaPorNome(nome);
		return empresa;
	}

	public String buscarPorCPF(String cnpj) throws Exception {
		empresa = (Empresa) empresaDAO.buscarPorCPF(cnpj);
		return cnpj;
	}

	public List<Empresa> pessoaListar() throws Exception {
		return this.empresaDAO.crudUtil().listaTodos();
	}

	public void empresaRemover(Empresa empresa) throws Exception {
		this.empresaDAO.crudUtil().remove(empresa);
	}
}
