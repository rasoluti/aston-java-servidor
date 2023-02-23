package com.rasoluti.model.dto;

public class GaragemDto {
	
	private String nomeGaragem;
	private String razao;
	private String cnpj;
	private String telefone;
	private String email;	
	private Long idEndereco;
	
	public GaragemDto(String nomeGaragem, String razao, String cnpj, String telefone, String email, Long idEndereco) {
		this.nomeGaragem = nomeGaragem;
		this.razao = razao;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
		this.idEndereco = idEndereco;
	}

	public GaragemDto() {
	}

	public String getNomeGaragem() {
		return nomeGaragem;
	}

	public void setNomeGaragem(String nomeGaragem) {
		this.nomeGaragem = nomeGaragem;
	}

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}
	
}
