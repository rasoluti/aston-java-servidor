package com.rasoluti.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rasoluti.model.dto.GaragemDto;
import com.rasoluti.model.entidade.Garagem;
import com.rasoluti.repository.GaragemRepository;
import com.rasoluti.service.ServiceGaragem;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/garagem")
public class GaragemControl {

	 @Autowired private GaragemRepository repository;
	 
	 @Autowired private ServiceGaragem service;
 	 
	 @GetMapping(value = "/{id}")
	 public ResponseEntity<?> GetById(@PathVariable(value = "id") long id){
	      return ResponseEntity.ok().body(repository.findById(id));
	 }
	
	 @GetMapping(value = "/busca")
	 public ResponseEntity<List<Garagem>> Get(){
	      return ResponseEntity.ok().body(repository.findAll());
	 }
	 
	@PostMapping(value = "/cadastra")
	public ResponseEntity<?> Cadastra(@RequestBody GaragemDto obj,HttpServletRequest request) {	 
			return ResponseEntity.ok(service.salvar(obj));
	 }
	  
	 @DeleteMapping(value = "/{id}")
	 public void delete(@PathVariable(value = "id") long id){
		  repository.deleteById(id);
	 }
	 
	 @DeleteMapping(value = "/")
	 public void deleteAll(){
		  repository.deleteAll();
	 }

}
