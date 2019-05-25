package br.com.vendas.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.vendas.dao.FabricanteDAO;
import br.com.vendas.domain.Fabricante;
import br.com.vendas.util.FacesUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {
	private Fabricante fabricante;
	private List<Fabricante> fabricantes;

	public Fabricante getFabricante() {
		if (fabricante == null) {
			fabricante = new Fabricante();
		}
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public void listar() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listarOrdenado("descricao");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os fabricantes");
			erro.printStackTrace();
		}
	}

	public void novoFabricante() {
		fabricante = new Fabricante();
	}

	public void salvar() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.salvar(fabricante);

			novoFabricante();
			Messages.addGlobalInfo("Fabricante salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar esse fabricante");
			erro.printStackTrace();
		}
	}

	public void carregarCadastro() {
		try {
			String valor = FacesUtil.getParam("fabricanteSelecionado");

			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				FabricanteDAO fabricanteDAO = new FabricanteDAO();
				fabricante = fabricanteDAO.buscar(codigo);
			}

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar carregar os dados do fabricante");
			erro.printStackTrace();
		}
	}

	public void excluir() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.excluir(fabricante);
			fabricantes = fabricanteDAO.listarOrdenado("descricao");
			Messages.addGlobalInfo("Fabricante removido com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover esse fabricante");
			erro.printStackTrace();
		}
	}

	public void editar() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.excluir(fabricante);
			novoFabricante();
			Messages.addGlobalInfo("Fabricante editado com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar editar esse fabricante");
			erro.printStackTrace();
		}
	}
}
