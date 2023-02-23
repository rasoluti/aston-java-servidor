package com.rasoluti.model.dto;

public class ClienteDto {	
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	private String rg;
	private String modeloCarro;
	private String placaCarro;
	private String anoCarro;
	private Long idEndereco;
    private Long idGaragem;
    
	public ClienteDto() {
	}

	public ClienteDto(String nome, String email, String telefone, String cpf, String rg, String modeloCarro,
			String placaCarro, String anoCarro, Long idEndereco, Long idGaragem) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.rg = rg;
		this.modeloCarro = modeloCarro;
		this.placaCarro = placaCarro;
		this.anoCarro = anoCarro;
		this.idEndereco = idEndereco;
		this.idGaragem = idGaragem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}

	public String getAnoCarro() {
		return anoCarro;
	}

	public void setAnoCarro(String anoCarro) {
		this.anoCarro = anoCarro;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public Long getIdGaragem() {
		return idGaragem;
	}

	public void setIdGaragem(Long idGaragem) {
		this.idGaragem = idGaragem;
	}
	
}
