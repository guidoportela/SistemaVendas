package br.com.vendas.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.vendas.domain.Item;
import br.com.vendas.util.HibernateUltil;

public class ItemDAO {
	public void salvar(Item item) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(item);
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
	public List<Item> listar() {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Item.class);
			List<Item> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
	}

	public Item buscar(Long codigo) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Item.class);
			consulta.add(Restrictions.idEq(codigo));
			Item resultado = (Item) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
	}

	public void excluir(Item item) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(item);
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

	public void editar(Item item) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(item);
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
