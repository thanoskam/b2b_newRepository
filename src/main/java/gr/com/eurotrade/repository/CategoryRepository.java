package gr.com.eurotrade.repository;

import gr.com.eurotrade.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
