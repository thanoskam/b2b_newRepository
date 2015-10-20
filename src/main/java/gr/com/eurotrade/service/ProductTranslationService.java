package gr.com.eurotrade.service;

import gr.com.eurotrade.entity.Country;
import gr.com.eurotrade.entity.Product;
import gr.com.eurotrade.entity.ProductTranslation;
import gr.com.eurotrade.repository.CountryRepository;
import gr.com.eurotrade.repository.ProductRepository;
import gr.com.eurotrade.repository.ProductTranslationRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTranslationService {

	@Autowired
	private ProductTranslationRepository productTranslationtRepository;
	
	@Autowired
	private ProductRepository producRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	
	public List<ProductTranslation> findAll() {
		return productTranslationtRepository.findAll();
	}


	public ProductTranslation findOne(int id) {
		// TODO Auto-generated method stub
		return productTranslationtRepository.findOne(id);
	}

	
	public String translateProduct(Product product, Country country ) {
		// TODO Auto-generated method stub
		ProductTranslation productTranslation = productTranslationtRepository.findByProductAndCountry(product,country);
		
		String result = "";
		
		
		if(productTranslation!=null){
			result = productTranslation.getDescr();
		}
		
		return result;
	}
	
	
	public List<ProductTranslation> findByProductCode(String code){
		Product product = producRepository.findByCode(code);
		return productTranslationtRepository.findByProduct(product);
		
	}
		
	public List<ProductTranslation> findByCountryName(String name){
		Country country = countryRepository.findByName(name);
		return productTranslationtRepository.findByCountry(country);
		
			
	}
	


}
