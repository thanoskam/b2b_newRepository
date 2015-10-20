package gr.com.eurotrade.controller;

import gr.com.eurotrade.entity.City;
import gr.com.eurotrade.entity.Company;
import gr.com.eurotrade.entity.CompanyAddress;
import gr.com.eurotrade.service.CompanyAddressService;
import gr.com.eurotrade.service.CompanyService;
import gr.com.eurotrade.service.CountryService;

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
public class CompanyController {
	private static final Logger logger = Logger
			.getLogger(CompanyController.class);
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private CompanyAddressService companyAddressService;
	
	private CompanyAddress companyAddress;

	// this creates the form
	@ModelAttribute
	public CompanyAddress constructCompanyAddress() {
		return new CompanyAddress();		
	}
	
	// this creates the form
	@ModelAttribute
	public Company constructCompany() {
		return new Company();		
	}
	
	// Company Listing
	@RequestMapping("/companyListing")
	public String companyList(Model model) {
		
		model.addAttribute("countryList",countryService.findAll());
		//	model.addAttribute("companyList", companyService.findAll());

		model.addAttribute("companyListOfMap",
				companyService.companyListOfMap(null));
		return "companyListing";
	}
	
 	// Company info read
	@RequestMapping("/company/{id}/info")
	public String info(Model model, @PathVariable int id){
		model.addAttribute("company", companyService.findOneWithAddressListAndUserList(id));
		return "companyInfoRead";
	}

	/**
	 * This method add a new city and force dispatcher to redirect to cityListing.html
	 */
	@RequestMapping(value="/company/addAddress", method = RequestMethod.POST)
	public String doAddAddress(Model model, 
			@Valid @ModelAttribute("companyAddress") CompanyAddress companyAddress, BindingResult result) {
		
		// Apothikeyo meso modal
		logger.debug("POST : /company/addAddress");
		if(result.hasErrors()) {
			return companyList(model);
		}
		companyAddressService.save(companyAddress);
		return "redirect:/cityListing.html";

		
	}	
	

	
	// Search company
	@RequestMapping(value="/company/search", method=RequestMethod.POST)
	public String searchCompany(Model model, 
			@RequestParam("countryId") Integer countryId) {
		
		// data for lists inside jsp
		model.addAttribute("selectedCountryId",countryId);
		model.addAttribute("countryList",countryService.findAll());

		logger.debug("POST : /reagion/search");
		model.addAttribute("companyListOfMap",
				companyService.companyListOfMap(countryId));
		return "companyListing";
	}

	// new company
	@RequestMapping(value="/company/add", method=RequestMethod.POST)
	public String doAddCompany(Model model, 
							@Valid @ModelAttribute("company") Company company, BindingResult result,
							@RequestParam("countryId") Integer countryId) {
		
		// data for lists inside jsp
		model.addAttribute("selectedCountryAddId",countryId);
		model.addAttribute("countryList",countryService.findAll());
		
		// put data selected from lists to object
		company.setCountry(countryService.findOne(countryId));
		if(result.hasErrors()) {
			return companyList(model);
		}
		companyService.save(company);
		
		return "redirect:/companyListing.html";
	}

	// Company Edit begins
	@RequestMapping(value="/company/{companyId}/edit")
	public String editCompany(Model model, @PathVariable int companyId){
		Company company = companyService.findById(companyId);

		model.addAttribute("company", company);
		
		//fill lists in jsp
		model.addAttribute("countryList",countryService.findAll());
		
		//set selected in lists
		Integer selectedCountryId;
		if (company.getCountry() == null) {
			selectedCountryId = 0;
			logger.debug("selectedCountryId indide if = [" + selectedCountryId + "]");
		}else 
		{
			selectedCountryId = company.getCountry().getId();
			logger.debug("selectedCountryId indide else = [" + selectedCountryId + "]");
		}
		model.addAttribute("selectedCountryId",selectedCountryId);

		return "companyEdit";
	}	

	
	@RequestMapping(value="/company/{companyId}/edit",method=RequestMethod.POST)
	public String doUpdateCompany(Model model, 
			@ModelAttribute("company") Company company, BindingResult result,
			@RequestParam("countryId") Integer countryId, Principal principal){
		
		logger.debug("Update company [id:"+company.getId()+" , name:"+company.getName()+" , code:"+"]");
		
		String username = principal.getName();
		model.addAttribute("countryList",countryService.findAll());
		
		company.setCountry(countryService.findOne(countryId));
		if(result.hasErrors()) {
			return companyList(model);
		}
		companyService.save(company , username);
		return "redirect:/companyListing.html";
	}	
	// Company Edit ends
	
	@RequestMapping("/company/remove/{id}")
	public String removeCompany(@PathVariable int id) {
		Company company = companyService.findById(id);
		companyService.delete(company);
		return "redirect:/companyListing.html";
	}



}
