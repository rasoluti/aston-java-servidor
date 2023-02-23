package com.rasoluti.model.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "orcamento")
public class Orcamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String item;
	@Column(name = "Pequeno")
	private Integer tamP;
	@Column(name = "Medio")
	private Integer tamM;
	@Column(name = "Grande")
	private Integer tamG;
	private Boolean aluminio;
	private String tipo;
	private Double  valor;
	private String marca;
	private String modelo;
	private String placa;
	private String ano;
	private String status;	
	private Long Cod;
	@OneToOne
	private Cliente cliente;
	
	private Double tva;
	private Double desconto;
	
	
	public Orcamento(String item, Integer tamP, Integer tamM, Integer tamG, Boolean aluminio, String tipo) {
		this.item = item;
		this.tamP = tamP;
		this.tamM = tamM;
		this.tamG = tamG;
		this.aluminio = aluminio;
		this.tipo = tipo;
		this.status = "A";
	}
	
	
	public Orcamento(String item, Integer tamP, Integer tamM, Integer tamG, Boolean aluminio, String tipo,
			Double valor) {
		this.item = item;
		this.tamP = tamP;
		this.tamM = tamM;
		this.tamG = tamG;
		this.aluminio = aluminio;
		this.tipo = tipo;
		this.valor = valor;
		this.status = "A";
	}


	public Orcamento() {

	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getTamP() {
		return tamP;
	}

	public void setTamP(Integer tamP) {
		this.tamP = tamP;
	}

	public Integer getTamM() {
		return tamM;
	}

	public void setTamM(Integer tamM) {
		this.tamM = tamM;
	}

	public Integer getTamG() {
		return tamG;
	}

	public void setTamG(Integer tamG) {
		this.tamG = tamG;
	}

	public String getAluminio() {
		
		if (aluminio){
			return "aluminio";
		}else {
			return "";
		}
		
	}

	public void setAluminio(Boolean aluminio) {
		this.aluminio = aluminio;
	}

	public String getTipo() {
		if(tipo.equalsIgnoreCase("P")){
			return "Pintura";
		}else if (tipo.equalsIgnoreCase("R")) {
			return "Reparo";
		}
		
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Long getCod() {
		return Cod;
	}


	public void setCod(Long cod) {
		Cod = cod;
	}


	public Double getTva() {
		return tva;
	}


	public void setTva(Double tva) {
		this.tva = tva;
	}


	public Double getDesconto() {
		return desconto;
	}


	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	
	

}
