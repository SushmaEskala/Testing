package com.spring.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.spring.dao.UserDAO;
import com.spring.domain.User;



@Controller
public class UserController {
    
    @Autowired
	private UserDAO userdao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
	@ModelAttribute("user")
	public User backingObject() {
		return new User();
	}
	
	@RequestMapping("/home")
	public String login(@Valid @ModelAttribute("user") User user,BindingResult bindingResult,Model m) {
		Boolean result = userdao.login(user);
		
		//ModelAndView model = null;
		/*if(result) {
			System.out.println("in if");
			model = new ModelAndView("home");
		}
		else {
			System.out.println("in else");
			model = new ModelAndView("index");
			m.addAttribute("message", "Email or Password may be incorrect");
		}
		return model;*/
		
		if(bindingResult.hasErrors()) {
			m.addAttribute("message", "Email or password may be incorrect");
			return "index";
		}
		else {
			return "home";
		}
		
	}
	

	
}

