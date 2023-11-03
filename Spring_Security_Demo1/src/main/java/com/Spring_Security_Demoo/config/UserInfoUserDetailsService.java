package com.Spring_Security_Demoo.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.Spring_Security_Demoo.entity.UserInfo;
import com.Spring_Security_Demoo.repository.UserInfoRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserInfoRepository userInfoRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserInfo> userInfo = userInfoRepo.findByName(username);
		
		return userInfo.map(UserInfoUserDetails :: new)
		.orElseThrow (()-> new UsernameNotFoundException("user is not found" + username) );
	}

}
