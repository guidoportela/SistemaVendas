package br.com.vendas.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.domain.Item;
import br.com.vendas.domain.Produto;
import br.com.vendas.domain.Venda;

public class ItemDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(1L);

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(1L);

		Item item = new Item();
		item.setProduto(produto);
		item.setQuantidade(5);
		item.setValorParcial(new BigDecimal("32.45"));
		item.setVenda(venda);

		ItemDAO itemDAO = new ItemDAO();
		itemDAO.salvar(item);
		System.out.println("Item salvo com sucesso");
	}
	
	@Test
	@Ignore
	public void listar() {
		ItemDAO itemDAO = new ItemDAO();
		List<Item> resultado = itemDAO.listar();
		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Item item : resultado) {
			System.out.println("Item: " + item.getProduto().getDescricao() + " Preço: " + item.getValorParcial()
					+ " Quantidade: " + item.getQuantidade());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscar(codigo);

		if (item == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println("Item: " + item.getProduto().getDescricao() + " Preço: " + item.getValorParcial()
			+ " Quantidade: " + item.getQuantidade());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscar(1L);

		if (item != null) {
			System.out.println("Item" + item.getProduto().getDescricao() + " excluído com sucesso");

		} else {
			System.out.println("Nenhum produto encontrado");
		}
	}

	@Test
	@Ignore
	public void editar() {
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscar(1L);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(1L);

		item.setProduto(produto);
		item.setQuantidade(12);
		item.setValorParcial(new BigDecimal("99.99"));

		itemDAO.editar(item);
		System.out.println("Item: " + item.getProduto().getDescricao() + " Preço: " + item.getValorParcial()
		+ " Quantidade: " + item.getQuantidade());
	}
}
