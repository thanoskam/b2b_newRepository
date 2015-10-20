package gr.com.eurotrade.repository;

import gr.com.eurotrade.entity.ProductPart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPartRepository extends JpaRepository<ProductPart, Integer> {

}
