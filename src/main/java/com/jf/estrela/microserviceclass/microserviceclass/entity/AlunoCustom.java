package com.jf.estrela.microserviceclass.microserviceclass.entity;

import org.springframework.hateoas.ResourceSupport;


public class AlunoCustom extends ResourceSupport{
	
	private Long alunoId;
	private String nome;
	private Integer matricula;
	private String email;
	
	public AlunoCustom() {
		
	}

	public AlunoCustom(Aluno aluno) {
		super();
		if(aluno != null) {
			this.alunoId = aluno.getId();
			this.nome = aluno.getNome();
			this.matricula = aluno.getMatricula();
			this.email = aluno.getEmail();
		}
	}


	public Long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
