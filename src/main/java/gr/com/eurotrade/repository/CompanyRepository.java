package gr.com.eurotrade.repository;

import gr.com.eurotrade.entity.Company;
import gr.com.eurotrade.entity.Country;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	Company findById(Integer companyId);

	List<Company> findByCountry(Country country);

	@Query("SELECT c FROM Company c "
			+ "INNER join c.country co "
			+ "WHERE co.id = :countryId ")
	public List<Company> customFindByCountryId(
			@Param("countryId") Integer countryId);

	
}
