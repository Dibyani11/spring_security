package com.Spring_Security_Demoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring_Security_Demoo.UserDto;
import com.Spring_Security_Demoo.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UserService userService;

	// localhost:8009/user/add
	@PostMapping("/add")
	public UserDto adduser(@RequestBody UserDto userDto) {
		return userService.adduser(userDto);
	}

	// localhost:8009/user/get/2
	@GetMapping("/get/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public UserDto getOneUser(@PathVariable long id) {
		return userService.getUserById(id);
	}

	// localhost:8009/user/getAll
	@GetMapping("/getAll")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<UserDto> getAllUser() {
		return userService.getAllUser();
	}
}
