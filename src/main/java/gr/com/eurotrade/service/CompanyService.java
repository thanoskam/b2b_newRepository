package gr.com.eurotrade.service;

import gr.com.eurotrade.entity.Company;
import gr.com.eurotrade.entity.CompanyAddress;
import gr.com.eurotrade.entity.User;
import gr.com.eurotrade.repository.CompanyAddressRepository;
import gr.com.eurotrade.repository.CompanyRepository;
import gr.com.eurotrade.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	CompanyAddressRepository companyAddressRepository;
	
	@Autowired
	UserRepository userRepository;

	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	public void save(Company company) {
		companyRepository.save(company);
		
	}

	public Company findById(Integer companyId) {
		return companyRepository.findById(companyId);
	}

	public void delete(Company company) {
		companyRepository.delete(company);
	}
	
	public void save(Company company, String username) {
		companyRepository.save(company);
		
	}
	
	public List<Company> findByCountryId(Integer countryId) {
		List<Company> companyList = null;
		companyList = companyRepository.customFindByCountryId(countryId);
		return companyList;	
	}
	

	
	public List<Company> getCompanyList(Integer countryId){
		List<Company> companyList = null;


		if(countryId == null){
			
			System.out.println("getCityList : mpika se ola");
			companyList = companyRepository.findAll();			
		}
		else
		{

			if (countryId != null)
			{
				System.out.println("country findOne");
				//Country country = countryRepository.findOne(countryId);
				System.out.println("mpika sto country");
				companyList = findByCountryId(countryId);						
			}
			
		}
	
		System.out.println("teleiose i getCompanyList");			
	
		return companyList;
	}

	public List<HashMap<String,String>> companyListOfMap(Integer countryId) {
		System.out.println("companyListOfMap : creating single list ...");
		System.out.println("countryId = : " + countryId);

		List<Company> companyList = getCompanyList(countryId);

		List<HashMap<String,String>> companyListOfMap = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> map;
		
		for(Company company : companyList){	 	
			System.out.println("simpleListOfMap [ company id : " + company.getId() + " , company name : " + company.getName() + " ]");
			
			map = new HashMap<String,String>();

			map.put("id",company.getId().toString());
			map.put("name",company.getName());
			map.put("country", company.getCountry().getName());
			map.put("countryId",company.getCountry().getId().toString());

			
			companyListOfMap.add(map);
		}
	
/*		// Debugging..Starts
		
		for(HashMap<String,String> company : simpleListOfMap){

			Iterator it = company.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        it.remove(); // avoids a ConcurrentModificationException
		    }
			
		}
		
		// Debuggin Ends
*/
		return companyListOfMap;

	}

	@Transactional
	public Company findOneWithAddressListAndUserList(Integer id) {
		Company company = findById(id);
		List<CompanyAddress> companyAddressList = companyAddressRepository.findByCompany(company);
		company.setCompanyAddressList(companyAddressList);
	
		List<User> userList = userRepository.findByCompany(company);
		company.setUserList(userList);
	
		return company;
				
	}
	
}
