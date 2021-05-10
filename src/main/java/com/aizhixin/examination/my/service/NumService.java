package com.aizhixin.examination.my.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aizhixin.examination.my.dao.NumDAO;
import com.aizhixin.examination.my.dto.NumDTO;

@Service
@Transactional
public class NumService {
	@Autowired
	private NumDAO numDao;

	/**
	 * 通过userID这个参数返回用户答题总分的对象
	 * 
	 * @param userID
	 * @return numDto封装的用户答题总分的数据
	 */
	@Transactional(readOnly = true)
	public NumDTO getByUserId(int userID) {
		NumDTO numDto = numDao.findByUserId(userID);
		return numDto;
	}
}
