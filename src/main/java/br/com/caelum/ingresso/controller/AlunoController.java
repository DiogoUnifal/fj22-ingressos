package br.com.caelum.ingresso.controller;

import br.com.caelum.ingresso.dao.AlunoDao;
import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.model.Aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoDao alunoDao;
	
	@GetMapping(value = "/admin/alunos")
	public ModelAndView lista() {

		ModelAndView modelAndView = new ModelAndView("aluno/lista");

		modelAndView.addObject("alunos", alunoDao.findAll());

		return modelAndView;
	}

}
