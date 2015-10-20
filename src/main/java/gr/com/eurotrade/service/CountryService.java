package gr.com.eurotrade.service;

import java.util.List;

import gr.com.eurotrade.entity.Country;
import gr.com.eurotrade.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	
	public Country findByCode(String code){
		return countryRepository.findByCode(code);
	}


	public List<Country> findAll() {
		return countryRepository.findAll();
	}


	public Country  findOne(Integer id) {
		// TODO Auto-generated method stub
		return countryRepository.findOne(id);
	}


	public void save(Country country) {
		countryRepository.save(country);
		
	}


	public void delete(Country country) {
		countryRepository.delete(country);
		
	}


	public void save(Country country, String username) {
		countryRepository.save(country);
	}


}
