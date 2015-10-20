package gr.com.eurotrade.repository;

import gr.com.eurotrade.entity.Delay;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DelayRepository extends JpaRepository<Delay, Integer> {

}
