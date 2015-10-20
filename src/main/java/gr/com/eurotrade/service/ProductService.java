package gr.com.eurotrade.service;

import gr.com.eurotrade.entity.Brand;
import gr.com.eurotrade.entity.Category;
import gr.com.eurotrade.entity.Country;
import gr.com.eurotrade.entity.Product;
import gr.com.eurotrade.repository.BrandRepository;
import gr.com.eurotrade.repository.CategoryRepository;
import gr.com.eurotrade.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	private static final Logger logger = Logger
			.getLogger(ProductService.class);
	
	@Autowired
	private ProductRepository productRepository;

	private DataSource datasource;
	
	@Autowired
	private ProductTranslationService productTranslationService;
	
	@Autowired
	private CategoryTranslationService categoryTranslationService;
	
	@Autowired
	private ProductPriceService productPriceService;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BrandRepository brandRepository;
	
	public List<Product> getProductList(Integer catId, Integer brandId, Country country){
		List<Product> productList = null;

		if(catId == null && brandId == null){
			logger.info("mpika se ola");
			productList = productRepository.findAll();			
		}
		else if (catId != null && brandId == null)
		{
			logger.info("mpika sto category");
			Category category = categoryRepository.findOne(catId);
			productList = productRepository.findByCategory(category);						
//			productList = productRepository.customFindByCatid(catId);					
		}
		else if (catId == null && brandId != null)
		{
			logger.info("mpika sto brand");
			Brand brand = brandRepository.findOne(brandId);
			productList = productRepository.findByBrand(brand);						
		}
		else if (catId != null && brandId != null)
		{
			logger.info("mpika sto brand and category");
			Category category = categoryRepository.findOne(catId);
			Brand brand = brandRepository.findOne(brandId);
			productList = productRepository.findByBrandAndCategory(brand, category);						
		}
		else
		{
		}
return productList;
	}

	public List<HashMap<String,String>> simpleListOfMap(
			String code, 
			Integer catId, 
			Integer brandId, 
			String descr, 
			String dfv1, 
			String dfv2, 
			Country country){
		logger.info("simpleListOfMap : creating single list ...");
		logger.info("catId = : " + catId);
		logger.info("brandId = : " + brandId);
		List<Product> productList = getProductList(catId, brandId, country);

		List<HashMap<String,String>> simpleListOfMap = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> map;
		
		for(Product product : productList){	 	
			logger.debug("simpleListOfMap [ product id : " + product.getId() + " , product code : " + product.getCode() + " ]");
			
			map = new HashMap<String,String>();

			map.put("id",product.getId().toString());
			map.put("code",product.getCode());
			
			map.put("brand",product.getBrand().getName());
			map.put("brandId",product.getBrand().getId().toString());
			
			map.put("category", categoryTranslationService.translateCategory(product.getCategory(), country));
			map.put("categoryId",product.getBrand().getId().toString());

			map.put("descr",productTranslationService.translateProduct(product, country));
			
			map.put("priceWls",productPriceService.getWlsSprPrice("WLS", product, country).toString());
			map.put("priceSpr",productPriceService.getWlsSprPrice("SPR", product, country).toString());
			map.put("dfv1",product.getDfv1());
			map.put("dfv2",product.getDfv2());
			map.put("barecode",product.getBarcode());
			map.put("priceSymbol",country.getCurrency().getSymbol());
			
			simpleListOfMap.add(map);
		}
	
/*		// Debugging..Starts
		
		for(HashMap<String,String> product : simpleListOfMap){

			Iterator it = product.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        it.remove(); // avoids a ConcurrentModificationException
		    }
			
		}
		
		// Debuggin Ends
*/
		logger.error("simpleListOfMap : Error!!");
		return simpleListOfMap;

	}

 	public Product findOne(int id) {
		// TODO Auto-generated method stub
		return productRepository.findOne(id);
	}
	

}
