package br.com.vendas.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.domain.Funcionario;
import br.com.vendas.domain.Venda;

public class VendaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(3L);

		Venda venda = new Venda();
		venda.setFuncionario(funcionario);
		venda.setHorario(new Date());
		venda.setValorTotal(new BigDecimal("45.54"));

		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.salvar(venda);
		System.out.println("Venda realizada com sucesso");
	}

	@Test
	@Ignore
	public void listar() {
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> resultado = vendaDAO.listar();
		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Venda venda : resultado) {
			System.out.println("Funcionário: " + venda.getFuncionario().getNome() + " Horário: " + venda.getHorario()
					+ " Preço: " + venda.getValorTotal());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigo);

		if (venda == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println("Funcionário: " + venda.getFuncionario().getNome() + " Horário: " + venda.getHorario()
					+ " Preço: " + venda.getValorTotal());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(1L);

		if (venda != null) {
			System.out.println("Venda realizada pelo(a)" + venda.getFuncionario().getNome() + " excluída com sucesso");

		} else {
			System.out.println("Nenhum produto encontrado");
		}
	}

	@Test
	@Ignore
	public void editar() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(1L);

		venda.setHorario(new Date());
		venda.setValorTotal(new BigDecimal("98.45"));

		vendaDAO.editar(venda);
		System.out.println("Funcionário: " + venda.getFuncionario().getNome() + " Horário: " + venda.getHorario()
				+ " Preço: " + venda.getValorTotal());
	}
}
