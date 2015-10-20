package gr.com.eurotrade.repository;

import gr.com.eurotrade.entity.Country;
import gr.com.eurotrade.entity.Product;
import gr.com.eurotrade.entity.ProductPrice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Integer> {

	List<ProductPrice> findByProduct(Product product);
	
	List<ProductPrice> findByCountry(Country country);

	ProductPrice findByProductAndCountry(Product product, Country country);
	
}
