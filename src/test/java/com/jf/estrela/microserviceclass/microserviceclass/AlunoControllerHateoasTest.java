package com.jf.estrela.microserviceclass.microserviceclass;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.jf.estrela.microserviceclass.microserviceclass.entity.Aluno;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AlunoControllerHateoasTest {

	@Autowired
	private MockMvc mockMvc;
	 
	@Test
	public void testGetAlunoById() throws Exception {
	    this.mockMvc.perform(get("/apihateoas/aluno/1")).andDo(print()).andExpect(status().isOk())
	            .andExpect(content().string(containsString("Estrela")));
	}
	
	@Test
	public void testDeleteAluno() throws Exception {
	    this.mockMvc.perform(delete("/apihateoas/excluir/2")).andDo(print()).andExpect(status().isOk())
	            .andExpect(content().string(not("Juliano")));
	}
	
	@Test
	public void testUpadateAluno() throws Exception {
		Aluno aluno = new Aluno(3L, "Jamal", 3, "email@gmail");
	    this.mockMvc.perform(put("/apihateoas/atualizar", aluno)).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Jamal")));
	}

}
