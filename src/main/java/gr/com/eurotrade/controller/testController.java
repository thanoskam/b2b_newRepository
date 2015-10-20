package gr.com.eurotrade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

	@RequestMapping("/test")
	public String countryList(Model model) {
//		model.addAttribute("countryList", countryService.findAll());
		return "test";
	}

}
