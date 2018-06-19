package com.jf.estrela.microserviceclass.microserviceclass.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jf.estrela.microserviceclass.microserviceclass.entity.Aluno;
import com.jf.estrela.microserviceclass.microserviceclass.service.AlunoService;

import io.swagger.annotations.ApiOperation;

@RestController

@RequestMapping(path = "/api")
public class AlunoController {
	
	
	private AlunoService alunoService = new AlunoService();
	
	
	@GetMapping(value="/aluno/{id}")
	@ApiOperation( "Search aluno by id")
	public ResponseEntity<Aluno> getAluno(@PathVariable Long id) {
		return  ResponseEntity.ok().body(alunoService.getById(id));
	}
	
	@GetMapping(value="/listar")
	@ApiOperation( "Search all aluno")
	public ResponseEntity<List<Aluno> >findAll() {
		return ResponseEntity.ok().body(alunoService.findAll());
	}
	
	@PutMapping(value="/atualizar")
	@ApiOperation( "Upadate aluno by id")
	public ResponseEntity<Aluno> atualizar(@RequestBody Aluno aluno) {
		alunoService.upadate(aluno);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/excluir/{id}")
	@ApiOperation( "Delete aluno by id")
	public ResponseEntity<Aluno> excluir(@PathVariable Long id) {
		alunoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
