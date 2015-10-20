package gr.com.eurotrade.repository;

import java.util.List;

import gr.com.eurotrade.entity.Blog;
import gr.com.eurotrade.entity.Item;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findByBlog(Blog blog, Pageable pageable);
}
