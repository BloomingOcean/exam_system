package com.aizhixin.examination.daily.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aizhixin.examination.daily.dao.DailyDao;
import com.aizhixin.examination.daily.dto.DailyDto;
@Service
@Transactional
public class DailyService {
	@Autowired
	private DailyDao dailyDao;
	
	@Transactional (readOnly = true)
	public List<DailyDto> userInfo(int USER_ID) {
		
		//通过userid获取用户的信息
		List<DailyDto> Dto = dailyDao.getInfo(USER_ID);
		return Dto;
	}
}
