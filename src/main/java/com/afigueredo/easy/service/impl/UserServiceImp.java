package com.afigueredo.easy.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afigueredo.easy.entity.User;
import com.afigueredo.easy.reposity.UserReposity;
import com.afigueredo.easy.service.UserService;

@Service
public class UserServiceImp implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImp.class);
	
	@Autowired
	private UserReposity userReposity; 
	
	@Override
	public Optional<User> findByUsername(String username) {
		log.info("Localizando usuario pelo 'username': {}", username);
		
		return Optional.ofNullable(this.userReposity.findByUsername(username));
	}
	
	@Override
	public Optional<User> findByIdentify(Long id) {
		log.info("Localizando usuario pelo 'id': {}", id);
		
		return this.userReposity.findById(id);
	}
	
	@Override
	public User persist(User user) {
		log.info("Persistindo usuario: {}", user);
		
		return this.userReposity.save(user);
	}
}
