package com.bassissa.edmfipag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bassissa.edmfipag.model.FuncionarioDAO;
import com.bassissa.edmfipag.model.FuncionarioVO;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioAction {

	@Autowired
	FuncionarioDAO funcionarioDao;

	@GetMapping("/listar")
	public ModelAndView listar() {

		ModelAndView modelAndView = new ModelAndView("ListaFuncionarios");

		modelAndView.addObject("funcionarios", funcionarioDao.findAll());
		modelAndView.addObject("funcionario", new FuncionarioVO());

		return modelAndView;
	}
	
	@PostMapping("/save")
	public String salvar(FuncionarioVO funcionario) {
		
		funcionarioDao.save(funcionario);
		
		return  "redirect:/funcionario/listar";

	}

}
