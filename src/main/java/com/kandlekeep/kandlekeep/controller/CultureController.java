 package com.kandlekeep.kandlekeep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kandlekeep.kandlekeep.service.CultureService;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/cultures")
public class CultureController {

	@Autowired
	CultureService cultureService;

	@GetMapping
	public ModelAndView index(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/cultures/list");
		mv.addObject("list", cultureService.findAll());
		return mv;
	}

//	@PostMapping("/update")
//	public String update(Model model, @ModelAttribute("colaborador") ColaboradorDTO colaboradorDTO, BindingResult result) {
//		
//		System.out.println("ColaboradorController.update()");
//		System.out.println(colaboradorDTO.toString());
//		
//		colaboradorService.update(colaboradorDTO.toColaborador());
//		
//		return "redirect:/";
//		
//	}
}
