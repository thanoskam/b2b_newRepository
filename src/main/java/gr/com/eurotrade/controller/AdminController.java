package gr.com.eurotrade.controller;

import gr.com.eurotrade.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/users")
public class AdminController {

	@Autowired
	private UserService userService;

	@RequestMapping
	public String users(Model model){
		model.addAttribute("users", userService.findAll());
		return "users";
	}
	
	@RequestMapping("/{id}")
	public String detail(Model model, @PathVariable int id) {
		model.addAttribute("user", userService.findOneWithblogList(id));
		return "user-detail";
	}
	
	@RequestMapping("/remove/{id}")
	public String removeUser(@PathVariable int id) {
//		System.out.println(">>>>>>>>>>> AdminController /remove/{id} : id = " + id + " <<<<<<<<<<<<< (before)");
		userService.delete(id);
//		System.out.println(">>>>>>>>>>> AdminController /remove/{id} : id = " + id + " <<<<<<<<<<<<< (after)");
		return "redirect:/users.html";
	}


}
