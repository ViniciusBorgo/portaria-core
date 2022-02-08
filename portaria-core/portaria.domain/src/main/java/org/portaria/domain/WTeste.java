package org.portaria.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class WTeste {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoPU");
		EntityManager sessao = factory.createEntityManager();
		EntityTransaction tx = sessao.getTransaction();
		tx.begin();

		Empresa e = new Empresa();
		e.setCnpj("123456788");
		e.setNome("Teste");
		
		Pessoa p = new Pessoa();
		p.setCpf("33024955870");
		p.setNome("Maria da Silva");
		p.setEmpresa(e);
		p.setTelefone("11964232xxx");
		
		
		Transporte t = new Transporte();
		t.setModelo("CaminhÃ£o BAU");
		t.setPlaca("xxx-1024");
		t.setPessoa(p);
		
		OperacaoPort op = new OperacaoPort();
	    op.setNome("");
	    op.setDescricao("Saida de Pedidos");
	    op.setPessoa(p);
		
		
		
		System.out.println(e+"\n"+p+"\n"+t+"\n"+op);
		
		sessao.persist(e);
		sessao.persist(p);
		sessao.persist(t);
		sessao.persist(op);

		tx.commit();
		sessao.close();
		factory.close();
	}

}