package gr.com.eurotrade.service;

import gr.com.eurotrade.entity.City;
import gr.com.eurotrade.repository.CityRepository;
import gr.com.eurotrade.repository.CountryRepository;
import gr.com.eurotrade.repository.RegionRepository;
import gr.com.eurotrade.repository.StateRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
	
	@Autowired
	CityRepository cityRepository;

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	StateRepository stateRepository;

	@Autowired
	RegionRepository regionRepository;

	public List<City> findAll() {
		return cityRepository.findAll();
	}

	public void save(City city) {
		cityRepository.save(city);
		
	}

	public City findById(Integer cityId) {
		return cityRepository.findById(cityId);
	}

	public void delete(City city) {
		cityRepository.delete(city);
	}
	
	public void save(City city, String username) {
		cityRepository.save(city);
		
	}

	public List<City> findByCountryId(Integer countryId) {
		List<City> cityList = null;
		cityList = cityRepository.customFindByCountryId(countryId);
		return cityList;	
	}
	
	public List<City> findByRegionId(Integer regionId) {
		List<City> cityList = null;
		cityList = cityRepository.customFindByRegionId(regionId);
		return cityList;	
	}
	
	public List<City> findByStateId(Integer stateId) {
		List<City> cityList = null;
		cityList = cityRepository.customFindByStateId(stateId);
		return cityList;	
	}
	
	public List<City> findByCountryIdAndRegionId(Integer countryId, Integer regionId) {
		List<City> cityList = null;
		cityList = cityRepository.customFindByCountryIdAndRegionId(countryId, regionId);
		return cityList;	
	}
	
	public List<City> findByCountryIdAndStateId(Integer countryId, Integer stateId) {
		List<City> cityList = null;
		cityList = cityRepository.customFindByCountryIdAndStateId(countryId, stateId);
		return cityList;	
	}
	
	public List<City> findByRegionIdAndStateId(Integer regionId, Integer stateId) {
		List<City> cityList = null;
		cityList = cityRepository.customFindByRegionIdAndStateId(regionId, stateId);
		return cityList;	
	}
	
	public List<City> findByCountryIdAndRegionIdAndStateId(Integer countryId, Integer regionId, Integer stateId) {
		List<City> cityList = null;
		cityList = cityRepository.customFindByCountryIdAndRegionIdAndStateId(countryId, regionId, stateId);
		return cityList;	
	}
	
	//======================================================================
	
	public List<City> getCityList(Integer stateId, Integer regionId, Integer countryId){
		List<City> cityList = null;

		if(countryId == null && regionId == null && stateId == null){
			
			System.out.println("getCityList : mpika se ola");
			cityList = cityRepository.findAll();			
		}
		else
		{
/*			System.out.println("state findOne");
			State state = stateRepository.findOne(stateId);
			System.out.println("region findOne");
			Region region = regionRepository.findOne(regionId);
			System.out.println("country findOne");
			Country country = countryRepository.findOne(countryId);
*/
			if (countryId != null && regionId == null && stateId == null)
			{
				System.out.println("country findOne");
				//Country country = countryRepository.findOne(countryId);
				System.out.println("mpika sto country");
				cityList = findByCountryId(countryId);						
			}
			else if (countryId == null && regionId != null && stateId == null)
			{
				System.out.println("region findOne");
				//Region region = regionRepository.findOne(regionId);
				System.out.println("mpika sto region");
				cityList = findByRegionId(regionId);						
			}
			else if (countryId == null && regionId == null && stateId != null)
			{
				System.out.println("state findOne");
				//State state = stateRepository.findOne(stateId);
				System.out.println("mpika sto state");
				cityList = findByStateId(stateId);						
			}
			else if (countryId != null && regionId != null && stateId == null)
			{
				System.out.println("mpika sto country kai region");
				cityList = findByCountryIdAndRegionId(countryId, regionId);						
			}
			else if (countryId != null && regionId == null && stateId != null)
			{
				System.out.println("mpika sto country kai state");
				cityList = findByCountryIdAndStateId(countryId, stateId);						
			}
			else if (countryId == null && regionId != null && stateId != null)
			{
				System.out.println("mpika sto region kai state");
				cityList = findByRegionIdAndStateId(regionId, stateId);						
			}
			else if (countryId != null && regionId != null && stateId != null)
			{
				System.out.println("mpika sto country, region kai state");
				cityList = findByCountryIdAndRegionIdAndStateId(countryId, regionId, stateId);						
			}
			
		}
		System.out.println("teleiose i getCityList");			

		return cityList;
	}

	public List<HashMap<String,String>> cityListOfMap(Integer stateId, Integer regionId, Integer countryId) {
		System.out.println("cityListOfMap : creating single list ...");
		System.out.println("stateId = : " + stateId);
		System.out.println("regionId = : " + regionId);
		System.out.println("countryId = : " + countryId);

		List<City> cityList = getCityList(stateId, regionId, countryId);

		List<HashMap<String,String>> cityListOfMap = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> map;
		
		for(City city : cityList){	 	
			System.out.println("simpleListOfMap [ city id : " + city.getId() + " , city name : " + city.getName() + " ]");
			
			map = new HashMap<String,String>();

			map.put("id",city.getId().toString());
			map.put("name",city.getName());
			map.put("state",city.getState().getName());
			map.put("stateId",city.getState().getId().toString());
			map.put("region",city.getState().getRegion().getName());
			map.put("regionId",city.getState().getRegion().getId().toString());
			map.put("country", city.getState().getRegion().getCountry().getName());
			map.put("countryId",city.getState().getRegion().getCountry().getId().toString());

			
			cityListOfMap.add(map);
		}
	
/*		// Debugging..Starts
		
		for(HashMap<String,String> city : simpleListOfMap){

			Iterator it = city.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        it.remove(); // avoids a ConcurrentModificationException
		    }
			
		}
		
		// Debuggin Ends
*/
		return cityListOfMap;

	}

 	public City findOne(int id) {
		// TODO Auto-generated method stub
		return cityRepository.findOne(id);
	}

	
}
