package gr.com.eurotrade.repository;

import gr.com.eurotrade.entity.Country;
import gr.com.eurotrade.entity.Region;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegionRepository extends JpaRepository<Region, Integer> {

	Region findById(Integer regionId);

	List<Region> findByCountry(Country country);

	@Query("SELECT r FROM Region r "
			+ "INNER join r.country co "
			+ "WHERE co.id = :countryId ")
	public List<Region> customFindByCountryId(
			@Param("countryId") Integer countryId);

}
