package com.rasoluti.repository;

import java.io.Serializable;

import java.util.List;

import jakarta.persistence.EntityManager;

public interface Persistencia<E> extends Serializable {
	
	void incluir(E paramE) ;

    List<E> alterar(List<E> paramList) ;

    E alterar(E paramE) ;

    void excluirPorId(Object paramObject);

    void validar(E paramE);

    List<E> listar();

    E consultar(Object paramObject);

    void flush();

    void clear();

    EntityManager getEntityManager();

}
