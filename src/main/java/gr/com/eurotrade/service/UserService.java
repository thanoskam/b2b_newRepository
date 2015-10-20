package gr.com.eurotrade.service;

import java.util.ArrayList;
import java.util.List;

import gr.com.eurotrade.entity.Blog;
import gr.com.eurotrade.entity.Country;
import gr.com.eurotrade.entity.Item;
import gr.com.eurotrade.entity.Role;
import gr.com.eurotrade.entity.User;
import gr.com.eurotrade.repository.BlogRepository;
import gr.com.eurotrade.repository.CountryRepository;
import gr.com.eurotrade.repository.ItemRepository;
import gr.com.eurotrade.repository.RoleRepository;
import gr.com.eurotrade.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BlogRepository blogRepositoy;
	
	@Autowired
	private ItemRepository itemReposity;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Autowired
	private CountryRepository countryRepository;
	
	public User findOne(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithblogList(int id) {
		User user = findOne(id);
		List<Blog> blogList = blogRepositoy.findByUser(user);
		for (Blog blog : blogList) {
			List<Item> items = itemReposity.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItemList(items);
		}
		user.setBlogList(blogList);
		return user;
	}

	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));

		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoleList(roles);
	
		userRepository.save(user);
	}

	public User findOneWithblogList(String username) {
		User user = userRepository.findByUsername(username);
		return findOneWithblogList(user.getId());
	}

	public void delete(int id) {
//		System.out.println(">>>>>>>>>>> UserService delete(int id) : id = " + id + " <<<<<<<<<<<<< (before)");
		userRepository.delete(id);
//		System.out.println(">>>>>>>>>>> UserService delete(int id) : id = " + id + " <<<<<<<<<<<<< (after)");
	}

	public User findOne(String username) {
		return userRepository.findByUsername(username);
	}

	@Transactional
	public User findOneWithRoles(String username) {
		User user = userRepository.findByUsername(username);
		
		List<Role> roles = new ArrayList<Role>();
		for (Role role : user.getRoleList()){
		  roles.add(roleRepository.findOne(role.getId()));
		}
		user.setRoleList(roles);
		return user;
	}

	public Country findCountryByUsername(String name) {
		User user = userRepository.findByUsername(name);
		String countryCode = user.getCompany().getCountry().getCode();
		Country country = countryRepository.findByCode(countryCode); 
		return country;
	}
}
