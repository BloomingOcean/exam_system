package com.aizhixin.examination.questionBank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aizhixin.examination.commons.core.PageData;
import com.aizhixin.examination.questionBank.dao.BankQuestionDAO;
import com.aizhixin.examination.questionBank.dao.RankQuestionOptionDAO;
import com.aizhixin.examination.questionBank.dto.BankQuestionDTO;
import com.aizhixin.examination.questionBank.dto.QueryTestDomain;

@Service
@Transactional
public class QuestionBankService {
	
	@Autowired
	private BankQuestionDAO bankQuestionDAO;
	@Autowired
	private RankQuestionOptionDAO rankQuestionOptionDAO;
	
	
	/**
	 * 添加试题的逻辑
	 * @param questionDto
	 * @return
	 */
	public BankQuestionDTO add(BankQuestionDTO questionDto) {
		bankQuestionDAO.add(questionDto);
		rankQuestionOptionDAO.add(questionDto.getID(), questionDto.getOptions());
		return questionDto;
	}
	
	/**
	 * 删除试题逻辑
	 * @param id
	 */
	public void delete(String id) {
		int c = bankQuestionDAO.delete(id);
		if (c > 0) {
			rankQuestionOptionDAO.delete(id);
		}
	}
	
	/**
	 * 修改试题逻辑
	 * @param questionDto
	 * @return
	 */
	public BankQuestionDTO update(BankQuestionDTO questionDto) {
		bankQuestionDAO.update(questionDto);
		rankQuestionOptionDAO.update(questionDto.getID(), questionDto.getOptions());
		return questionDto;
	}
	
	/**
	 * 分页查询
	 * @param domain
	 * @return
	 */
	public PageData<BankQuestionDTO> getTestPage(
			QueryTestDomain domain) {
		return bankQuestionDAO.getTestPage(domain);
	}
}
