package com.Spring_Security_Demoo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Spring_Security_Demoo.entity.UserInfo;
import com.Spring_Security_Demoo.repository.UserInfoRepository;

@Service
public class UserInfoServiceImpl {

	@Autowired
	private UserInfoRepository userInfoRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String addUserInfo(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepo.save(userInfo);
		return "User added to system";
	}
}
