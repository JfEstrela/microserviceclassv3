package com.jf.estrela.microserviceclass.microserviceclass.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jf.estrela.microserviceclass.microserviceclass.entity.Aluno;

@Service
public class AlunoService {
	
	private static Map<Integer,Aluno> alunos = new HashMap<>();
	
	static {
		alunos.put(1,new Aluno(1L, "Estrela", 1, "email@gmail"));
		alunos.put(2,new Aluno(2L, "Juliano", 2, "email@gmail"));
		alunos.put(3,new Aluno(3L, "Matheus", 3, "email@gmail"));
		alunos.put(4,new Aluno(4L, "Gente boa", 4, "email@gmail"));
		alunos.put(5,new Aluno(5L, "Ramiro", 5, "email@gmail"));
		alunos.put(6,new Aluno(6L, "Namor", 6, "email@gmail"));
	}
	
	public Aluno getById(Long id) {
		return alunos.get(id.intValue());
	}
	public Aluno delete(Long id) {
		return alunos.remove(id.intValue());
	}
	
	public List<Aluno> findAll(){
		return new ArrayList<Aluno>(alunos.values());
	}
	
	public Aluno upadate(Aluno aluno){
		 alunos.put(aluno.getId().intValue(), aluno);
		 return alunos.get(aluno.getId().intValue());
	}

}
