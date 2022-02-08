package org.portaria.wbusiness;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.portaria.domain.Pessoa;
import org.portaria.persistence.PessoaDAO;
import org.portaria.persistence.util.JPAUtil;

public class PessoaBO {
	private Pessoa pessoa;

	@Inject
	PessoaDAO pessoaDAO;

	// Classe Pessoa
	public void salvar(Pessoa pessoa) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction transacao;
		transacao = em.getTransaction();
		transacao.begin();
		em.persist(pessoa);
		transacao.commit();
		em.close();
	}

	public Pessoa pessoaBuscarPorId(Long value) {
		try {
			return this.pessoaDAO.crudUtil().buscaPorId(value);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return null;
		}
	}

	public Pessoa findPessoa(String nome) throws Exception {
		try {
			pessoa = (Pessoa) pessoaDAO.buscaPorNome(nome);
			return pessoa;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return null;
		}
	}

	public String buscarPorCPF(String cpf) throws Exception {
		try {
			pessoa = (Pessoa) pessoaDAO.buscarPorCPF(cpf);
			return cpf;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return null;
		}
	}

	public List<Pessoa> pessoaListar() {
		return this.pessoaDAO.crudUtil().listaTodos();
	}

	public void pessoaRemover(Pessoa pessoa) {
		try {
			this.pessoaDAO.crudUtil().remove(pessoa);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
