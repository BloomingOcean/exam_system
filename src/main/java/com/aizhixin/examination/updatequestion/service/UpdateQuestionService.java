package com.aizhixin.examination.updatequestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aizhixin.examination.updatequestion.dao.UpdateQuestionDAO;
import com.aizhixin.examination.updatequestion.dto.UpdateQuestionDTO;

@Service
@Transactional
public class UpdateQuestionService {

	@Autowired
	private UpdateQuestionDAO updateQuestionDAO;
	
	/**
	 * 
	 */
	public boolean updateQuestion(UpdateQuestionDTO dto) {
		try {
			updateQuestionDAO.updateQuestion(dto);
			updateQuestionDAO.updateOption(dto.getQuestionID(), dto.getOptions());
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
}
