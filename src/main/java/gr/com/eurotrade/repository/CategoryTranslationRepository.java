package gr.com.eurotrade.repository;

import java.util.List;

import gr.com.eurotrade.entity.Category;
import gr.com.eurotrade.entity.CategoryTranslation;
import gr.com.eurotrade.entity.Country;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryTranslationRepository extends JpaRepository<CategoryTranslation, Integer> {

	CategoryTranslation findByCategoryAndCountry(Category category,Country country);

	List<CategoryTranslation> findAllByCountry(Country country);
	
}
