package br.com.vendas.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.domain.Fabricante;
import br.com.vendas.domain.Produto;

public class ProdutoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(3L);

		Produto produto = new Produto();
		produto.setDescricao("Caixa de Som");
		produto.setPreco(new BigDecimal(15.50));
		produto.setQuantidade(20);
		produto.setFabricante(fabricante);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
		System.out.println("Produto salvo com sucesso.");
	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listarOrdenado("descricao");

		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Produto produto : resultado) {
			System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getPreco() + " - "
					+ produto.getQuantidade());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getPreco() + " - "
					+ produto.getQuantidade());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(1L);

		if (produto != null) {
			produtoDAO.excluir(produto);
			System.out.println("Nome: " + produto.getDescricao() + " excluído com sucesso");

		} else {
			System.out.println("Nenhum produto encontrado");
		}
	}

	@Test
	@Ignore
	public void editar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(1L);

		produto.setDescricao("Teclado");
		produto.setPreco(new BigDecimal("22.49"));
		produto.setQuantidade(10);

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(4L);
		produto.setFabricante(fabricante);

		produtoDAO.editar(produto);
		System.out.println("Produto: " + produto.getDescricao() + " Preço: " + produto.getPreco() + " Quantidade: "
				+ produto.getQuantidade());

	}
}
