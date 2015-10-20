package gr.com.eurotrade.repository;

import gr.com.eurotrade.entity.Currency;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

	Currency findByName(String name);

	Currency findById(Integer currencyId);

}
