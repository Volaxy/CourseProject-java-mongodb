package com.volaxxy.cpjavamongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volaxxy.cpjavamongodb.domain.User;
import com.volaxxy.cpjavamongodb.dto.UserDTO;
import com.volaxxy.cpjavamongodb.repositories.UserRepository;
import com.volaxxy.cpjavamongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found! :("));
	}
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(User user) {
		Optional<User> newUser = userRepository.findById(user.getId());
		
		updateData(newUser, user);
		
		return userRepository.save(newUser.get());
	}

	private void updateData(Optional<User> newUser, User user) {
		newUser.get().setName(user.getName());
		newUser.get().setEmail(user.getEmail());
	}

}
