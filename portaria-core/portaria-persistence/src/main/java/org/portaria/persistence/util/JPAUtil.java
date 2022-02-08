package org.portaria.persistence.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	
	private static EntityManagerFactory em = Persistence.createEntityManagerFactory("ProjetoPU");

	@Produces
	@RequestScoped
	public static EntityManager getEntityManager() {
		EntityManager sessao = em.createEntityManager();
		return sessao;
	}
	public void close(@Disposes EntityManager em) {
		em.close();
	}
	
}
