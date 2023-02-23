package com.rasoluti.model.dto;

public class OrcamentoItensDto {

	private String item;
	private Integer tamP;
	private Integer tamM;
	private Integer tamG;
	private Boolean aluminio;
	private String tipo;
	
	public OrcamentoItensDto(String item, Integer tamP, Integer tamM, Integer tamG, Boolean aluminio, String tipo) {
		this.item = item;
		this.tamP = tamP;
		this.tamM = tamM;
		this.tamG = tamG;
		this.aluminio = aluminio;
		this.tipo = tipo;
	}

	public OrcamentoItensDto() {

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
	
	
		

}
