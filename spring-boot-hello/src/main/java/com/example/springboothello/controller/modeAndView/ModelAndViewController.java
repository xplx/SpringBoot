package com.example.springboothello.controller.modeAndView;


import com.example.springboothello.entity.User;
import com.example.springboothello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/model")
public class ModelAndViewController {
	
	@Autowired
	UserService userService;
	/**
	 * 一个beetl模板测试。因为视图扩展名字是btl
	 * @param userId
	 * @param model
	 * @return
	 */
	@GetMapping(path = "/{userId}/get.html")
	public String getUser(@PathVariable Long userId,Model model) {
		 User userInfo =  userService.getUserById(userId);
		 //model.addAttribute(userInfo); 与下面一行作用一样，但这会有潜在问题
		 model.addAttribute("user", userInfo);
		 return "/userInfo.btl";
	}
	/**
	 * 使用freemaker模板测试，freemaker会寻找/userInfo.ftl 模板。
	 * ModelAndView 对象类似 Mode l ，但额外提供了 一个视图名称
	 * @param userId
	 * @param view
	 * @return
	 */
	@GetMapping(path = "/{userId}/view.html")
	public ModelAndView getUser2(@PathVariable Long userId,ModelAndView view) {
		//ModelAndView 对象既可以通过方法声明 ，也可以在方法中构造，上面的例子也可以写成
		//ModelAndView modelAndView = new ModelAndView();
		User userInfo =  userService.getUserById(userId);
		 //model.addAttribute(userInfo);
		 view.addObject("user", userInfo);
		 view.setViewName("/userInfo");//模型中添加视图地址。
		 return view;
	}
	
	
}
