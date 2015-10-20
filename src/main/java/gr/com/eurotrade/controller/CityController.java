package gr.com.eurotrade.controller;

import gr.com.eurotrade.entity.City;
import gr.com.eurotrade.service.CityService;
import gr.com.eurotrade.service.CountryService;
import gr.com.eurotrade.service.RegionService;
import gr.com.eurotrade.service.StateService;

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
public class CityController {
	private static final Logger logger = Logger
			.getLogger(CityController.class);
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private StateService stateService;

	@Autowired
	private RegionService regionService;

	@Autowired
	private CountryService countryService;

	// this creates the form
	@ModelAttribute
	public City constructCity() {
		return new City();		
	}
	
	// List Cities
	@RequestMapping("/cityListing")
	public String cityList(Model model) {
		
		model.addAttribute("countryList",countryService.findAll());
		model.addAttribute("regionList",regionService.findAll());
		model.addAttribute("stateList",stateService.findAll());

		model.addAttribute("cityListOfMap",
				cityService.cityListOfMap(null,null,null));
		//model.addAttribute("cityList", cityService.findAll());
		logger.debug("GET : /cityListing");
		return "cityListing";
	}
	
	// Search City
	@RequestMapping(value="/city/search", method = RequestMethod.POST)
	public String searchCity(Model model,
							@RequestParam("stateId") Integer stateId,
							@RequestParam("regionId") Integer regionId,
							@RequestParam("countryId") Integer countryId) {

		// data for lists inside jsp
		model.addAttribute("selectedStateId",stateId);
		model.addAttribute("stateList",stateService.findAll());
		
		model.addAttribute("selectedRegionId",regionId);
		model.addAttribute("regionList",regionService.findAll());
		
		model.addAttribute("selectedCountryId",countryId);
		model.addAttribute("countryList",countryService.findAll());
		
		logger.debug("POST : /city/search");
		model.addAttribute("cityListOfMap",cityService.cityListOfMap(stateId,regionId,countryId));
		return "cityListing";
	}

	/**
	 * This method add a new city and force dispatcher to redirect to cityListing.html
	 */
	@RequestMapping(value="/city/add", method = RequestMethod.POST)
	public String doAddCity(Model model, 
			@Valid @ModelAttribute("city") City city, BindingResult result,
			@RequestParam("id") Integer cityId,
			@RequestParam("stateId") Integer stateId,
			@RequestParam("regionId") Integer regionId,
			@RequestParam("countryId") Integer countryId) {
		
		// data for lists inside jsp
		//model.addAttribute("selectedCityAddId",cityId);

		// data for lists inside jsp
		model.addAttribute("selectedStateAddId",stateId);
		model.addAttribute("stateList",stateService.findAll());
		
		model.addAttribute("selectedRegionAddId",regionId);
		model.addAttribute("regionList",regionService.findAll());
		
		model.addAttribute("selectedCountryAddId",countryId);
		model.addAttribute("countryList",countryService.findAll());
		
		// Apothikeyo meso modal
		logger.debug("POST : /city/add");
		// put data selected from lists to object
		city.setState(stateService.findById(stateId));
		if(result.hasErrors()) {
			return cityList(model);
		}
		cityService.save(city);
		return "redirect:/cityListing.html";

		
	}	
	
	
	// City Edit begins
	@RequestMapping(value="/city/{cityId}/edit")
	public String editCity(Model model, @PathVariable int cityId){
		City city = cityService.findById(cityId);

		model.addAttribute("city", city);
		
		//fill lists in jsp
		model.addAttribute("stateList",stateService.findAll());
		model.addAttribute("regionList",regionService.findAll());
		model.addAttribute("countryList",countryService.findAll());
		
		//set selected in lists
		Integer selectedStateId;
		Integer selectedRegionId;
		Integer selectedCountryId;
		
		if (city.getState() == null) {
			selectedStateId = 0;
			selectedRegionId = 0;
			selectedCountryId = 0;
		}
		else 
		{
			selectedStateId = city.getState().getId();

			if (city.getState().getRegion() == null) {
				selectedRegionId = 0;
				selectedCountryId = 0;
			}
			else 
			{
				selectedRegionId = city.getState().getRegion().getId();
				if (city.getState().getRegion().getCountry() == null) {
					selectedCountryId = 0;
				}
				else 
				{
					selectedCountryId = city.getState().getRegion().getCountry().getId();
				}
			}

		}
		model.addAttribute("selectedStateUpdId",selectedStateId);
		model.addAttribute("selectedRegionUpdId",selectedRegionId);	
		model.addAttribute("selectedCountryUpdId",selectedCountryId);
		
		return "cityEdit";
	}	

	
	@RequestMapping(value="/city/{cityId}/edit",method=RequestMethod.POST)
	public String doUpdateCity(Model model, 
			@ModelAttribute("city") City city, BindingResult result,
			@RequestParam("stateId") Integer stateId, Principal principal){
		
		logger.debug("Update city [id:"+city.getId()+" , name:"+city.getName()+" , code:"+"]");
		
		String username = principal.getName();
		model.addAttribute("stateList",stateService.findAll());
		
		city.setState(stateService.findById(stateId));
		if(result.hasErrors()) {
			return cityList(model);
		}
		cityService.save(city , username);
		return "redirect:/cityListing.html";
	}	
	// City Edit ends
	
	@RequestMapping("/city/remove/{id}")
	public String removeCity(@PathVariable int id) {
		City city = cityService.findById(id);
		cityService.delete(city);
		return "redirect:/cityListing.html";
	}



}
