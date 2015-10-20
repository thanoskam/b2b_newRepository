package gr.com.eurotrade.repository;

import gr.com.eurotrade.entity.Region;
import gr.com.eurotrade.entity.State;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StateRepository extends JpaRepository<State, Integer> {

	State findById(Integer stateId);

	State findByRegion(Region region);

	@Query("SELECT s FROM State s "
			+ "INNER join s.region r "
			+ "INNER join r.country co "
			+ "WHERE co.id = :countryId ")
	public List<State> customFindByCountryId(@Param("countryId") Integer countryId);

	@Query("SELECT s FROM State s "
			+ "INNER join s.region r "
			+ "WHERE r.id = :regionId ")
	public List<State> customFindByRegionId(@Param("regionId") Integer regionId);

	@Query("SELECT s FROM State s "
			+ "INNER join s.region r "
			+ "INNER join r.country co "
			+ "WHERE co.id = :countryId and "
			+ "r.id = :regionId ")
	public List<State> customFindByCountryIdAndRegionId(
			@Param("countryId") Integer countryId,
			@Param("regionId") Integer regionId);


	
}
