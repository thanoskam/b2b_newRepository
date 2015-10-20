package gr.com.eurotrade.controller;

import gr.com.eurotrade.entity.Currency;
import gr.com.eurotrade.service.CurrencyService;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;
	
	// this creates the form
	@ModelAttribute("currency")
	public Currency constuctCurrency() {
		return new Currency();
		
	}
	
	// list page
	@RequestMapping("/currencyListing")
	public String currencyList(Model model) {
		model.addAttribute("currencyList", currencyService.findAll());
		return "currencyListing";
	}

	// new currency
	@RequestMapping(value="/currencyListing", method=RequestMethod.POST)
	public String doAddCurrency(Model model, 
			@Valid @ModelAttribute("currency") Currency currency, BindingResult result) {
		if(result.hasErrors()) {
			return currencyList(model);
		}
		currencyService.save(currency);
		return "redirect:/currencyListing.html";
	}

	// Currency Edit begins
	@RequestMapping(value="/currency/{currencyId}/edit")
	public String editCurrency(Model model, @PathVariable int currencyId){
		Currency currency = currencyService.findOne(currencyId);

		model.addAttribute("currency", currency);

		return "currencyEdit";
	}	

	
	@RequestMapping(value="/currency/{currencyId}/edit",method=RequestMethod.POST)
	public String doUpdateCurrency(Model model, 
			@Valid @ModelAttribute("currency") Currency currency, BindingResult result, Principal principal){
		
		String username = principal.getName();
		if(result.hasErrors()) {
			return currencyList(model);
		}
		currencyService.save(currency , username);
		return "redirect:/currencyListing.html";
	}	
	// Currency Edit ends

	
	@RequestMapping("/currency/remove/{id}")
	public String removeBlog(@PathVariable int id) {
		Currency currency = currencyService.findOne(id);
		currencyService.delete(currency);
		return "redirect:/currencyListing.html";
	}


	
}
