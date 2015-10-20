package gr.com.eurotrade.service;

import gr.com.eurotrade.entity.AddressType;
import gr.com.eurotrade.entity.Blog;
import gr.com.eurotrade.entity.Branch;
import gr.com.eurotrade.entity.Brand;
import gr.com.eurotrade.entity.Category;
import gr.com.eurotrade.entity.CategoryTranslation;
import gr.com.eurotrade.entity.CategoryTranslationPK;
import gr.com.eurotrade.entity.City;
import gr.com.eurotrade.entity.Company;
import gr.com.eurotrade.entity.CompanyAddress;
import gr.com.eurotrade.entity.CompanyAddressPK;
import gr.com.eurotrade.entity.Country;
import gr.com.eurotrade.entity.Currency;
import gr.com.eurotrade.entity.Delay;
import gr.com.eurotrade.entity.DelayPK;
import gr.com.eurotrade.entity.DownloadCat;
import gr.com.eurotrade.entity.Item;
import gr.com.eurotrade.entity.OperationType;
import gr.com.eurotrade.entity.OrderStatus;
import gr.com.eurotrade.entity.PartType;
import gr.com.eurotrade.entity.PreorderStatus;
import gr.com.eurotrade.entity.Product;
import gr.com.eurotrade.entity.ProductPrice;
import gr.com.eurotrade.entity.ProductPricePK;
import gr.com.eurotrade.entity.ProductTranslation;
import gr.com.eurotrade.entity.ProductTranslationPK;
import gr.com.eurotrade.entity.Region;
import gr.com.eurotrade.entity.Role;
import gr.com.eurotrade.entity.Size;
import gr.com.eurotrade.entity.State;
import gr.com.eurotrade.entity.User;
import gr.com.eurotrade.repository.AddressTypeRepository;
import gr.com.eurotrade.repository.BlogRepository;
import gr.com.eurotrade.repository.BranchRepository;
import gr.com.eurotrade.repository.BrandRepository;
import gr.com.eurotrade.repository.CategoryRepository;
import gr.com.eurotrade.repository.CategoryTranslationRepository;
import gr.com.eurotrade.repository.CityRepository;
import gr.com.eurotrade.repository.CompanyAddressRepository;
import gr.com.eurotrade.repository.CompanyRepository;
import gr.com.eurotrade.repository.CountryRepository;
import gr.com.eurotrade.repository.CurrencyRepository;
import gr.com.eurotrade.repository.DelayRepository;
import gr.com.eurotrade.repository.DownloadCatRepository;
import gr.com.eurotrade.repository.ItemRepository;
import gr.com.eurotrade.repository.OperationTypeRepository;
import gr.com.eurotrade.repository.OrderStatusRepository;
import gr.com.eurotrade.repository.PartTypeRepository;
import gr.com.eurotrade.repository.PreorderStatusRepository;
import gr.com.eurotrade.repository.ProductPriceRepository;
import gr.com.eurotrade.repository.ProductRepository;
import gr.com.eurotrade.repository.ProductTranslationRepository;
import gr.com.eurotrade.repository.RegionRepository;
import gr.com.eurotrade.repository.RoleRepository;
import gr.com.eurotrade.repository.SizeRepository;
import gr.com.eurotrade.repository.StateRepository;
import gr.com.eurotrade.repository.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class InitDbService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private DelayRepository delayRepository;
	
	@Autowired
	private PartTypeRepository partTypeRepository;
	
	@Autowired
	private SizeRepository sizeRepository;
	
	@Autowired
	private OrderStatusRepository orderStatusRepository;
	
	@Autowired
	private PreorderStatusRepository preorderStatusRepository;
	
	@Autowired
	private DownloadCatRepository downloadCatRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	CategoryTranslationRepository categoryTranslationRepository;

	@Autowired
	BrandRepository brandRepository;
	
	@Autowired
	CurrencyRepository currencyRepository;
	
	@Autowired
	CountryRepository countryRepository;

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductTranslationRepository productTranslationRepository;
	
	@Autowired
	ProductPriceRepository productPriceRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private AddressTypeRepository addressTypeRepository;
	
	@Autowired
	private OperationTypeRepository operationTypeRepository;
	
	@Autowired
	private CompanyAddressRepository companyAddressRepository;
	
	@PostConstruct
	public void init() {
		//Role Table
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		Role roleSuperAdmin = new Role();
		roleSuperAdmin.setName("ROLE_SADMIN");
		roleRepository.save(roleSuperAdmin);
		
		Role roleCustomer = new Role();
		roleCustomer.setName("ROLE_CUSTOMER");
		roleRepository.save(roleCustomer);
		
		Role roleSeller = new Role();
		roleSeller.setName("ROLE_SELLER");
		roleRepository.save(roleSeller);
				
		//Branch Table
		Branch branch1 = new Branch();
		branch1.setAbr("RO");
		branch1.setName("ROMANIA-BRANCH");
		branchRepository.save(branch1);
		
		Branch branch2 = new Branch();
		branch2.setAbr("SLO");
		branch2.setName("SLOVENIA-BRANCH");
		branchRepository.save(branch2);
		
		Branch branch3 = new Branch();
		branch3.setAbr("GR");
		branch3.setName("GREECE-BRANCH");
		branchRepository.save(branch3);
		
		//Delay Table
		DelayPK delayPK1 = new DelayPK();
		delayPK1.setBranchFromId(branch1.getId());
		delayPK1.setBranchToId(branch2.getId());
		
		Delay delay1 = new Delay();
		delay1.setDelayPK(delayPK1);
		delay1.setDelay(5);
		delayRepository.save(delay1);

		DelayPK delayPK2 = new DelayPK();
		delayPK2.setBranchFromId(branch1.getId());
		delayPK2.setBranchToId(branch3.getId());
		
		Delay delay2 = new Delay();
		delay2.setDelayPK(delayPK2);
		delay2.setDelay(5);
		delayRepository.save(delay2);

		DelayPK delayPK3 = new DelayPK();
		delayPK3.setBranchFromId(branch2.getId());
		delayPK3.setBranchToId(branch1.getId());
		
		Delay delay3 = new Delay();
		delay3.setDelayPK(delayPK3);
		delay3.setDelay(5);
		delayRepository.save(delay3);

		DelayPK delayPK4 = new DelayPK();
		delayPK4.setBranchFromId(branch2.getId());
		delayPK4.setBranchToId(branch3.getId());
		
		Delay delay4 = new Delay();
		delay4.setDelayPK(delayPK4);
		delay4.setDelay(5);
		delayRepository.save(delay4);

		DelayPK delayPK5 = new DelayPK();
		delayPK5.setBranchFromId(branch3.getId());
		delayPK5.setBranchToId(branch1.getId());
		
		Delay delay5 = new Delay();
		delay5.setDelayPK(delayPK5);
		delay5.setDelay(5);
		delayRepository.save(delay5);

		DelayPK delayPK6 = new DelayPK();
		delayPK6.setBranchFromId(branch3.getId());
		delayPK6.setBranchToId(branch2.getId());
		
		Delay delay6 = new Delay();
		delay6.setDelayPK(delayPK6);
		delay6.setDelay(5);
		delayRepository.save(delay6);
		
		//PartType Table
		PartType partType1 = new PartType();
		partType1.setId(1);
		partType1.setName("ALTERNATIVE");
		partTypeRepository.save(partType1);
		
		PartType partType2 = new PartType();
		partType2.setId(2);
		partType2.setName("PART");
		partTypeRepository.save(partType2);
		
		//Size Table
		Size size1 = new Size();
		size1.setId(1);
		size1.setName("SMALL");
		sizeRepository.save(size1);
		
		Size size2 = new Size();
		size2.setId(2);
		size2.setName("BIG");
		sizeRepository.save(size2);
		
		//OrderStatus Table
		OrderStatus osBasket = new OrderStatus();
		osBasket.setId(0);
		osBasket.setName("BASKET");
		osBasket.setDescr("It is not an order yet");
		orderStatusRepository.save(osBasket);

		OrderStatus osInit = new OrderStatus();
		osInit.setId(1);
		osInit.setName("INIT");
		osInit.setDescr("A new order");
		orderStatusRepository.save(osInit);

		OrderStatus osShipped = new OrderStatus();
		osShipped.setId(2);
		osShipped.setName("SHIPPED");
		osShipped.setDescr("Order is approved");
		orderStatusRepository.save(osShipped);

		OrderStatus osCompleted = new OrderStatus();
		osCompleted.setId(3);
		osCompleted.setName("COMPLETED");
		osCompleted.setDescr("Order completed");
		orderStatusRepository.save(osCompleted);

		OrderStatus osRejucted = new OrderStatus();
		osRejucted.setId(4);
		osRejucted.setName("REJUCTED");
		osRejucted.setDescr("Order rejucted");
		orderStatusRepository.save(osRejucted);

		//PreorderStatus Table
		PreorderStatus preosInit = new PreorderStatus();
		preosInit.setId(1);
		preosInit.setName("INIT");
		preosInit.setDescr("A new order");
		preorderStatusRepository.save(preosInit);

		PreorderStatus preosShipped = new PreorderStatus();
		preosShipped.setId(2);
		preosShipped.setName("SHIPPED");
		preosShipped.setDescr("Order is approved");
		preorderStatusRepository.save(preosShipped);

		PreorderStatus preosCompleted = new PreorderStatus();
		preosCompleted.setId(3);
		preosCompleted.setName("COMPLETED");
		preosCompleted.setDescr("Order completed");
		preorderStatusRepository.save(preosCompleted);

		PreorderStatus preosRejucted = new PreorderStatus();
		preosRejucted.setId(4);
		preosRejucted.setName("REJUCTED");
		preosRejucted.setDescr("Order rejucted");
		preorderStatusRepository.save(preosRejucted);

		//DownloadCat Table
		DownloadCat downloadCat1 = new DownloadCat();
		downloadCat1.setId(1);
		downloadCat1.setName("NEWS");
		downloadCatRepository.save(downloadCat1);

		DownloadCat downloadCat2 = new DownloadCat();
		downloadCat2.setId(2);
		downloadCat2.setName("EVENT");
		downloadCatRepository.save(downloadCat2);

		DownloadCat downloadCat3 = new DownloadCat();
		downloadCat3.setId(3);
		downloadCat3.setName("MARKET NEWS");
		downloadCatRepository.save(downloadCat3);

		DownloadCat downloadCat4 = new DownloadCat();
		downloadCat4.setId(4);
		downloadCat4.setName("TECHNICAL NEWS");
		downloadCatRepository.save(downloadCat4);

		DownloadCat downloadCat15 = new DownloadCat();
		downloadCat15.setId(5);
		downloadCat15.setName("MY DOWNLOADS");
		downloadCatRepository.save(downloadCat15);
		
		//addressType
		AddressType addressType1 = new AddressType();
		addressType1.setId(1);
		addressType1.setName("TAX");
		addressTypeRepository.save(addressType1);
		
		AddressType addressType2 = new AddressType();
		addressType2.setId(2);
		addressType2.setName("DELIVERY");
		addressTypeRepository.save(addressType2);		
				
		//operationType
		OperationType operationType1 = new OperationType();
		operationType1.setId(1);
		operationType1.setName("SHOP");
		operationTypeRepository.save(operationType1);
		
		OperationType operationType2 = new OperationType();
		operationType2.setId(2);
		operationType2.setName("WAREHOUSE");
		operationTypeRepository.save(operationType2);		

		/********************************************
		 ******* DEVELOPMENT DATA FOR TESTING *******
		********************************************/
		//Currency
		Currency currency1 = new Currency();
		currency1.setName("EURO");
		currency1.setSymbol("€");
		currencyRepository.save(currency1);
		
		Currency currency2 = new Currency();
		currency2.setName("POUND");
		currency2.setSymbol("£");
		currencyRepository.save(currency2);
		
		//Country
		Country country1 = new Country();
		country1.setCode("GR");
		country1.setName("GREECE");
		country1.setCurrency(currency1);
		country1.setBranch(branch3);
		countryRepository.save(country1);
		
		Country country2 = new Country();
		country2.setCode("EN");
		country2.setName("ENGLAND");
		country2.setCurrency(currency2);
		country2.setBranch(branch3);
		countryRepository.save(country2);
		
		// Region
		Region region1 = new Region();
		region1.setName("ΜΑΚΕΔΟΝΙΑ");
		region1.setCountry(country1);
		regionRepository.save(region1);
		
		Region region2 = new Region();
		region2.setName("ΣΤΕΡΕΑ ΕΛΛΑΔΑ");
		region2.setCountry(country1);
		regionRepository.save(region2);
		
		Region region3 = new Region();
		region3.setName("SOUTH EAST");
		region3.setCountry(country2);
		regionRepository.save(region3);
		
		Region region4 = new Region();
		region4.setName("EAST OF ENGLAND");
		region4.setCountry(country2);
		regionRepository.save(region4);
		
		// State
		State state1 = new State();
		state1.setName("ΘΕΣΣΑΛΟΝΙΚΗΣ");
		state1.setRegion(region1);
		stateRepository.save(state1);
				
		State state2 = new State();
		state2.setName("ΧΑΛΚΙΔΙΚΗΣ");
		state2.setRegion(region1);
		stateRepository.save(state2);
				
		State state3 = new State();
		state3.setName("ΚΑΡΔΙΤΣΑΣ");
		state3.setRegion(region2);
		stateRepository.save(state3);

		State state4 = new State();
		state4.setName("BERKSHIRE");
		state4.setRegion(region3);
		stateRepository.save(state4);
				
		State state5 = new State();
		state5.setName("ESSEX");
		state5.setRegion(region4);
		stateRepository.save(state5);

		// City
		City city1 = new City();
		city1.setName("ΘΕΣΣΑΛΟΝΙΚΗ");
		city1.setState(state1);
		cityRepository.save(city1);
				
		City city2 = new City();
		city2.setName("ΑΓΙΟΣ ΝΙΚΟΛΑΟΣ");
		city2.setState(state2);
		cityRepository.save(city2);
				
		City city3 = new City();
		city3.setName("ΚΥΨΕΛΗ");
		city3.setState(state3);
		cityRepository.save(city3);
				
		City city4 = new City();
		city4.setName("SLOUGH");
		city4.setState(state4);
		cityRepository.save(city4);
		
		City city5 = new City();
		city5.setName("BEDFORD");
		city5.setState(state5);
		cityRepository.save(city5);

		// Brand
		Brand brand1 = new Brand();
		brand1.setName("BELL");
		brandRepository.save(brand1);
		
		Brand brand2 = new Brand();
		brand2.setName("SCOTT");
		brandRepository.save(brand2);
		
		Brand brand3 = new Brand();
		brand3.setName("SHIMANO");
		brandRepository.save(brand3);

		// Category 1
		Category category1 = new Category();
		category1.setPublished(true);
		categoryRepository.save(category1);

		CategoryTranslationPK categoryTranslationPK1 = new CategoryTranslationPK();
		categoryTranslationPK1.setCountryId(country2.getId()); 
		categoryTranslationPK1.setCategoryId(category1.getId());
		CategoryTranslation categoryTranslation1 = new CategoryTranslation();
		categoryTranslation1.setCategoryTranslationPK(categoryTranslationPK1);
		categoryTranslation1.setName("HELMETS");
		categoryTranslationRepository.save(categoryTranslation1);

		CategoryTranslationPK categoryTranslationPK10 = new CategoryTranslationPK();
		categoryTranslationPK10.setCountryId(country1.getId()); 
		categoryTranslationPK10.setCategoryId(category1.getId());
		CategoryTranslation categoryTranslation10 = new CategoryTranslation();
		categoryTranslation10.setCategoryTranslationPK(categoryTranslationPK10);
		categoryTranslation10.setName("ΚΡΑΝΗ");
		categoryTranslationRepository.save(categoryTranslation10);

		// Category 2
		Category category2 = new Category();
		category2.setPublished(true);
		categoryRepository.save(category2);

		CategoryTranslationPK categoryTranslationPK2 = new CategoryTranslationPK();
		categoryTranslationPK2.setCountryId(country2.getId()); 
		categoryTranslationPK2.setCategoryId(category2.getId());
		CategoryTranslation categoryTranslation2 = new CategoryTranslation();
		categoryTranslation2.setCategoryTranslationPK(categoryTranslationPK2);
		categoryTranslation2.setName("BICYCLES");
		categoryTranslationRepository.save(categoryTranslation2);

		CategoryTranslationPK categoryTranslationPK20 = new CategoryTranslationPK();
		categoryTranslationPK20.setCountryId(country1.getId()); 
		categoryTranslationPK20.setCategoryId(category2.getId());
		CategoryTranslation categoryTranslation20 = new CategoryTranslation();
		categoryTranslation20.setCategoryTranslationPK(categoryTranslationPK20);
		categoryTranslation20.setName("ΠΟΔΗΛΑΤΑ");
		categoryTranslationRepository.save(categoryTranslation20);

		// Category 2
		Category category3 = new Category();
		category3.setPublished(true);
		categoryRepository.save(category3);

		CategoryTranslationPK categoryTranslationPK3 = new CategoryTranslationPK();
		categoryTranslationPK3.setCountryId(country2.getId()); 
		categoryTranslationPK3.setCategoryId(category3.getId());
		CategoryTranslation categoryTranslation3 = new CategoryTranslation();
		categoryTranslation3.setCategoryTranslationPK(categoryTranslationPK3);
		categoryTranslation3.setName("TOOLS");
		categoryTranslationRepository.save(categoryTranslation3);

		CategoryTranslationPK categoryTranslationPK30 = new CategoryTranslationPK();
		categoryTranslationPK30.setCountryId(country1.getId()); 
		categoryTranslationPK30.setCategoryId(category3.getId());
		CategoryTranslation categoryTranslation30 = new CategoryTranslation();
		categoryTranslation30.setCategoryTranslationPK(categoryTranslationPK30);
		categoryTranslation30.setName("ΕΡΓΑΛΕΙΑ");
		categoryTranslationRepository.save(categoryTranslation30);

		//product1		
		Product product1 = new Product();
		product1.setCode("2007527");
		product1.setBrand(brand1);
		product1.setCategory(category1);
		product1.setDfv1("S");
		product1.setDfv2("WGMA");
		product1.setBarcode("0768686779601");		
		productRepository.save(product1);

		ProductTranslationPK productTranslationPK1 = new ProductTranslationPK();
		productTranslationPK1.setCountryId(country2.getId()); 
		productTranslationPK1.setProductId(product1.getId());
		ProductTranslation productTranslation1 = new ProductTranslation();
		productTranslation1.setProductTranslationPK(productTranslationPK1);
		productTranslation1.setDescr("SWEEP R BK/CHARCOAL (M) (08)");
		productTranslationRepository.save(productTranslation1);
		
		ProductTranslationPK productTranslationPK10 = new ProductTranslationPK();
		productTranslationPK10.setCountryId(country1.getId()); 
		productTranslationPK10.setProductId(product1.getId());
		ProductTranslation productTranslation10 = new ProductTranslation();
		productTranslation10.setProductTranslationPK(productTranslationPK10);
		productTranslation10.setDescr("Ελληνικά SWEEP R BK/CHARCOAL (M) (08)");
		productTranslationRepository.save(productTranslation10);
		
		ProductPricePK productPricePK1 = new ProductPricePK();
		productPricePK1.setCountryId(country2.getId()); 
		productPricePK1.setProductId(product1.getId());
		ProductPrice productPrice1 = new ProductPrice();
		productPrice1.setProductPricePK(productPricePK1);
		productPrice1.setWlsCost(290);
		productPriceRepository.save(productPrice1);
		
		
		//product2
		Product product2 = new Product();
		product2.setCode("2007536");
		product2.setBrand(brand2);
		product2.setCategory(category1);
		product2.setDfv1("M");
		product2.setDfv2("BPRC");
		product2.setBarcode("0768686779602");		
		productRepository.save(product2);

		ProductTranslationPK productTranslationPK2 = new ProductTranslationPK();
		productTranslationPK2.setCountryId(country2.getId()); 
		productTranslationPK2.setProductId(product2.getId());
		ProductTranslation productTranslation2 = new ProductTranslation();
		productTranslation2.setProductTranslationPK(productTranslationPK2);
		productTranslation2.setDescr("FURIO BU/SVR (M) (08)");
		productTranslationRepository.save(productTranslation2);
		
		ProductTranslationPK productTranslationPK20 = new ProductTranslationPK();
		productTranslationPK20.setCountryId(country1.getId()); 
		productTranslationPK20.setProductId(product2.getId());
		ProductTranslation productTranslation20 = new ProductTranslation();
		productTranslation20.setProductTranslationPK(productTranslationPK20);
		productTranslation20.setDescr("Ελληνικά FURIO BU/SVR (M) (08)");
		productTranslationRepository.save(productTranslation20);
		
		ProductPricePK productPricePK2 = new ProductPricePK();
		productPricePK2.setCountryId(country2.getId()); 
		productPricePK2.setProductId(product1.getId());
		ProductPrice productPrice2 = new ProductPrice();
		productPrice2.setProductPricePK(productPricePK2);
		productPrice2.setWlsCost(150);
		productPriceRepository.save(productPrice2);
		
		//product3
		Product product3 = new Product();
		product3.setCode("2007550");
		product3.setBrand(brand3);
		product3.setCategory(category1);
		product3.setDfv1("S");
		product3.setDfv2("STLI");
		product3.setBarcode("0768686779603");		
		productRepository.save(product3);

		ProductTranslationPK productTranslationPK3 = new ProductTranslationPK();
		productTranslationPK3.setCountryId(country2.getId()); 
		productTranslationPK3.setProductId(product3.getId());
		ProductTranslation productTranslation3 = new ProductTranslation();
		productTranslation3.setProductTranslationPK(productTranslationPK3);
		productTranslation3.setDescr("METEOR II SVR/TITANIUM (M) (08)");
		productTranslationRepository.save(productTranslation3);
		
		ProductTranslationPK productTranslationPK30 = new ProductTranslationPK();
		productTranslationPK30.setCountryId(country1.getId()); 
		productTranslationPK30.setProductId(product3.getId());
		ProductTranslation productTranslation30 = new ProductTranslation();
		productTranslation30.setProductTranslationPK(productTranslationPK30);
		productTranslation30.setDescr("Ελληνικά METEOR II SVR/TITANIUM (M) (08)");
		productTranslationRepository.save(productTranslation30);
		
		ProductPricePK productPricePK3 = new ProductPricePK();
		productPricePK3.setCountryId(country2.getId()); 
		productPricePK3.setProductId(product3.getId());
		ProductPrice productPrice3 = new ProductPrice();
		productPrice3.setProductPricePK(productPricePK3);
		productPrice3.setWlsCost(295);
		productPriceRepository.save(productPrice3);
		
		//product4
		Product product4 = new Product();
		product4.setCode("211960");
		product4.setBrand(brand1);
		product4.setCategory(category2);
		product4.setDfv1("210");
		product4.setDfv2("PINK");
		product4.setBarcode("0768686779604");		
		productRepository.save(product4);

		ProductTranslationPK productTranslationPK4 = new ProductTranslationPK();
		productTranslationPK4.setCountryId(country2.getId()); 
		productTranslationPK4.setProductId(product4.getId());
		ProductTranslation productTranslation4 = new ProductTranslation();
		productTranslation4.setProductTranslationPK(productTranslationPK4);
		productTranslation4.setDescr("26\" VOLTAGE YZ 0 DISC LIGHT GN/WH (09)");
		productTranslationRepository.save(productTranslation4);
		
		ProductTranslationPK productTranslationPK40 = new ProductTranslationPK();
		productTranslationPK40.setCountryId(country1.getId()); 
		productTranslationPK40.setProductId(product4.getId());
		ProductTranslation productTranslation40 = new ProductTranslation();
		productTranslation40.setProductTranslationPK(productTranslationPK40);
		productTranslation40.setDescr("Ελληνικά 26\" VOLTAGE YZ 0 DISC LIGHT GN/WH (09)");
		productTranslationRepository.save(productTranslation40);
		
		ProductPricePK productPricePK4 = new ProductPricePK();
		productPricePK4.setCountryId(country2.getId()); 
		productPricePK4.setProductId(product4.getId());
		ProductPrice productPrice4 = new ProductPrice();
		productPrice4.setProductPricePK(productPricePK4);
		productPrice4.setWlsCost(1850);
		productPriceRepository.save(productPrice4);
		
		//product5
		Product product5 = new Product();
		product5.setCode("215581");
		product5.setBrand(brand2);
		product5.setCategory(category2);
		product5.setDfv1("230");
		product5.setDfv2("GN/BK");
		product5.setBarcode("0768686779605");		
		productRepository.save(product5);

		ProductTranslationPK productTranslationPK5 = new ProductTranslationPK();
		productTranslationPK5.setCountryId(country2.getId()); 
		productTranslationPK5.setProductId(product5.getId());
		ProductTranslation productTranslation5 = new ProductTranslation();
		productTranslation5.setProductTranslationPK(productTranslationPK5);
		productTranslation5.setDescr("MTB 26\" GENIUS 30 BK/RD (10)");
		productTranslationRepository.save(productTranslation5);
		
		ProductTranslationPK productTranslationPK50 = new ProductTranslationPK();
		productTranslationPK50.setCountryId(country1.getId()); 
		productTranslationPK50.setProductId(product5.getId());
		ProductTranslation productTranslation50 = new ProductTranslation();
		productTranslation50.setProductTranslationPK(productTranslationPK50);
		productTranslation50.setDescr("Ελληνικά MTB 26\" GENIUS 30 BK/RD (10)");
		productTranslationRepository.save(productTranslation50);
		
		ProductPricePK productPricePK5 = new ProductPricePK();
		productPricePK5.setCountryId(country2.getId()); 
		productPricePK5.setProductId(product5.getId());
		ProductPrice productPrice5 = new ProductPrice();
		productPrice5.setProductPricePK(productPricePK5);
		productPrice5.setWlsCost(6750);
		productPriceRepository.save(productPrice5);
		
		//product6
		Product product6 = new Product();
		product6.setCode("217959");
		product6.setBrand(brand3);
		product6.setCategory(category2);
		product6.setDfv1("280");
		product6.setDfv2("BU");
		product6.setBarcode("0768686779606");		
		productRepository.save(product6);

		ProductTranslationPK productTranslationPK6 = new ProductTranslationPK();
		productTranslationPK6.setCountryId(country2.getId()); 
		productTranslationPK6.setProductId(product6.getId());
		ProductTranslation productTranslation6 = new ProductTranslation();
		productTranslation6.setProductTranslationPK(productTranslationPK6);
		productTranslation6.setDescr("MTB 26\" GENIUS 40 BK/WH (11)");
		productTranslationRepository.save(productTranslation6);
		
		ProductTranslationPK productTranslationPK60 = new ProductTranslationPK();
		productTranslationPK60.setCountryId(country1.getId()); 
		productTranslationPK60.setProductId(product6.getId());
		ProductTranslation productTranslation60 = new ProductTranslation();
		productTranslation60.setProductTranslationPK(productTranslationPK60);
		productTranslation60.setDescr("Ελληνικά MTB 26\" GENIUS 40 BK/WH (11)");
		productTranslationRepository.save(productTranslation60);
		
		ProductPricePK productPricePK6 = new ProductPricePK();
		productPricePK6.setCountryId(country2.getId()); 
		productPricePK6.setProductId(product6.getId());
		ProductPrice productPrice6 = new ProductPrice();
		productPrice6.setProductPricePK(productPricePK6);
		productPrice6.setWlsCost(6400);
		productPriceRepository.save(productPrice6);
		
		//product7
		Product product7 = new Product();
		product7.setCode("Y13003200");
		product7.setBrand(brand1);
		product7.setCategory(category3);
		product7.setBarcode("0768686779607");		
		productRepository.save(product7);

		ProductTranslationPK productTranslationPK7 = new ProductTranslationPK();
		productTranslationPK7.setCountryId(country2.getId()); 
		productTranslationPK7.setProductId(product7.getId());
		ProductTranslation productTranslation7 = new ProductTranslation();
		productTranslation7.setProductTranslationPK(productTranslationPK7);
		productTranslation7.setDescr("TL-ST03 RETURN SPRING INSTALLATION TOOL SHIMANO");
		productTranslationRepository.save(productTranslation7);
		
		ProductTranslationPK productTranslationPK70 = new ProductTranslationPK();
		productTranslationPK70.setCountryId(country1.getId()); 
		productTranslationPK70.setProductId(product7.getId());
		ProductTranslation productTranslation70 = new ProductTranslation();
		productTranslation70.setProductTranslationPK(productTranslationPK70);
		productTranslation70.setDescr("Ελληνικά TL-ST03 RETURN SPRING INSTALLATION TOOL SHIMANO");
		productTranslationRepository.save(productTranslation70);
		
		ProductPricePK productPricePK7 = new ProductPricePK();
		productPricePK7.setCountryId(country2.getId()); 
		productPricePK7.setProductId(product7.getId());
		ProductPrice productPrice7 = new ProductPrice();
		productPrice7.setProductPricePK(productPricePK7);
		productPrice7.setWlsCost(5.09);
		productPriceRepository.save(productPrice7);
		
		//product8
		Product product8 = new Product();
		product8.setCode("Y13009010");
		product8.setBrand(brand2);
		product8.setCategory(category3);
		product8.setBarcode("0768686779608");		
		productRepository.save(product8);

		ProductTranslationPK productTranslationPK8 = new ProductTranslationPK();
		productTranslationPK8.setCountryId(country2.getId()); 
		productTranslationPK8.setProductId(product8.getId());
		ProductTranslation productTranslation8 = new ProductTranslation();
		productTranslation8.setProductTranslationPK(productTranslationPK8);
		productTranslation8.setDescr("CRANK EXTRACTOR SHIMANO TL-FC10 COTTERLESS");
		productTranslationRepository.save(productTranslation8);
		
		ProductTranslationPK productTranslationPK80 = new ProductTranslationPK();
		productTranslationPK80.setCountryId(country1.getId()); 
		productTranslationPK80.setProductId(product8.getId());
		ProductTranslation productTranslation80 = new ProductTranslation();
		productTranslation80.setProductTranslationPK(productTranslationPK80);
		productTranslation80.setDescr("Ελληνικά CRANK EXTRACTOR SHIMANO TL-FC10 COTTERLESS");
		productTranslationRepository.save(productTranslation80);
		
		ProductPricePK productPricePK8 = new ProductPricePK();
		productPricePK8.setCountryId(country2.getId()); 
		productPricePK8.setProductId(product8.getId());
		ProductPrice productPrice8 = new ProductPrice();
		productPrice8.setProductPricePK(productPricePK8);
		productPrice8.setWlsCost(33.6);
		productPriceRepository.save(productPrice8);
		
		//product9
		Product product9 = new Product();
		product9.setCode("Y13009071");
		product9.setBrand(brand3);
		product9.setCategory(category3);
		product9.setBarcode("0768686779609");		
		productRepository.save(product9);

		ProductTranslationPK productTranslationPK9 = new ProductTranslationPK();
		productTranslationPK9.setCountryId(country2.getId()); 
		productTranslationPK9.setProductId(product9.getId());
		ProductTranslation productTranslation9 = new ProductTranslation();
		productTranslation9.setProductTranslationPK(productTranslationPK9);
		productTranslation9.setDescr("TL-UN96 SPECIAL TOOL B SHIMANO");
		productTranslationRepository.save(productTranslation9);
		
		ProductTranslationPK productTranslationPK90 = new ProductTranslationPK();
		productTranslationPK90.setCountryId(country1.getId()); 
		productTranslationPK90.setProductId(product9.getId());
		ProductTranslation productTranslation90 = new ProductTranslation();
		productTranslation90.setProductTranslationPK(productTranslationPK90);
		productTranslation90.setDescr("Ελληνικά TL-UN96 SPECIAL TOOL B SHIMANO");
		productTranslationRepository.save(productTranslation90);
		
		ProductPricePK productPricePK9 = new ProductPricePK();
		productPricePK9.setCountryId(country2.getId()); 
		productPricePK9.setProductId(product9.getId());
		ProductPrice productPrice9 = new ProductPrice();
		productPrice9.setProductPricePK(productPricePK9);
		productPrice9.setWlsCost(19.74);
		productPriceRepository.save(productPrice9);

		Company company1 = new Company();
		company1.setName("Company1");
		company1.setCountry(country1);
		companyRepository.save(company1);

		Company company2 = new Company();
		company2.setName("Company2");
		company2.setCountry(country2);
		companyRepository.save(company2);

		// company1 address 1
		CompanyAddressPK companyAddressPK1 = new CompanyAddressPK();
		companyAddressPK1.setAaPerCompany(1);
		companyAddressPK1.setCompanyId(company1.getId());
		CompanyAddress companyAddress1 = new CompanyAddress();
		companyAddress1.setCompanyAddressPK(companyAddressPK1);
		companyAddress1.setAddress("Σπερχειού 3, 546 34");
		companyAddress1.setAddressType(addressType1);
		companyAddress1.setOperationType(operationType2);
		companyAddress1.setCity(city1);
		companyAddressRepository.save(companyAddress1);
		
		// company1 address 2
		CompanyAddressPK companyAddressPK2 = new CompanyAddressPK();
		companyAddressPK2.setAaPerCompany(2);
		companyAddressPK2.setCompanyId(company1.getId());
		CompanyAddress companyAddress2 = new CompanyAddress();
		companyAddress2.setCompanyAddressPK(companyAddressPK2);
		companyAddress2.setAddress("Εθνικής Αντιστάσεως 18, 630 78");
		companyAddress2.setAddressType(addressType2);
		companyAddress2.setOperationType(operationType1);
		companyAddress2.setCity(city2);
		companyAddressRepository.save(companyAddress2);
		
		// company1 address 3
		CompanyAddressPK companyAddressPK3 = new CompanyAddressPK();
		companyAddressPK3.setAaPerCompany(3);
		companyAddressPK3.setCompanyId(company1.getId());
		CompanyAddress companyAddress3 = new CompanyAddress();
		companyAddress3.setCompanyAddressPK(companyAddressPK3);
		companyAddress3.setAddress("Κύπρου 89, 113 64");
		companyAddress3.setAddressType(addressType2);
		companyAddress3.setOperationType(operationType1);
		companyAddress3.setCity(city3);
		companyAddressRepository.save(companyAddress3);
		
		// company1 address 4
		CompanyAddressPK companyAddressPK4 = new CompanyAddressPK();
		companyAddressPK4.setAaPerCompany(1);
		companyAddressPK4.setCompanyId(company2.getId());
		CompanyAddress companyAddress4 = new CompanyAddress();
		companyAddress4.setCompanyAddressPK(companyAddressPK4);
		companyAddress4.setAddress("17 Winvale, SL1 2JQ");
		companyAddress4.setAddressType(addressType1);
		companyAddress4.setOperationType(operationType2);
		companyAddress4.setCity(city4);
		companyAddressRepository.save(companyAddress4);
		
		// company1 address 5
		CompanyAddressPK companyAddressPK5 = new CompanyAddressPK();
		companyAddressPK5.setAaPerCompany(2);
		companyAddressPK5.setCompanyId(company2.getId());
		CompanyAddress companyAddress5 = new CompanyAddress();
		companyAddress5.setCompanyAddressPK(companyAddressPK5);
		companyAddress5.setAddress("1 Cardington Rd, MK42");
		companyAddress5.setAddressType(addressType2);
		companyAddress5.setOperationType(operationType1);
		companyAddress5.setCity(city5);
		companyAddressRepository.save(companyAddress5);
		
		/********************************************
		 ************** TUTORIAL DATA ***************
		********************************************/

		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setUsername("admin");
		BCryptPasswordEncoder encoder1 = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder1.encode("admin"));
		List<Role> rolesAdmin = new ArrayList<Role>();
		rolesAdmin.add(roleUser);
		rolesAdmin.add(roleAdmin);
		userAdmin.setRoleList(rolesAdmin);
		userAdmin.setCompany(company2);
		userRepository.save(userAdmin);

		User userOnly = new User();
		userOnly.setEnabled(true);
		userOnly.setUsername("user");
		BCryptPasswordEncoder encoder2 = new BCryptPasswordEncoder();
		userOnly.setPassword(encoder2.encode("user"));
		List<Role> rolesUser = new ArrayList<Role>();
		rolesUser.add(roleUser);
		userOnly.setRoleList(rolesUser);
		userOnly.setCompany(company1);
		userRepository.save(userOnly);
		
		User userCustomer = new User();
		userCustomer.setEnabled(true);
		userCustomer.setUsername("customer");
		BCryptPasswordEncoder encoder3 = new BCryptPasswordEncoder();
		userCustomer.setPassword(encoder3.encode("customer"));
		List<Role> rolesCustomer = new ArrayList<Role>();
		rolesCustomer.add(roleUser);
		rolesCustomer.add(roleCustomer);
		userCustomer.setRoleList(rolesCustomer);
		userCustomer.setCompany(company2);
		userRepository.save(userCustomer);
		
		User userSeller = new User();
		userSeller.setEnabled(true);
		userSeller.setUsername("seller");
		BCryptPasswordEncoder encoder4 = new BCryptPasswordEncoder();
		userSeller.setPassword(encoder4.encode("seller"));
		List<Role> rolesSeller = new ArrayList<Role>();
		rolesSeller.add(roleUser);
		rolesSeller.add(roleSeller);
		userSeller.setRoleList(rolesSeller);
		userSeller.setCompany(company1);
		userRepository.save(userSeller);
		
		User userSuperAdmin = new User();
		userSuperAdmin.setEnabled(true);
		userSuperAdmin.setUsername("sadmin");
		BCryptPasswordEncoder encoder5 = new BCryptPasswordEncoder();
		userSuperAdmin.setPassword(encoder5.encode("sadmin"));
		List<Role> rolesSuperAdmin = new ArrayList<Role>();
		rolesSuperAdmin.add(roleUser);
		rolesSuperAdmin.add(roleSuperAdmin);
		userSuperAdmin.setRoleList(rolesSuperAdmin);
		userSuperAdmin.setCompany(company1);
		userRepository.save(userSuperAdmin);
		
		Blog blogJavavids = new Blog();
		blogJavavids.setName("JavaVids");
		blogJavavids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blogJavavids.setUser(userCustomer);
		blogRepository.save(blogJavavids);
		
		Item item1 = new Item();
		item1.setBlog(blogJavavids);
		item1.setTitle("first");
		item1.setLink("http://www.javavids.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogJavavids);
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
		
	}
}
