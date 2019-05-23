package br.com.vendas.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.vendas.domain.Funcionario;
import br.com.vendas.util.HibernateUltil;

public class FuncionarioDAO {

	public void salvar(Funcionario funcionario) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(funcionario);
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
	public List<Funcionario> listar() {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Funcionario.class);
			List<Funcionario> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> listarOrdenado(String campoOrdenacao) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Funcionario.class);
			consulta.addOrder(Order.asc(campoOrdenacao));
			List<Funcionario> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
	}

	public Funcionario buscar(Long codigo) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Funcionario.class);
			consulta.add(Restrictions.idEq(codigo)); // Pega o valor digitado e compara com a chave primaria da entidade
			Funcionario resultado = (Funcionario) consulta.uniqueResult(); // retorna somente 1 valor
			return resultado;
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
	}

	public void excluir(Funcionario funcionario) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(funcionario);
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

	public void excluirPorCodigo(Long codigo) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			Funcionario funcionario = buscar(codigo);
			sessao.delete(funcionario);
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

	public void editar(Funcionario funcionario) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(funcionario);
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
