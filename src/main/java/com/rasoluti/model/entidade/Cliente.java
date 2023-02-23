package com.rasoluti.model.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "nome")
	private String nomeCliente;
	private String email;
	private String telefone;
	private String cpf;
	private String rg;
	private String modeloCarro;
	private String placaCarro;
	private String anoCarro;
	@OneToOne
	private Endereco endereco;
	@OneToOne
    private Garagem garagem;
	
	public Cliente(String nomeCliente, String email, String telefone, String cpf, String rg, String modeloCarro,
			String placaCarro, String anoCarro, Endereco endereco, Garagem garagem) {
		this.nomeCliente = nomeCliente;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.rg = rg;
		this.modeloCarro = modeloCarro;
		this.placaCarro = placaCarro;
		this.anoCarro = anoCarro;
		this.endereco = endereco;
		this.garagem = garagem;
	}

	public Cliente() {
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
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


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public Garagem getGaragem() {
		return garagem;
	}


	public void setGaragem(Garagem garagem) {
		this.garagem = garagem;
	}
	
	

}
