package br.com.vendas.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Fabricante fabricante1 = new Fabricante();
		fabricante1.setDescricao("Nestlé");

		Fabricante fabricante2 = new Fabricante();
		fabricante2.setDescricao("Colgate");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante1);
		fabricanteDAO.salvar(fabricante2);
	}

	@Test
	@Ignore
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();

		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Fabricante fabricante : resultado) {
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(1L);

		if (fabricante != null) {
			fabricanteDAO.excluir(fabricante);
			System.out.println("Fabricante " + fabricante.getDescricao() + " excluído com sucesso");

		} else {
			System.out.println("Nenhum registro encontrado");
		}
	}

	@Test
	@Ignore
	public void editar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setCodigo(3L);
		fabricante.setDescricao("Rexona");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.editar(fabricante);
		System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
	}
}
