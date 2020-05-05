package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
		EntityManager em = emf.createEntityManager();
		
		// Transient
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setAgencia(1987);
		conta.setNumero(7654);
		
		em.getTransaction().begin();
		
		// Transient -> Managed
		em.persist(conta);
		
		// Managed -> Removed
		em.remove(conta);
		
		em.getTransaction().commit();
	}
}
