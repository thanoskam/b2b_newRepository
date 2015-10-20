package gr.com.eurotrade.service;

import gr.com.eurotrade.entity.State;
import gr.com.eurotrade.repository.StateRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {
	
	@Autowired
	StateRepository stateRepository;

	public List<State> findAll() {
		return stateRepository.findAll();
	}

	public void save(State state) {
		stateRepository.save(state);
		
	}

	public State findById(Integer stateId) {
		return stateRepository.findById(stateId);
	}

	public void delete(State state) {
		stateRepository.delete(state);
	}
	
	public void save(State state, String username) {
		stateRepository.save(state);
		
	}


	public List<State> findByCountryId(Integer countryId) {
		List<State> stateList = null;
		stateList = stateRepository.customFindByCountryId(countryId);
		return stateList;	
	}
	
	public List<State> findByRegionId(Integer regionId) {
		List<State> stateList = null;
		stateList = stateRepository.customFindByRegionId(regionId);
		return stateList;	
	}
	
	public List<State> findByCountryIdAndRegionId(Integer countryId, Integer regionId) {
		List<State> stateList = null;
		stateList = stateRepository.customFindByCountryIdAndRegionId(countryId, regionId);
		return stateList;	
	}
	

	
	public List<State> getStateList(Integer regionId, Integer countryId){
		List<State> stateList = null;


		if(countryId == null && regionId == null){
			
			System.out.println("getCityList : mpika se ola");
			stateList = stateRepository.findAll();			
		}
		else
		{
/*			System.out.println("state findOne");
			System.out.println("region findOne");
			Region region = regionRepository.findOne(regionId);
			System.out.println("country findOne");
			Country country = countryRepository.findOne(countryId);
*/
			if (countryId != null && regionId == null)
			{
				System.out.println("country findOne");
				//Country country = countryRepository.findOne(countryId);
				System.out.println("mpika sto country");
				stateList = findByCountryId(countryId);						
			}
			else if (countryId == null && regionId != null)
			{
				System.out.println("region findOne");
				//Region region = regionRepository.findOne(regionId);
				System.out.println("mpika sto region");
				stateList = findByRegionId(regionId);						
			}
			else if (countryId != null && regionId != null)
			{
				System.out.println("mpika sto country kai region");
				stateList = findByCountryIdAndRegionId(countryId, regionId);						
			}
			
		}
	
		System.out.println("teleiose i getStateList");			
	
		return stateList;
	}

	public List<HashMap<String,String>> stateListOfMap(Integer regionId, Integer countryId) {
		System.out.println("stateListOfMap : creating single list ...");
		System.out.println("regionId = : " + regionId);
		System.out.println("countryId = : " + countryId);

		List<State> stateList = getStateList(regionId, countryId);

		List<HashMap<String,String>> stateListOfMap = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> map;
		
		for(State state : stateList){	 	
			System.out.println("simpleListOfMap [ state id : " + state.getId() + " , state name : " + state.getName() + " ]");
			
			map = new HashMap<String,String>();

			map.put("id",state.getId().toString());
			map.put("name",state.getName());
			map.put("region",state.getRegion().getName());
			map.put("regionId",state.getRegion().getId().toString());
			map.put("country", state.getRegion().getCountry().getName());
			map.put("countryId",state.getRegion().getCountry().getId().toString());

			
			stateListOfMap.add(map);
		}
	
/*		// Debugging..Starts
		
		for(HashMap<String,String> state : simpleListOfMap){

			Iterator it = state.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        it.remove(); // avoids a ConcurrentModificationException
		    }
			
		}
		
		// Debuggin Ends
*/
		return stateListOfMap;

	}

	
}
