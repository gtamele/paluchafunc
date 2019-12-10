package com.bassissa.edmfipag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bassissa.edmfipag.model.FuncionarioDAO;
import com.bassissa.edmfipag.model.FuncionarioVO;

@Controller
@RequestMapping("/pesquisafuncionario")
public class PesquisaFuncionarioAction {

	@Autowired
	FuncionarioDAO funcionarioDao;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	//@RequestMapping("/")
	public ModelAndView step0() {

		ModelAndView modelAndView = new ModelAndView("PesquisaFuncionarios");

		FuncionarioVO funcionario = new FuncionarioVO();

		modelAndView.addObject(funcionario);

		return modelAndView;
	}

	// @RequestParam("selfId") long id   //"/delete/{id}"

	//@GetMapping("/getById/{id}")
	
	
	@RequestMapping(value="/getById/{id}",  method= { RequestMethod.POST, RequestMethod.GET})
	public ModelAndView listar(@RequestParam("id") Long id) {

		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

		ModelAndView modelAndView = new ModelAndView("ListaFuncionarios");

		modelAndView.addObject("funcionarios", funcionarioDao.findById(id));

		return modelAndView;
	}

}
