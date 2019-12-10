package com.bassissa.edmfipag.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bassissa.edmfipag.model.FuncionarioDAO;
import com.bassissa.edmfipag.model.FuncionarioVO;

@Controller
@RequestMapping("/findfuncionario")
public class FindFuncionarioAction {
	

	@Autowired
	FuncionarioDAO funcionarioDao;

	@GetMapping("/pesquisar")
	public ModelAndView listar() {

		ModelAndView modelAndView = new ModelAndView("ListaFuncionarios2");

	//	modelAndView.addObject("funcionarios", funcionarioDao.findAll());
		modelAndView.addObject("funcionario", new FuncionarioVO());

		return modelAndView;
	}
	
	@GetMapping("/find")
	public ModelAndView getFuncionarioById(FuncionarioVO func) {
		
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
		
		ModelAndView modelAndView = new ModelAndView("ListaFuncionarios2");
		
		modelAndView.addObject("funcionario", new FuncionarioVO());
		
		Optional<FuncionarioVO> funcionario = funcionarioDao.findById(func.getId());
		
		
		if(!funcionario.isPresent()) {
			
			
			modelAndView.addObject("statusMsg", "Não existe o Técnico correspondente ao ID inserido");
			
			return  modelAndView;
		}
		
		funcionarios.add(funcionario.get());
		modelAndView.addObject("funcionarios",funcionarios);
		                                      	
		
		return  modelAndView;

	}
	
	
	
	@GetMapping("/findByIdAndEntidade")
	public ModelAndView getFuncionarioByIdAndEntidadeNAme(FuncionarioVO func) {
		
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
		
		ModelAndView modelAndView = new ModelAndView("ListaFuncionarios2");
		
		modelAndView.addObject("funcionario", new FuncionarioVO());
		
		
		/*
		 * ExampleMatcher ignoringExampleMatcher =
		 * ExampleMatcher.matchingAny().withMatcher("nomeEntidade",
		 * ExampleMatcher.GenericPropertyMatchers.startsWith().contains().ignoreCase())
		 * // .withMatcher("nomeEntidade",
		 * ExampleMatcher.GenericPropertyMatchers.startsWith().ignoreCase())
		 * .withIgnorePaths("codigo", "nome", "email", "id");
		 * 
		 * Example<FuncionarioVO> example = Example.of((func),ignoringExampleMatcher);
		 * 
		 * Optional<FuncionarioVO> funcionario = funcionarioDao.findOne(example);
		 */
		
		FuncionarioVO funcionario = funcionarioDao.findFuncioanrioByIdAndEntidade(func.getId(), func.getNomeEntidade());
		
		
		if(funcionario==null || funcionario.getCodigo()==null) {
			
			
			modelAndView.addObject("statusMsg", "Não existe o Técnico correspondente ao ID inserido");
			
			return  modelAndView;
		}
		
		funcionarios.add(funcionario);
		modelAndView.addObject("funcionarios",funcionarios);
		                                      	
		
		return  modelAndView;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
