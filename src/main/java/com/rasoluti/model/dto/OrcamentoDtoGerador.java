package com.rasoluti.model.dto;


public class OrcamentoDtoGerador {
	
	private Long Id;
	private String item;
	private Integer tamP;
	private Integer tamM;
	private Integer tamG;
	private Boolean aluminio;
	private String tipo;
	private Double  valor;
	private String nomeCliente;
	private String garagem;
	private String modeloCarro;
	private String placaCarro;
	private String anoCarro;
	
	
	public OrcamentoDtoGerador() {

	}

	public OrcamentoDtoGerador(Long id, String item, Integer tamP, Integer tamM, Integer tamG, Boolean aluminio,
			String tipo, Double valor, String nomeCliente, String garagem, String modeloCarro, String placaCarro,
			String anoCarro) {
		Id = id;
		this.item = item;
		this.tamP = tamP;
		this.tamM = tamM;
		this.tamG = tamG;
		this.aluminio = aluminio;
		this.tipo = tipo;
		this.valor = valor;
		this.nomeCliente = nomeCliente;
		this.garagem = garagem;
		this.modeloCarro = modeloCarro;
		this.placaCarro = placaCarro;
		this.anoCarro = anoCarro;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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
			return "Reserva";
		}
		
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getGaragem() {
		return garagem;
	}

	public void setGaragem(String garagem) {
		this.garagem = garagem;
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
	
		

}
