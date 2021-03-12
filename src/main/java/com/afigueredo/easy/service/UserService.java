package com.afigueredo.easy.service;

import java.util.Optional;

import com.afigueredo.easy.entity.User;

public interface UserService {
	
	/**
	 * Retorna um usuário pelo username
	 * 
	 * @param username
	 * @return Optinal<User>
	 */
	Optional<User> findByUsername(String username);
	
	/**
	 * Retorna um usuário pelo id
	 * 
	 * @param id
	 * @return Optinal<User>
	 */
	Optional<User> findByIdentify(Long id);

	/**
	 * Persiste um usuario no banco de dados
	 * 
	 * @param user
	 * @return User
	 */
	User persist(User user);
}
