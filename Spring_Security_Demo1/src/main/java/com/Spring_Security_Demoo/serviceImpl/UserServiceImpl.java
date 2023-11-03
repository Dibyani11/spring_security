package com.Spring_Security_Demoo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring_Security_Demoo.UserDto;
import com.Spring_Security_Demoo.UserService;
import com.Spring_Security_Demoo.entity.User;
import com.Spring_Security_Demoo.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepo userRepo;

	@Override
	public UserDto adduser(UserDto userDto) {

		User user = new User();

		user.setId(userDto.getId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setRole(userDto.getRole());

		User addUser = userRepo.save(user);

		userDto.setId(addUser.getId());
		userDto.setFirstName(addUser.getFirstName());
		userDto.setLastName(addUser.getLastName());
		userDto.setRole(addUser.getRole());

		return userDto;
	}

	@Override
	public UserDto getUserById(long id) {

		UserDto uDTO = new UserDto();

		User checkUser = userRepo.findById(id);
		if (checkUser != null) {

			uDTO.setId(checkUser.getId());
			uDTO.setFirstName(checkUser.getFirstName());
			uDTO.setLastName(checkUser.getLastName());
			uDTO.setRole(checkUser.getRole());

			return uDTO;
		} else
			throw new RuntimeException("User with Id is not present.");
	}

	@Override
	public List<UserDto> getAllUser() {

		List<User> user = userRepo.findAll();
		List<UserDto> allUser = new ArrayList<>();

		for (User savedUser : user) {

			UserDto userDTO = new UserDto();

			userDTO.setId(savedUser.getId());
			userDTO.setFirstName(savedUser.getFirstName());
			userDTO.setLastName(savedUser.getLastName());
			userDTO.setRole(savedUser.getRole());

			allUser.add(userDTO);
		}
		return allUser;
	}

}
