package gr.com.eurotrade.controller;

import gr.com.eurotrade.entity.Country;
import gr.com.eurotrade.service.BranchService;
import gr.com.eurotrade.service.CountryService;
import gr.com.eurotrade.service.CurrencyService;

import java.security.Principal;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountryController {
	private static final Logger logger = Logger
			.getLogger(CountryController.class);
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private CurrencyService currencyService;

	// this creates the form
	@ModelAttribute
	public Country constructCountry() {
		return new Country();		
	}
	
	// list page
	@RequestMapping("/countryListing")
	public String countryList(Model model) {
		model.addAttribute("countryList", countryService.findAll());
		
		model.addAttribute("currencyList",currencyService.findAll());
		model.addAttribute("branchList",branchService.findAll());

		return "countryListing";
	}
	// new country
	@RequestMapping(value="/countryListing", method=RequestMethod.POST)
	public String doAddCountry(Model model, 
			@Valid @ModelAttribute("country") Country country, BindingResult result,
			@RequestParam("branchId") Integer branchId, 
			@RequestParam("currencyId") Integer currencyId) {
		
		// data for lists inside jsp
		model.addAttribute("currencyList",currencyService.findAll());
		model.addAttribute("branchList",branchService.findAll());
		
		// put data selected from lists to object
		country.setBranch(branchService.findById(branchId));
		country.setCurrency(currencyService.findbyId(currencyId));
		if(result.hasErrors()) {
			return countryList(model);
		}
		countryService.save(country);
		return "redirect:/countryListing.html";
	}

	// Country Edit begins
	@RequestMapping(value="/country/{countryId}/edit")
	public String editCountry(Model model, @PathVariable int countryId){
		Country country = countryService.findOne(countryId);

		model.addAttribute("country", country);

		//fill lists in jsp
		model.addAttribute("currencyList",currencyService.findAll());
		model.addAttribute("branchList",branchService.findAll());
		
		//set selected in lists
		Integer selectedCurrencyId;
		if (country.getCurrency() == null) {
			selectedCurrencyId = 0;
			logger.debug("selectedCurrencyId indide if = [" + selectedCurrencyId + "]");
		}else 
		{
			selectedCurrencyId = country.getCurrency().getId();
			logger.debug("selectedCurrencyId indide else = [" + selectedCurrencyId + "]");
		}

		Integer selectedBranchId;
		if (country.getBranch() == null) {
			selectedBranchId = 0;
		}else 
		{
			selectedBranchId = country.getBranch().getId();
		}
		model.addAttribute("selectedCurrencyId",selectedCurrencyId);
		model.addAttribute("selectedBranchId",selectedBranchId);

		return "countryEdit";
	}	

	
	@RequestMapping(value="/country/{countryId}/edit",method=RequestMethod.POST)
	public String doUpdateCountry(Model model, 
			@Valid @ModelAttribute("country") Country country, BindingResult result,
			@RequestParam("branchId") Integer branchId, 
			@RequestParam("currencyId") Integer currencyId, Principal principal){
		
		logger.debug("Update country [id:"+country.getId()+" , name:"+country.getName()+" , code:"+country.getCode()+"]");
		
		String username = principal.getName();
		model.addAttribute("currencyList",currencyService.findAll());
		model.addAttribute("branchList",branchService.findAll());
		
		country.setBranch(branchService.findById(branchId));
		country.setCurrency(currencyService.findbyId(currencyId));
		if(result.hasErrors()) {
			return countryList(model);
		}
		countryService.save(country , username);
		return "redirect:/countryListing.html";
	}	
	// Country Edit ends
	
	@RequestMapping("/country/remove/{id}")
	public String removeCountry(@PathVariable int id) {
		Country country = countryService.findOne(id);
		countryService.delete(country);
		return "redirect:/countryListing.html";
	}



}
