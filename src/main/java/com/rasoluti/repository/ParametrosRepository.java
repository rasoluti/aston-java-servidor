package com.rasoluti.repository;

import java.util.List;

import com.rasoluti.model.entidade.Parametros;

public interface ParametrosRepository extends Persistencia<Parametros> {
	
	 List<Parametros> listarParametrosPorSistema(String categoria);
	 
	 List<Parametros> listarPorCategoriaENomeParametro(String categoria, String nome);

}
