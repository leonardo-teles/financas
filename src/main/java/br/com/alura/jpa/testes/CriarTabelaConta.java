package br.com.alura.jpa.testes;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriarTabelaConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
		
		emf.close();
	}
}
