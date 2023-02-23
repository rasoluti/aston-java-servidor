package com.rasoluti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rasoluti.model.entidade.Orcamento;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Long>{
	
	@Query(nativeQuery = true,value = "SELECT * FROM orcamento where cod = ?1")
	List<Orcamento> findOrcamento(Long id);
	
	@Query(nativeQuery = true,value = "select * from orcamento where cod = (select max(cod) from orcamento)")
	List<Orcamento> firstOrcamento();

}
