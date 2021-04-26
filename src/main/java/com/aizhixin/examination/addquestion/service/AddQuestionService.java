package com.aizhixin.examination.addquestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aizhixin.examination.addquestion.dao.AddQuestionDAO;
import com.aizhixin.examination.addquestion.dto.AddQuestionDTO;

@Service
@Transactional
public class AddQuestionService {

	@Autowired
	private AddQuestionDAO addQuestionDAO;
	
	public boolean addQuestion(AddQuestionDTO dto) {
		try {
			addQuestionDAO.add(dto);
			addQuestionDAO.addOption(addQuestionDAO.findId(dto).getQuestionId(), dto.getOptionContent());
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
}
