package gr.com.eurotrade.service;

import gr.com.eurotrade.entity.Blog;
import gr.com.eurotrade.entity.User;
import gr.com.eurotrade.repository.BlogRepository;
import gr.com.eurotrade.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private UserRepository userRepository;
		
	public void save(Blog blog, String name) {
		User user = userRepository.findByUsername(name);
		blog.setUser(user);
//		System.out.println("BlogService save");
		blogRepository.save(blog);
	}
	
	@PreAuthorize("#blog.user.username == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		blogRepository.delete(blog);
	}

	public Blog findOne(int id) {
		Blog blog = blogRepository.findOne(id);
		return blog;
	}

}
