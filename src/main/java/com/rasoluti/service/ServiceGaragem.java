package com.rasoluti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rasoluti.infrastructure.error.NotFoundEx;
import com.rasoluti.model.dto.GaragemDto;
import com.rasoluti.model.entidade.Endereco;
import com.rasoluti.model.entidade.Garagem;
import com.rasoluti.repository.EnderecoRepository;
import com.rasoluti.repository.GaragemRepository;

@Service
public class ServiceGaragem {
	
	 @Autowired private GaragemRepository repository;
	 @Autowired private EnderecoRepository enderecoRepository;
	
	 public Garagem salvar(GaragemDto obj){
		 Endereco e = enderecoRepository.findById(obj.getIdEndereco())
					.orElseThrow(() -> new NotFoundEx("Endereço não encontrado !"));
		 Garagem g = new Garagem();
		 
		 g.setCnpj(obj.getCnpj());
		 g.setEmail(obj.getEmail());
		 g.setEndereco(e);
		 g.setNome(obj.getNomeGaragem());
		 g.setRazao(obj.getRazao());
		 g.setTelefone(obj.getTelefone());
		 
		 return repository.save(g);
		 
	 }

}
