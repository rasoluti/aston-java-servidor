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

import com.rasoluti.model.entidade.Parametros;
import com.rasoluti.repository.ParamRepository;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/parametro")
public class ParametrosControl {
	
	 @Autowired private ParamRepository repository;
 	 
	 @GetMapping(value = "/{id}")
	 public ResponseEntity<?> GetById(@PathVariable(value = "id") long id){
	      return ResponseEntity.ok().body(repository.findById(id));
	 }
	
	 @GetMapping(value = "/busca")
	 public ResponseEntity<List<Parametros>> Get(){
	      return ResponseEntity.ok().body(repository.findAll());
	 }
	 
	@PostMapping(value = "/cadastra")
	public ResponseEntity<?> Cadastra(@RequestBody Parametros obj,HttpServletRequest request) {	 
			return ResponseEntity.ok(repository.save(obj));
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
