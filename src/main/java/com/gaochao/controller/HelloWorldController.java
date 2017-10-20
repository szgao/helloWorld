package com.gaochao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/helloworld")
public class HelloWorldController {

	@RequestMapping(value="/success",method=RequestMethod.POST)
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "HelloSpringMvc");
		mv.setViewName("success");
		return mv;
	}
	
	@RequestMapping(value="/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") Integer id){
		System.out.println("id:"+id);
		return "success";
	}
}
