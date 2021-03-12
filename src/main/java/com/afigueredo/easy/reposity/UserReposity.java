package com.afigueredo.easy.reposity;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afigueredo.easy.entity.User;

public interface UserReposity extends JpaRepository<User, Long> {

	
	@Transactional
	User findByUsername(String username);

}
