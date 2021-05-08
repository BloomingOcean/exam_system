package com.aizhixin.examination.question.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aizhixin.examination.question.dao.QuestionDAO;
import com.aizhixin.examination.question.dto.QuestionDTO;
import com.aizhixin.examination.question.dao.QuestionOptionDAO;

@Service
@Transactional
public class QuestionService {
	@Autowired
	private QuestionDAO questionDao;
	@Autowired
	private QuestionOptionDAO questionOptionDAO;

	@Transactional(readOnly = true)
	public QuestionDTO getByRandom(int questionIdSubscript) {
		QuestionDTO questionDTO = questionDao.findOneQuestion(questionIdSubscript);

		// 如果题目题干不为空，则获取题目选项
		if (null != questionDTO) {
			questionDTO.setOptions(questionOptionDAO.findOneQuestionId(questionDTO.getId()));
		}
		return questionDTO;
	}
}
