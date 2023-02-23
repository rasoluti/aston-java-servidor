package com.rasoluti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rasoluti.infrastructure.error.NotFoundEx;
import com.rasoluti.model.dto.ClienteDto;
import com.rasoluti.model.entidade.Cliente;
import com.rasoluti.model.entidade.Endereco;
import com.rasoluti.model.entidade.Garagem;
import com.rasoluti.repository.ClienteRepository;
import com.rasoluti.repository.EnderecoRepository;
import com.rasoluti.repository.GaragemRepository;

@Service
public class ServiceCliente {
	
	 @Autowired private ClienteRepository repository;
	 
	 @Autowired private EnderecoRepository enderecoRepository;
	 
	 @Autowired private GaragemRepository garagemRepository;
	 
	 public Cliente salvar(ClienteDto obj){
	 
		Endereco e = enderecoRepository.findById(obj.getIdEndereco())
				.orElseThrow(() -> new NotFoundEx("Endereço não encontrado !"));
		
		Garagem g = garagemRepository.findById(Long.valueOf(obj.getIdGaragem()))
				.orElseThrow(() -> new NotFoundEx("Garagem não encontrado !"));
		
		 Cliente c = new Cliente();
		 
		 c.setNomeCliente(obj.getNome());
		 c.setCpf(obj.getCpf());
		 c.setRg(obj.getRg());
		 c.setTelefone(obj.getTelefone());
		 c.setEndereco(e);
		 c.setAnoCarro(obj.getAnoCarro());
		 c.setModeloCarro(obj.getModeloCarro());
		 c.setPlacaCarro(obj.getPlacaCarro());
		 c.setGaragem(g);
		 c.setEmail(obj.getEmail());
		 
		 return repository.save(c);
	 
	 }
	
}
