package gr.com.eurotrade.repository;

import java.util.List;

import gr.com.eurotrade.entity.Blog;
import gr.com.eurotrade.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	
	List<Blog> findByUser(User user);

	
}
