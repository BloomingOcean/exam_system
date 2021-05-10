package com.aizhixin.examination.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.aizhixin.examination.commons.dao.InOpenidDAO;
import com.aizhixin.examination.commons.vo.UserIDDTO;

@Component
@Transactional
public class InOpenidService {

 	@Autowired
    private InOpenidDAO inOpenidDAO;
 	
// 	@Autowired
//  private OpenidDTO openidDTO;
	
	public UserIDDTO returnUserId(String openid) {
		
		if(inOpenidDAO.foundOpenid(openid) == null)
		{
		//添加Openid
		inOpenidDAO.add(openid);
		}
		
		//查找userid
		return inOpenidDAO.useridByOpenid(openid);
	}
	
	
	
	
	
	
}
