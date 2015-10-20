package gr.com.eurotrade.service;

import gr.com.eurotrade.repository.BrandRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

	@Autowired
	private BrandRepository brandRepository;
	
	public Object findAll() {
		return brandRepository.findAll();
	}

}
