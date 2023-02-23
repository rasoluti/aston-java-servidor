package com.rasoluti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rasoluti.model.entidade.Garagem;

@Repository
public interface GaragemRepository extends JpaRepository<Garagem, Long>{

}
