package gr.com.eurotrade.repository;

import gr.com.eurotrade.entity.Country;
import gr.com.eurotrade.entity.Product;
import gr.com.eurotrade.entity.ProductTranslation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTranslationRepository extends JpaRepository<ProductTranslation, Integer> {

	List<ProductTranslation> findByProduct(Product product);
	
	List<ProductTranslation> findByCountry(Country country);

	ProductTranslation findByProductAndCountry(Product product,Country country);
	
}
