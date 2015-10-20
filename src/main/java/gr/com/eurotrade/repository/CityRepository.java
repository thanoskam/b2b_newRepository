package gr.com.eurotrade.repository;

import gr.com.eurotrade.entity.City;
import gr.com.eurotrade.entity.State;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends JpaRepository<City, Integer> {

	City findById(Integer cityId);

	List<City> findByState(State findOne);

	@Query("SELECT c FROM City c "
			+ "INNER JOIN c.state s "
			+ "INNER join s.region r "
			+ "INNER join r.country co "
			+ "WHERE co.id = :countryId ")
	public List<City> customFindByCountryId(@Param("countryId") Integer countryId);

	@Query("SELECT c FROM City c "
			+ "INNER JOIN c.state s "
			+ "INNER join s.region r "
			+ "WHERE r.id = :regionId ")
	public List<City> customFindByRegionId(@Param("regionId") Integer regionId);

	@Query("SELECT c FROM City c "
			+ "INNER JOIN c.state s "
			+ "WHERE s.id = :stateId ")
	public List<City> customFindByStateId(@Param("stateId") Integer stateId);
	
	@Query("SELECT c FROM City c "
			+ "INNER JOIN c.state s "
			+ "INNER join s.region r "
			+ "INNER join r.country co "
			+ "WHERE co.id = :countryId and "
			+ "r.id = :regionId ")
	public List<City> customFindByCountryIdAndRegionId(
			@Param("countryId") Integer countryId,
			@Param("regionId") Integer regionId);

	@Query("SELECT c FROM City c "
			+ "INNER JOIN c.state s "
			+ "INNER join s.region r "
			+ "INNER join r.country co "
			+ "WHERE co.id = :countryId and "
			+ "s.id = :stateId ")
	public List<City> customFindByCountryIdAndStateId(
			@Param("countryId") Integer countryId,
			@Param("stateId") Integer stateId);

	@Query("SELECT c FROM City c "
			+ "INNER JOIN c.state s "
			+ "INNER join s.region r "
			+ "WHERE r.id = :regionId and "
			+ "s.id = :stateId ")
	public List<City> customFindByRegionIdAndStateId(
			@Param("regionId") Integer regionId,
			@Param("stateId") Integer stateId);

	@Query("SELECT c FROM City c "
			+ "INNER JOIN c.state s "
			+ "INNER join s.region r "
			+ "INNER join r.country co "
			+ "WHERE co.id = :countryId and "
			+ "r.id = :regionId and "
			+ "s.id = :stateId ")
	public List<City> customFindByCountryIdAndRegionIdAndStateId(
			@Param("countryId") Integer countryId,
			@Param("regionId") Integer regionId,
			@Param("stateId") Integer stateId);

	
}
