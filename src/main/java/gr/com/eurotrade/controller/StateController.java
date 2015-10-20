package gr.com.eurotrade.controller;

import gr.com.eurotrade.entity.State;
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
public class StateController {
	private static final Logger logger = Logger
			.getLogger(StateController.class);
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private RegionService regionService;

	@Autowired
	private CountryService countryService;

	// this creates the form
	@ModelAttribute
	public State constructState() {
		return new State();		
	}
	
	// list page
	@RequestMapping("/stateListing")
	public String stateList(Model model) {
		
		model.addAttribute("countryList",countryService.findAll());
		model.addAttribute("regionList",regionService.findAll());
//		model.addAttribute("stateList", stateService.findAll());

		model.addAttribute("stateListOfMap",
				stateService.stateListOfMap(null,null));
		return "stateListing";
	}
	// Search state
	@RequestMapping(value="/state/search", method=RequestMethod.POST)
	public String searchState(Model model, 
							@RequestParam("regionId") Integer regionId,
							@RequestParam("countryId") Integer countryId) {
		
		// data for lists inside jsp
		model.addAttribute("selectedRegionId",regionId);
		model.addAttribute("regionList",regionService.findAll());
		
		model.addAttribute("selectedCountryId",countryId);
		model.addAttribute("countryList",countryService.findAll());
		
		logger.debug("POST : /state/search");
		model.addAttribute("stateListOfMap",
				stateService.stateListOfMap(regionId,countryId));
		return "stateListing";
	}

	// new state
	@RequestMapping(value="/state/add", method=RequestMethod.POST)
	public String doAddState(Model model, 
							@Valid @ModelAttribute("state") State state, BindingResult result,
							@RequestParam("regionId") Integer regionId,
							@RequestParam("countryId") Integer countryId) {
		
		// data for lists inside jsp
		model.addAttribute("selectedRegionAddId",regionId);
		model.addAttribute("regionList",regionService.findAll());
		
		model.addAttribute("selectedCountryAddId",countryId);
		model.addAttribute("countryList",countryService.findAll());
		
		// put data selected from lists to object
		state.setRegion(regionService.findById(regionId));
		if(result.hasErrors()) {
			return stateList(model);
		}
		stateService.save(state);
		
		return "redirect:/stateListing.html";
	}

	
	// State Edit begins
	@RequestMapping(value="/state/{stateId}/edit")
	public String editState(Model model, @PathVariable int stateId){
		State state = stateService.findById(stateId);

		model.addAttribute("state", state);
		
		//fill lists in jsp
		model.addAttribute("regionList",regionService.findAll());
		
		//set selected in lists
		Integer selectedRegionId;
		if (state.getRegion() == null) {
			selectedRegionId = 0;
			logger.debug("selectedRegionId indide if = [" + selectedRegionId + "]");
		}else 
		{
			selectedRegionId = state.getRegion().getId();
			logger.debug("selectedRegionId indide else = [" + selectedRegionId + "]");
		}
		model.addAttribute("selectedRegionId",selectedRegionId);

		return "stateEdit";
	}	

	
	@RequestMapping(value="/state/{stateId}/edit",method=RequestMethod.POST)
	public String doUpdateState(Model model, 
			@ModelAttribute("state") State state, BindingResult result,
			@RequestParam("regionId") Integer regionId, Principal principal){
		
		logger.debug("Update state [id:"+state.getId()+" , name:"+state.getName()+" , code:"+"]");
		
		String username = principal.getName();
		model.addAttribute("regionList",regionService.findAll());
		
		state.setRegion(regionService.findById(regionId));
		if(result.hasErrors()) {
			return stateList(model);
		}
		stateService.save(state , username);
		return "redirect:/stateListing.html";
	}	
	// State Edit ends
	
	@RequestMapping("/state/remove/{id}")
	public String removeState(@PathVariable int id) {
		State state = stateService.findById(id);
		stateService.delete(state);
		return "redirect:/stateListing.html";
	}



}
