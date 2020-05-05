package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
		EntityManager em = emf.createEntityManager();
		
		Categoria c1 = new Categoria("Viagem");
		Categoria c2 = new Categoria("Negócios");
		
		Conta conta = new Conta();
		conta.setId(2L);
		
		Movimentacao m1 = new Movimentacao();
		m1.setDescricao("Viagem à SP");
		m1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		m1.setData(LocalDateTime.now());
		m1.setValor(new BigDecimal(300.0));
		m1.setCategorias(Arrays.asList(c1, c2));
		m1.setConta(conta);
		
		Movimentacao m2 = new Movimentacao();
		m2.setDescricao("Viagem ao RJ");
		m2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		m2.setData(LocalDateTime.now());
		m2.setValor(new BigDecimal(400.0));
		m2.setCategorias(Arrays.asList(c1, c2));
		m2.setConta(conta);
		
		em.getTransaction().begin();
		
		em.persist(c1);
		em.persist(c2);
		
		em.persist(m1);
		em.persist(m2);
		
		em.getTransaction().commit();
		em.close();
	}
}
