package com.jmango360.server.core.components.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jmango360.server.core.components.entities.User;
import com.jmango360.server.core.components.repositories.jpa.UserRespository;
import com.jmango360.server.model.MobileAccount;

@Transactional(propagation = Propagation.REQUIRED)
@Service("userService")
public class UserDomainServiceImp implements UserDomainService {

	private static final Logger log = LoggerFactory
			.getLogger(UserDomainServiceImp.class);

	@Autowired
	private UserRespository userRespository;

	@Override
	public void add(MobileAccount entity) {

		User user = new User(entity);
		userRespository.save(user);
	}

	@Override
	public MobileAccount get(Long id) {

		User user = userRespository.findOne(id);

		MobileAccount account = new MobileAccount();

		account.setUsername(user.getUsername());
		account.setPassword(user.getPassword());
		account.setEmail(user.getEmail());
		account.setFirstName(user.getFirstName());
		account.setLastName(user.getLastName());

		return account;
	}

	@Override
	public void delete(Long id) {
		userRespository.delete(id);
	}

	@Override
	public void update(MobileAccount entity) {

		User user = new User(entity);

		userRespository.save(user);
	}

	@Override
	public boolean doesEntityExist(Long id) {
		return userRespository.exists(id);
	}

}
