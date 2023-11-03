package com.Spring_Security_Demoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring_Security_Demoo.entity.UserInfo;
import com.Spring_Security_Demoo.serviceImpl.UserInfoServiceImpl;

@RestController
public class UserInfoController {

	@Autowired
	private UserInfoServiceImpl infoService;
	
	//localhost:8009/newInfo
	@PostMapping("/newInfo")
	public String UserInfoAdding(@RequestBody UserInfo userInfo) {
		return infoService.addUserInfo(userInfo);
	}
}
