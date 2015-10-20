package gr.com.eurotrade.service;

import gr.com.eurotrade.entity.Region;
import gr.com.eurotrade.repository.RegionRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {
	
	@Autowired
	RegionRepository regionRepository;

	public List<Region> findAll() {
		return regionRepository.findAll();
	}

	public void save(Region region) {
		regionRepository.save(region);
		
	}

	public Region findById(Integer regionId) {
		return regionRepository.findById(regionId);
	}

	public void delete(Region region) {
		regionRepository.delete(region);
	}
	
	public void save(Region region, String username) {
		regionRepository.save(region);
		
	}
	
	public List<Region> findByCountryId(Integer countryId) {
		List<Region> regionList = null;
		regionList = regionRepository.customFindByCountryId(countryId);
		return regionList;	
	}
	

	
	public List<Region> getRegionList(Integer countryId){
		List<Region> regionList = null;


		if(countryId == null){
			
			System.out.println("getCityList : mpika se ola");
			regionList = regionRepository.findAll();			
		}
		else
		{

			if (countryId != null)
			{
				System.out.println("country findOne");
				//Country country = countryRepository.findOne(countryId);
				System.out.println("mpika sto country");
				regionList = findByCountryId(countryId);						
			}
			
		}
	
		System.out.println("teleiose i getRegionList");			
	
		return regionList;
	}

	public List<HashMap<String,String>> regionListOfMap(Integer countryId) {
		System.out.println("regionListOfMap : creating single list ...");
		System.out.println("countryId = : " + countryId);

		List<Region> regionList = getRegionList(countryId);

		List<HashMap<String,String>> regionListOfMap = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> map;
		
		for(Region region : regionList){	 	
			System.out.println("simpleListOfMap [ region id : " + region.getId() + " , region name : " + region.getName() + " ]");
			
			map = new HashMap<String,String>();

			map.put("id",region.getId().toString());
			map.put("name",region.getName());
			map.put("country", region.getCountry().getName());
			map.put("countryId",region.getCountry().getId().toString());

			
			regionListOfMap.add(map);
		}
	
/*		// Debugging..Starts
		
		for(HashMap<String,String> region : simpleListOfMap){

			Iterator it = region.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        it.remove(); // avoids a ConcurrentModificationException
		    }
			
		}
		
		// Debuggin Ends
*/
		return regionListOfMap;

	}

	
}
