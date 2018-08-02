package com.example.springboothello.controller.modeAndView;

import com.example.springboothello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/modelattribute")
public class ModelAttributeController {
	@Autowired
	UserService userService;
	/**
	 * Controller方法中的公共方法，调用方法前先调用此方法。
	 * @param id
	 * @param model 向 Model 添加视图需要的变量，
	 */
	@ModelAttribute
	public void findUserById(@PathVariable Long id,Model  model) {
		model.addAttribute("user", userService.getUserById(id));
	}
	
	@GetMapping(path = "/{id}/get.json")
	@ResponseBody
	public String getUser(Model model) {
		System.out.println(model.containsAttribute("user"));
		return "success";
	}
	
	
	
	
	
}
