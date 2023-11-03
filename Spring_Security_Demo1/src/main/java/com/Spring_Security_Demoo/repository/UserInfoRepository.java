 package com.Spring_Security_Demoo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring_Security_Demoo.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{

	Optional<UserInfo> findByName(String username);

}
