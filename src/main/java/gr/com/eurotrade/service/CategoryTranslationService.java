package gr.com.eurotrade.service;

import gr.com.eurotrade.entity.Category;
import gr.com.eurotrade.entity.CategoryTranslation;
import gr.com.eurotrade.entity.Country;
import gr.com.eurotrade.entity.Product;
import gr.com.eurotrade.entity.ProductTranslation;
import gr.com.eurotrade.repository.CategoryTranslationRepository;
import gr.com.eurotrade.repository.CountryRepository;
import gr.com.eurotrade.repository.ProductRepository;
import gr.com.eurotrade.repository.ProductTranslationRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryTranslationService {

	@Autowired
	private CategoryTranslationRepository categoryTranslationRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	
	public List<CategoryTranslation> findAll() {
		return categoryTranslationRepository.findAll();
	}


	public CategoryTranslation findOne(int id) {
		// TODO Auto-generated method stub
		return categoryTranslationRepository.findOne(id);
	}

	
	public String translateCategory(Category category, Country country ) {
		// TODO Auto-generated method stub
		CategoryTranslation categoryTranslation = categoryTranslationRepository.findByCategoryAndCountry(category,country);
		
		String result = "";
		
		
		if(categoryTranslation!=null){
			result = categoryTranslation.getName();
		}
		
		return result;
	}


	public ArrayList<HashMap<String,String>> findAllByCountryListOfHashmap(Country country) {

		List<CategoryTranslation> categoryTranslatedList = categoryTranslationRepository.findAllByCountry(country);
		ArrayList<HashMap<String,String>> ListOfMap = new ArrayList<HashMap<String,String>>();

		HashMap<String, String> hashMapCategoryTranslation = null;

		for(CategoryTranslation categoryTranslation : categoryTranslatedList) {
			hashMapCategoryTranslation = new HashMap<String,String>();
			hashMapCategoryTranslation.put("categoryId", categoryTranslation.getCategoryTranslationPK().getCategoryId().toString());
			hashMapCategoryTranslation.put("categoryName", categoryTranslation.getName());
	        System.out.println("categoryId : " + categoryTranslation.getCategoryTranslationPK().getCategoryId().toString() + ", categoryName : " + categoryTranslation.getName());

	        ListOfMap.add(hashMapCategoryTranslation);
		}
		

/*		// Debugging..Starts
		System.out.println("before for statement");
		for(HashMap<String,String> categoryTranslation : ListOfMap){

			Iterator it = categoryTranslation.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        it.remove(); // avoids a ConcurrentModificationException
		    }
			
		}
		System.out.println("after for statement");
		
		// Debuggin Ends
*/		
		return ListOfMap;
	}
	
	


}
