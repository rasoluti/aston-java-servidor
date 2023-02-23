package com.rasoluti.model.dto;

public class OrcamentoDto {
	
	private String item;
	private Integer tamP;
	private Integer tamM;
	private Integer tamG;
	private Boolean aluminio;
	private String tipo;
	private Float  valor;
	private String marca;
	private String modelo;
	private String placa;
	private String ano;
	private String status;	
	private Long idCliente;
	

	public OrcamentoDto() {
	
	}
	public OrcamentoDto(String item, Integer tamP, Integer tamM, Integer tamG, Boolean aluminio, String tipo,
			Float valor, String marca, String modelo, String placa, String ano, String status, Long idCliente) {
		this.item = item;
		this.tamP = tamP;
		this.tamM = tamM;
		this.tamG = tamG;
		this.aluminio = aluminio;
		this.tipo = tipo;
		this.valor = valor;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
		this.status = status;
		this.idCliente = idCliente;
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
	public Boolean getAluminio() {
		return aluminio;
	}
	public void setAluminio(Boolean aluminio) {
		this.aluminio = aluminio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
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
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
	
}
