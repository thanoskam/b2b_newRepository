package gr.com.eurotrade.repository;

import gr.com.eurotrade.entity.Country;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {

	Country findByName(String name);

	Country findByCode(String code);

}
