package br.com.vendas.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.vendas.domain.Fabricante;
import br.com.vendas.util.HibernateUltil;

public class FabricanteDAO {
	public void salvar(Fabricante fabricante) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(fabricante);
			transacao.commit();

		} catch (RuntimeException excecao) {
			if (transacao != null) {
				transacao.rollback(); // desfazer a sessao
			}
			throw excecao;
		} finally { // finaliza a sessao
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> listar() {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Fabricante.class);
			List<Fabricante> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> listarOrdenado(String campoOrdenacao) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Fabricante.class);
			consulta.addOrder(Order.asc(campoOrdenacao));
			List<Fabricante> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
	}

	public Fabricante buscar(Long codigo) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Fabricante.class);
			consulta.add(Restrictions.idEq(codigo)); // Pega o valor digitado e compara com a chave primaria da entidade
			Fabricante resultado = (Fabricante) consulta.uniqueResult(); // retorna somente 1 valor
			return resultado;
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
	}

	public void excluir(Fabricante fabricante) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(fabricante);
			transacao.commit();

		} catch (RuntimeException excecao) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw excecao;
		} finally { // finaliza a sessao
			sessao.close();
		}
	}

	public void editar(Fabricante fabricante) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			// Fabricante fabricanteEditar = buscar(fabricante.getCodigo());
			// fabricanteEditar.setDescricao(fabricante.getDescricao());
			// sessao.update(fabricanteEditar);
			sessao.update(fabricante);
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