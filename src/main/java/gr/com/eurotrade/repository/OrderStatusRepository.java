package gr.com.eurotrade.repository;

import gr.com.eurotrade.entity.OrderStatus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {

}
