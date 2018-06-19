package com.jf.estrela.microserviceclass.microserviceclass.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jf.estrela.microserviceclass.microserviceclass.entity.Aluno;
import com.jf.estrela.microserviceclass.microserviceclass.entity.AlunoCustom;
import com.jf.estrela.microserviceclass.microserviceclass.service.AlunoService;

@RestController
@RequestMapping(path = "/apihateoas")
public class AlunoHateoasController {
	
	private AlunoService alunoService = new AlunoService();
	
	
	@GetMapping(value="/aluno/{id}")
	public ResponseEntity<AlunoCustom> getAluno(@PathVariable Long id) {
		AlunoCustom alunoCustom = new AlunoCustom(alunoService.getById(id));
		Link link = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(AlunoHateoasController.class)
		          .getAluno(alunoCustom.getAlunoId())).withSelfRel();
		alunoCustom.add(link);
		return  ResponseEntity.ok().body(alunoCustom);
	}
	
	@GetMapping(value="/listar")
	public ResponseEntity<Resources<AlunoCustom> >findAll() {
		List<AlunoCustom> alunos = new ArrayList<>();
		List<Aluno> alunosFind =alunoService.findAll();
		for(Aluno aluno :alunosFind) {
			AlunoCustom alunoCustom = new AlunoCustom(aluno);
			 Link selfLink = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(AlunoHateoasController.class)
			          .getAluno(alunoCustom.getAlunoId())).withSelfRel();
			 alunoCustom.add(selfLink);
			 alunos.add(alunoCustom);
		}
		final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
		Link link = new Link(uriString, "self");
		return ResponseEntity.ok().body(new Resources<>(alunos, link));
	}
	
	@PutMapping(value="/atualizar")
	public ResponseEntity<AlunoCustom> atualizar(@RequestBody Aluno aluno) {
		AlunoCustom alunoCustom = new AlunoCustom(alunoService.upadate(aluno));
		Link link = ControllerLinkBuilder.linkTo(AlunoHateoasController.class).slash(alunoCustom.getAlunoId()).withSelfRel();
		alunoCustom.add(link);	
		return  ResponseEntity.ok().body(alunoCustom);
	}
	
	@DeleteMapping(value="/excluir/{id}")
	public ResponseEntity<Resources<AlunoCustom> >excluir(@PathVariable Long id) {
		List<AlunoCustom> alunos = new ArrayList<>();
		alunoService.delete(id);
		List<Aluno> alunosFind =alunoService.findAll();
		for(Aluno aluno :alunosFind) {
			AlunoCustom alunoCustom = new AlunoCustom(aluno);
			 Link selfLink = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(AlunoHateoasController.class)
			          .excluir(alunoCustom.getAlunoId())).withSelfRel();
			 alunoCustom.add(selfLink);
			 alunos.add(alunoCustom);
		}
		final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
		Link link = new Link(uriString, "self");
		return ResponseEntity.ok().body(new Resources<>(alunos, link));

	}

}
