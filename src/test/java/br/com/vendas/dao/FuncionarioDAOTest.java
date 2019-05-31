package br.com.vendas.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.domain.Funcionario;

public class FuncionarioDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Funcionario funcionario1 = new Funcionario();
		funcionario1.setNome("Guido");
		funcionario1.setCpf("11111111111");
		funcionario1.setCarteiraTrabalho("111111111111111");
		funcionario1.setDataAdmissao(new Date());
		funcionario1.setFuncao("Administrador");
		funcionario1.setSenha("1234");

		Funcionario funcionario2 = new Funcionario();
		funcionario2.setNome("Julia");
		funcionario2.setCpf("21111111111");
		funcionario2.setCarteiraTrabalho("111111111111111");
		funcionario2.setDataAdmissao(new Date());
		funcionario2.setFuncao("Administrador");
		funcionario2.setSenha("4321");

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.salvar(funcionario1);
		funcionarioDAO.salvar(funcionario2);
	}

	@Test
	@Ignore
	public void listar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> resultado = funcionarioDAO.listar();

		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Funcionario funcionario : resultado) {
			System.out.println(funcionario.getNome() + " - " + funcionario.getCpf());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);

		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println(funcionario.getNome() + " - " + funcionario.getCpf());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1L);

		if (funcionario != null) {
			funcionarioDAO.excluir(funcionario);
			System.out.println("Nome: " + funcionario.getNome() + " excluído com sucesso");

		} else {
			System.out.println("Nenhum registro encontrado");
		}
	}

	@Test
	@Ignore
	public void editar() {
		Funcionario funcionario = new Funcionario();
		funcionario.setCodigo(3L);

		funcionario.setNome("Guido Portela");
		funcionario.setCpf("11111111111");
		funcionario.setFuncao("Administrador");
		funcionario.setSenha("12345");

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.editar(funcionario);
		System.out.println("Funcionário: " + funcionario.getNome() + " - " + funcionario.getCpf());
	}

}
