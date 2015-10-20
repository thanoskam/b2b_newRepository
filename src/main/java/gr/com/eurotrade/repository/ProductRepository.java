package gr.com.eurotrade.repository;

import gr.com.eurotrade.entity.Brand;
import gr.com.eurotrade.entity.Category;
import gr.com.eurotrade.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByCode(String code);

	List<Product> findByCategory(Category category);

	List<Product> findByBrand(Brand brand);

	List<Product> findByBrandAndCategory(Brand brand, Category category);
	
/*	@Query("SELECT p FROM Product p WHERE catId = :catId)")
    public List<Product> findByCatid(@Param("catId") Integer catId);
*/
	@Query("SELECT p FROM Product p WHERE catId = :catId)")
    public List<Product> customFindByCatid(@Param("catId") Integer catId);


}
