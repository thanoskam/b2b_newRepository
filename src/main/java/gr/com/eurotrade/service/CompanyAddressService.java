package gr.com.eurotrade.service;

import gr.com.eurotrade.entity.CompanyAddress;
import gr.com.eurotrade.repository.CompanyAddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CompanyAddressService {

	@Autowired
	CompanyAddressRepository companyAddressRepository;
	
	public void save(CompanyAddress companyAddress) {
		companyAddressRepository.save(companyAddress);
	}

}
