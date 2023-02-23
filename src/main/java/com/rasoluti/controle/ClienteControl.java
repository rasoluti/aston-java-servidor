package com.rasoluti.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rasoluti.model.dto.ClienteDto;
import com.rasoluti.model.entidade.Cliente;
import com.rasoluti.repository.ClienteRepository;
import com.rasoluti.service.ServiceCliente;

@RestController
@RequestMapping("/cliente")
public class ClienteControl {
	
	 @Autowired private ClienteRepository repository;
	 @Autowired private ServiceCliente service;;
	   
	 @GetMapping(value = "/{id}")
	 public ResponseEntity<?> GetById(@PathVariable(value = "id") long id){
	      return ResponseEntity.ok().body(repository.findById(id));
	 }
	
	 @GetMapping(value = "/busca")
	 public List<Cliente> Get(){
	      return repository.findAll();
	 }
	  
	 @PostMapping(value = "/cadastra")
	 public ResponseEntity<?> salvar(@RequestBody ClienteDto obj){
	      return new ResponseEntity<Cliente>(service.salvar(obj), HttpStatus.OK);
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
