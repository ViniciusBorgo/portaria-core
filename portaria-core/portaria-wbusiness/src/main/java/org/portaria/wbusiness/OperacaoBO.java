package org.portaria.wbusiness;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.portaria.domain.OperacaoPort;
import org.portaria.persistence.OperacaoDAO;
import org.portaria.persistence.util.JPAUtil;

public class OperacaoBO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	OperacaoPort operacao;

	@Inject
	OperacaoDAO operacaoDAO;

	// Classe Pessoa
	public void salvar(OperacaoPort operacao) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();
		em.persist(operacao);
		transacao.commit();
		em.close();
	}

	public OperacaoPort pessoaBuscarPorId(Long value) throws Exception {
		return this.operacaoDAO.crudUtil().buscaPorId(value);
	}

	public OperacaoPort findPessoa(String nome) throws Exception {
		operacao = (OperacaoPort) operacaoDAO.buscaPorNome(nome);
		return operacao;
	}

	public List<OperacaoPort> pessoaListar() throws Exception {
		return this.operacaoDAO.crudUtil().listaTodos();
	}

	public void operacaoRemover(OperacaoPort operacao) throws Exception {
		this.operacaoDAO.crudUtil().remove(operacao);
	}

	
}
