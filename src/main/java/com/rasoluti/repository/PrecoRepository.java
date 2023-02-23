package com.rasoluti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rasoluti.model.entidade.Preco;

@Repository
public interface PrecoRepository extends JpaRepository<Preco, Long>{
	
	@Query(value = "SELECT valor FROM preco WHERE impacto = ?1 and tamanho = ?2",nativeQuery = true)
	Double valorNative(Integer impacto, String tam);

}
