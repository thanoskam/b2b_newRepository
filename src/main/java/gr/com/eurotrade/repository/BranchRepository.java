package gr.com.eurotrade.repository;

import gr.com.eurotrade.entity.Branch;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

	Branch findById(Integer id);

}
