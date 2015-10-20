package gr.com.eurotrade.repository;

import gr.com.eurotrade.entity.OperationType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTypeRepository extends JpaRepository<OperationType
, Integer> {

}
