package br.com.vendas.util;

import org.hibernate.Session;
import org.junit.Test;

import br.com.vendas.util.HibernateUltil;

public class HibernateUtilTest {

	@Test
	public void conectar() {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUltil.getFabricaDeSessoes().close();
	}
}
