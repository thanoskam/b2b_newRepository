package gr.com.eurotrade.service;

import gr.com.eurotrade.entity.Country;
import gr.com.eurotrade.entity.Product;
import gr.com.eurotrade.entity.ProductPrice;
import gr.com.eurotrade.repository.CountryRepository;
import gr.com.eurotrade.repository.ProductPriceRepository;
import gr.com.eurotrade.repository.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPriceService {

	@Autowired
	private ProductPriceRepository productPriceRepository;
	
	@Autowired
	private ProductRepository producRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	
	public List<ProductPrice> findAll() {
		return productPriceRepository.findAll();
	}


	public ProductPrice findOne(int id) {
		// TODO Auto-generated method stub
		return productPriceRepository.findOne(id);
	}

	public List<ProductPrice> findByProductCode(String code){
		Product product = producRepository.findByCode(code);
		return productPriceRepository.findByProduct(product);
		
	}
		
	public List<ProductPrice> findByCountryName(String name){
		Country country = countryRepository.findByName(name);
		return productPriceRepository.findByCountry(country);
		
			
	}


	public Double findPricePerCountry(Product product, Country country) {
		ProductPrice productPrice = productPriceRepository.findByProductAndCountry(product, country);
		Double result = 0.0;		
		
		if(productPrice!=null){
			result = productPrice.getWlsCost();
		}
		
		return result;

	}


	public Double getWlsSprPrice(String priceKind, Product product, Country country) {
		ProductPrice productPrice = productPriceRepository.findByProductAndCountry(product, country);
		Double result = 0.0;

		if(productPrice!=null){
			if (priceKind == "WLS") {
				result = productPrice.getWlsCost();
			}
			else if (priceKind == "SPR") {
				result = productPrice.getSprCost();
			}
		}

		return result;
	}
	


}
