package com.telusko.springmvcboot.controller;

import org.springframework.beans.factory.parsing.AliasDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.springmvcboot.model.Alien;

@Controller
//@RequestMapping("")
public class HomeController {

	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name","Aliens");
	}
	
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
//	@RequestMapping("add")
//	public String add(HttpServletRequest req) {
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//		int sum = i + j;
//		
//		HttpSession session = req.getSession();
//		session.setAttribute("sum123", sum);
//
//		return "result.jsp";
////		return "result.jsp?sum=" + sum;
//	}
	
	
	@RequestMapping("add")
	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model model) {
		
		int sum = i + j;
		model.addAttribute("sum123",sum); 
	
		return "result";
	}
	
//	@RequestMapping("addAlien")
//	public String requestMethodName(@RequestParam("aid") int aid,@RequestParam("aname") String aname, Model m) {
//		
//		Alien a = new Alien();
//		a.setAid(aid);
//		a.setAname(aname);
//		
//		m.addAttribute("alien", a);
//		
//		return "result";
//	}
//	
	
	@RequestMapping("addAlien")
	public String requestMethodName(@ModelAttribute Alien a) {
		
		
		return "result";
	}
	
	
	
	
	
	
	
	
	
	
}
