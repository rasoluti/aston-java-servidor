package com.rasoluti.model.entidade;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "preco")
public class Preco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private long impacto;
	private String tamanho;
	private Double valor;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public long getImpacto() {
		return impacto;
	}
	public void setImpacto(long impacto) {
		this.impacto = impacto;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	

}
