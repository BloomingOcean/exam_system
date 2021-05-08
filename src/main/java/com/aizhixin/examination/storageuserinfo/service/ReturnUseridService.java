package com.aizhixin.examination.storageuserinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aizhixin.examination.storageuserinfo.dao.UserInfoDAO;
import com.aizhixin.examination.storageuserinfo.dto.UserInfoDTO;

@Service
@Transactional
public class ReturnUseridService {

	@Autowired
	private UserInfoDAO userInfoDAO;
	
	//存入用户信息
	public void addUserInformation(UserInfoDTO newReturnUseridDTO) {
			
		//添加用户信息到数据库中
		userInfoDAO.add(newReturnUseridDTO);
	}
	
	
}
