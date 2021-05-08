package com.aizhixin.examination.score.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aizhixin.examination.score.dao.ScoreDAO;
import com.aizhixin.examination.score.dto.ScoreDTO;

@Service
@Transactional
public class ScoreService {

	@Autowired
	private ScoreDAO scoreDao;

	/**
	 * 查询到用户分数之后返回封装了分数的那个对象
	 * @param userID
	 * @return
	 */
	@Transactional (readOnly = true)
	public ScoreDTO getById(Integer userID) {
		
		//根据userid查询分数并返回给DTO
		ScoreDTO scoreDto = scoreDao.findById(userID);
		return scoreDto;
	}

}

