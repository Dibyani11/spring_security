package com.Spring_Security_Demoo;

import java.util.List;

public interface UserService {

	public UserDto adduser(UserDto userDto);

	public UserDto getUserById(long id);

	public List<UserDto> getAllUser();

}
