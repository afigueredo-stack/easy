package com.afigueredo.easy.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afigueredo.easy.dto.UserDto;
import com.afigueredo.easy.entity.User;
import com.afigueredo.easy.response.Response;
import com.afigueredo.easy.service.UserService;

@RestController
@RequestMapping(value = "/easy/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	public static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	public UserController() {}

	/**
	 * Retorna um usuario 
	 * 
	 * @param id
	 * @return ResponseEntity<Response<UserDto>>
	 */
	@GetMapping(value = "/get-user/{id}")
	public ResponseEntity<Response<UserDto>> findingUserById(@PathVariable("id") Long id) {
		Response<UserDto> response = new Response<UserDto>();
		Optional<User> user = userService.findByIdentify(id);
		
		if(!user.isPresent()) {
			log.info("Usuário não localizado nesse id: {}", id);
			response.getErrors().add("Usuário não localizado nesse id: " + id);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(this.transformUserInUserDto(user.get()));
		
		
		return ResponseEntity.ok(response);
	}
	
	private UserDto transformUserInUserDto(User user) {
		UserDto userDto = new UserDto();
		
		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setFullname(user.getFullname());
		userDto.setEmail(user.getEmail());
		userDto.setPhone(user.getPhone());
		userDto.setPassword(user.getPassword());
		userDto.setIdParameter(user.getParameter());
		
		return userDto;
	}
	
}

	












