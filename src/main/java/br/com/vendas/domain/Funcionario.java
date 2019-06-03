package br.com.vendas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigoFuncionario")
	private Long codigo;

	@Column(length = 50, nullable = false)
	private String nome;

	@CPF(message = "O CPF informado é invalido.")
	@Column(length = 14, nullable = false, unique = true)
	private String cpf;

	@Column(length = 15, nullable = false)
	private String carteiraTrabalho;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;

	@Column(length = 32, nullable = false)
	private String senha;

	@Column(length = 30, nullable = false)
	private String funcao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
}
