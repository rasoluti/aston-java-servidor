package com.rasoluti.model.dto;

public class OrcamentoHeaderDto {
	private String nomeCliente;
	private String garagem;
	private String modeloCarro;
	private String placaCarro;
	private String anoCarro;

	public OrcamentoHeaderDto(String nomeCliente, String garagem, String modeloCarro, String placaCarro,
			String anoCarro) {
		this.nomeCliente = nomeCliente;
		this.garagem = garagem;
		this.modeloCarro = modeloCarro;
		this.placaCarro = placaCarro;
		this.anoCarro = anoCarro;
	}
	
		public OrcamentoHeaderDto(){
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
