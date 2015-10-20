package gr.com.eurotrade.annotation;

import gr.com.eurotrade.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String>{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		// this condition is useful only for development environment
		if(userRepository == null) {
			return true;
		}
		return userRepository.findByUsername(username) == null;
	}

}
