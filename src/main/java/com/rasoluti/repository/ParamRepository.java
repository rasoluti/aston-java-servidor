package com.rasoluti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rasoluti.model.entidade.Parametros;

@Repository
public interface ParamRepository extends JpaRepository<Parametros, Long>{

}

	
