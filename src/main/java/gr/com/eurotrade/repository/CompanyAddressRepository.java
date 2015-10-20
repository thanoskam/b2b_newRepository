package gr.com.eurotrade.repository;

import java.util.List;

import gr.com.eurotrade.entity.Company;
import gr.com.eurotrade.entity.CompanyAddress;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyAddressRepository extends JpaRepository<CompanyAddress, Integer> {

	List<CompanyAddress> findByCompany(Company company);

}
