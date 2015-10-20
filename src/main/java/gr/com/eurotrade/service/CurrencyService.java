package gr.com.eurotrade.service;

import gr.com.eurotrade.entity.Currency;
import gr.com.eurotrade.repository.CurrencyRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
	
	@Autowired
	private CurrencyRepository currenyRepository;
	
	
	public Currency findByName(String name){
		return currenyRepository.findByName(name);
	}


	public List<Currency> findAll() {
		return currenyRepository.findAll();
	}


	public void save(Currency currency) {
		currenyRepository.save(currency);
	}


	public Currency findOne(int id) {
		return currenyRepository.findOne(id);
	}


	public void delete(Currency currency) {
		currenyRepository.delete(currency);
	}


	public Currency findbyId(Integer currencyId) {
		return currenyRepository.findById(currencyId);
	}
	
	public void save(Currency currency, String username) {
		currenyRepository.save(currency);
	}


	
}
