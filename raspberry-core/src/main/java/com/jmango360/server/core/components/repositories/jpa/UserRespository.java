package com.jmango360.server.core.components.repositories.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jmango360.server.core.components.entities.User;

public interface UserRespository extends CrudRepository<User, Long>,
		UserRepositoryCustom {
	
	List<User> findByUsername(String username);
}
