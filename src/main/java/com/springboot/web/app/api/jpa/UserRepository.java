package com.springboot.web.app.api.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.springboot.web.app.api.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findByRole(String Role);
	
	Iterable<User> findAll();
	
	Optional<User> findById(Long userId);
	
	@SuppressWarnings("unchecked")
	User save(User user);
	
	void delete(User entity);

}
