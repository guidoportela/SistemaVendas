package br.com.vendas.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.vendas.domain.Produto;
import br.com.vendas.util.HibernateUltil;

public class ProdutoDAO {
	public void salvar(Produto produto) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(produto);
			transacao.commit();

		} catch (RuntimeException excecao) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw excecao;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Produto> listarOrdenado(String campoOrdenacao) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Produto.class);
			consulta.addOrder(Order.asc(campoOrdenacao));
			List<Produto> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
	}

	public Produto buscar(Long codigo) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Produto.class);
			consulta.add(Restrictions.idEq(codigo));
			Produto resultado = (Produto) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
	}

	public void excluir(Produto produto) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(produto);
			transacao.commit();
		} catch (RuntimeException excecao) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw excecao;
		} finally {
			sessao.close();
		}
	}

	public void editar(Produto produto) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(produto);
			transacao.commit();

		} catch (RuntimeException excecao) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw excecao;
		} finally {
			sessao.close();
		}
	}
}
