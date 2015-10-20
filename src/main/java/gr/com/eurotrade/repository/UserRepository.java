package gr.com.eurotrade.repository;

import java.util.List;

import gr.com.eurotrade.entity.Company;
import gr.com.eurotrade.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

	List<User> findByCompany(Company company);


}
