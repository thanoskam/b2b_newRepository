package gr.com.eurotrade.controller;

import gr.com.eurotrade.service.UserService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String index() {
		/*System.out.println("index controller..");*/
		return "index";
	}


	@RequestMapping(value="/home")
	public String account(Model model , Principal principal){
		String username = principal.getName();
		model.addAttribute("user", userService.findOneWithRoles(username));
		return "home";
	}	

}