package br.com.caelum.ingresso.controller;

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

import br.com.caelum.ingresso.dao.QuadraDao;
import br.com.caelum.ingresso.model.Quadra;

@Controller
public class QuadraController {

	@Autowired
	private QuadraDao quadraDao;

	@GetMapping(value = "/admin/quadras")
	public ModelAndView lista() {

		ModelAndView modelAndView = new ModelAndView("quadra/lista");

		modelAndView.addObject("quadras", quadraDao.findAll());

		return modelAndView;
	}

	@GetMapping({ "/admin/quadra", "/admin/quadra/{id}" })
	public ModelAndView form(@PathVariable("id") Optional<Integer> id, Quadra quadra) {

		ModelAndView modelAndView = new ModelAndView("quadra/quadra");

		if (id.isPresent()) {
			quadra = quadraDao.findOne(id.get());
		}

		modelAndView.addObject("quadra", quadra);

		return modelAndView;
	}

	@PostMapping("/admin/quadra")
	@Transactional
	public ModelAndView salva(@Valid Quadra quadra, BindingResult result) {

		if (result.hasErrors()) {
			return form(Optional.ofNullable(quadra.getId()), quadra);
		}

		quadraDao.save(quadra);

		ModelAndView view = new ModelAndView("redirect:/admin/quadras");

		return view;
	}

}
