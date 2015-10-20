package gr.com.eurotrade.controller;

import gr.com.eurotrade.entity.Country;
import gr.com.eurotrade.repository.ProductRepository;
import gr.com.eurotrade.service.BrandService;
import gr.com.eurotrade.service.CategoryService;
import gr.com.eurotrade.service.CategoryTranslationService;
import gr.com.eurotrade.service.CountryService;
import gr.com.eurotrade.service.ProductService;
import gr.com.eurotrade.service.UserService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CountryService countryService;	
	
	@Autowired
	private ProductRepository productRepository;	
	
	@Autowired
	private BrandService brandService;	
	
	@Autowired
	private CategoryService categoryService;	
	
	@Autowired
	private CategoryTranslationService categoryTranslationService;
	
	@RequestMapping("/products")
	public String users(Model model, Principal principal) {

		Country country = userService.findCountryByUsername(principal.getName());
		
//		System.out.println("products GET countryCode :"+ country.getCode());

		model.addAttribute("brandList",brandService.findAll());
		
//		model.addAttribute("categoryList",categoryService.findAll());
		model.addAttribute("categoryTranslatedList",categoryTranslationService.findAllByCountryListOfHashmap(country));
		
		model.addAttribute("simpleListOfMap",productService.simpleListOfMap(null,null,null,null,null,null,country));

		
		return "products";
	}
	
	@RequestMapping("/products/{id}")
	public String detail(Model model, @PathVariable int id) {
		model.addAttribute("product", productService.findOne(id));
		return "product-detail";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String filteredProducts(Model model, Principal principal, 
			@RequestParam("code") String code, 
			@RequestParam("catId") Integer catId, 
			@RequestParam("brandId") Integer brandId, 
			@RequestParam("descr") String descr, 
			@RequestParam("dfv1") String dfv1, 
			@RequestParam("dfv2") String dfv2) {

		Country country = userService.findCountryByUsername(principal.getName());
		
		
//		System.out.println("mpika");
		
//		System.out.println("products POST countryCode :"+ country.getCode());
//		
//		System.out.println("value1="+id);
//		System.out.println("value1="+catId);
//		System.out.println("value2="+brandId);
//		System.out.println("filtered products..");
		
		model.addAttribute("selectedBrandId",brandId);
		model.addAttribute("brandList",brandService.findAll());
		
		model.addAttribute("selectedCategoryId",catId);
		model.addAttribute("categoryTranslatedList",categoryTranslationService.findAllByCountryListOfHashmap(country));
		
		/*model.addAttribute("products",productService.findFilteredProductsTranslated(id,catId,brandId,country));*/

		model.addAttribute("simpleListOfMap",
				productService.simpleListOfMap(code,catId,brandId,descr,dfv1,dfv2,country));
	
//		model.addAttribute("test",productService.testSelect());

		return "products";
	}

	
	
	
}
