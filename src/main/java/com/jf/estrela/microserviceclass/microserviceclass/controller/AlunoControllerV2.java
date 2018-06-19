package com.jf.estrela.microserviceclass.microserviceclass.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jf.estrela.microserviceclass.microserviceclass.entity.Aluno;
import com.jf.estrela.microserviceclass.microserviceclass.service.AlunoService;

@RestController

@RequestMapping(path = "/apiv2",method = RequestMethod.GET,
produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

public class AlunoControllerV2 {
	
	
	private AlunoService alunoService =  new AlunoService();
	
	
	@GetMapping(value="/aluno/{id}")
	public ResponseEntity<Aluno> getAluno(@PathVariable Long id) {
		return  ResponseEntity.ok().body(alunoService.getById(id));
	}
	
	@GetMapping(value="/listar")
	public ResponseEntity<List<Aluno> >findAll() {
		return ResponseEntity.ok().body(alunoService.findAll());
	}
	
	@PutMapping(value="/atualizar")
	public ResponseEntity<Aluno> atualizar(@RequestBody Aluno aluno) {
		alunoService.upadate(aluno);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/excluir/{id}")
	public ResponseEntity<Aluno> excluir(@PathVariable Long id) {
		alunoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
