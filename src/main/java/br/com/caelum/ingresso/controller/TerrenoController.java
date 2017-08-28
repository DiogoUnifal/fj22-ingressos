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

import br.com.caelum.ingresso.dao.TerrenoDao;
import br.com.caelum.ingresso.model.Terreno;

@Controller
public class TerrenoController {

	@Autowired
	private TerrenoDao terrenoDao;

	@GetMapping(value = "/admin/terrenos")
	public ModelAndView lista() {

		ModelAndView modelAndView = new ModelAndView("terreno/lista");

		modelAndView.addObject("terrenos", terrenoDao.findAll());

		return modelAndView;
	}

	@GetMapping({ "/admin/terreno", "/admin/terreno/{id}" })
	public ModelAndView form(@PathVariable("id") Optional<Integer> id, Terreno terreno) {

		ModelAndView modelAndView = new ModelAndView("terreno/terreno");

		if (id.isPresent()) {
			terreno = terrenoDao.findOne(id.get());
		}

		modelAndView.addObject("terreno", terreno);

		return modelAndView;
	}

	@PostMapping("/admin/terreno")
	@Transactional
	public ModelAndView salva(@Valid Terreno terreno, BindingResult result) {

		if (result.hasErrors()) {
			return form(Optional.ofNullable(terreno.getId()), terreno);
		}

		terrenoDao.save(terreno);

		ModelAndView view = new ModelAndView("redirect:/admin/terrenos");

		return view;
	}

}
