package gr.com.eurotrade.controller;

import gr.com.eurotrade.entity.Region;
import gr.com.eurotrade.service.CountryService;
import gr.com.eurotrade.service.RegionService;

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
public class RegionController {
	private static final Logger logger = Logger
			.getLogger(RegionController.class);
	
	@Autowired
	private RegionService regionService;
	
	@Autowired
	private CountryService countryService;

	// this creates the form
	@ModelAttribute
	public Region constructRegion() {
		return new Region();		
	}
	
	// list page
	@RequestMapping("/regionListing")
	public String regionList(Model model) {
		
		model.addAttribute("countryList",countryService.findAll());
//		model.addAttribute("regionList", regionService.findAll());

		model.addAttribute("regionListOfMap",
				regionService.regionListOfMap(null));
		return "regionListing";
	}
	// Search region
	@RequestMapping(value="/region/search", method=RequestMethod.POST)
	public String searchRegion(Model model, 
			@RequestParam("countryId") Integer countryId) {
		
		// data for lists inside jsp
		model.addAttribute("selectedCountryId",countryId);
		model.addAttribute("countryList",countryService.findAll());

		logger.debug("POST : /reagion/search");
		model.addAttribute("regionListOfMap",
				regionService.regionListOfMap(countryId));
		return "regionListing";
	}

	// new region
	@RequestMapping(value="/region/add", method=RequestMethod.POST)
	public String doAddRegion(Model model, 
							@Valid @ModelAttribute("region") Region region, BindingResult result,
							@RequestParam("countryId") Integer countryId) {
		
		// data for lists inside jsp
		model.addAttribute("selectedCountryAddId",countryId);
		model.addAttribute("countryList",countryService.findAll());
		
		// put data selected from lists to object
		region.setCountry(countryService.findOne(countryId));
		if(result.hasErrors()) {
			return regionList(model);
		}
		regionService.save(region);
		
		return "redirect:/regionListing.html";
	}

	// Region Edit begins
	@RequestMapping(value="/region/{regionId}/edit")
	public String editRegion(Model model, @PathVariable int regionId){
		Region region = regionService.findById(regionId);

		model.addAttribute("region", region);
		
		//fill lists in jsp
		model.addAttribute("countryList",countryService.findAll());
		
		//set selected in lists
		Integer selectedCountryId;
		if (region.getCountry() == null) {
			selectedCountryId = 0;
			logger.debug("selectedCountryId indide if = [" + selectedCountryId + "]");
		}else 
		{
			selectedCountryId = region.getCountry().getId();
			logger.debug("selectedCountryId indide else = [" + selectedCountryId + "]");
		}
		model.addAttribute("selectedCountryId",selectedCountryId);

		return "regionEdit";
	}	

	
	@RequestMapping(value="/region/{regionId}/edit",method=RequestMethod.POST)
	public String doUpdateRegion(Model model, 
			@ModelAttribute("region") Region region, BindingResult result,
			@RequestParam("countryId") Integer countryId, Principal principal){
		
		logger.debug("Update region [id:"+region.getId()+" , name:"+region.getName()+" , code:"+"]");
		
		String username = principal.getName();
		model.addAttribute("countryList",countryService.findAll());
		
		region.setCountry(countryService.findOne(countryId));
		if(result.hasErrors()) {
			return regionList(model);
		}
		regionService.save(region , username);
		return "redirect:/regionListing.html";
	}	
	// Region Edit ends
	
	@RequestMapping("/region/remove/{id}")
	public String removeRegion(@PathVariable int id) {
		Region region = regionService.findById(id);
		regionService.delete(region);
		return "redirect:/regionListing.html";
	}



}
