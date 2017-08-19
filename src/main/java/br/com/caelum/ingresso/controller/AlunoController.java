package br.com.caelum.ingresso.controller;

import br.com.caelum.ingresso.dao.AlunoDao;
import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.model.Aluno;
import br.com.caelum.ingresso.model.Filme;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping({ "/admin/aluno", "/admin/aluno/{id}" })
	public ModelAndView form(@PathVariable("id") Optional<Integer> id, Aluno aluno) {

		ModelAndView modelAndView = new ModelAndView("aluno/aluno");

		if (id.isPresent()) {
			aluno = alunoDao.findOne(id.get());
		}

		modelAndView.addObject("aluno", aluno);

		return modelAndView;
	}
	
	@PostMapping("/admin/aluno")
	@Transactional
	public ModelAndView salva(@Valid Aluno aluno, BindingResult result) {

		if (result.hasErrors()) {
			return form(Optional.ofNullable(aluno.getId()), aluno);
		}

		alunoDao.save(aluno);

		ModelAndView view = new ModelAndView("redirect:/admin/alunos");

		return view;
	}

}
