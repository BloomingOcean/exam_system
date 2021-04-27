package com.aizhixin.examination.answerrecord.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aizhixin.examination.answerrecord.dao.AnswerRecordDAO;
import com.aizhixin.examination.answerrecord.dto.RecordQuestionDTO;

@Service
@Transactional
public class AnswerRecordService {

	@Autowired
	private AnswerRecordDAO answerRecordDao;
	/**
	 * 查询答题详细记录
	 * @version:V0.1
	 */
	public List<RecordQuestionDTO> findAnswers(int judge) {
		//查询用户详细总答题记录
		if (judge == 0) {
			return answerRecordDao.findAnswers0();
		}
		//查询用户答对题目
		if (judge == 1) {
			return answerRecordDao.findAnswers1();
		}
		//查询答错的题目
		if (judge == 2) {
			return answerRecordDao.findAnswers2();
		}

		return null;
	}

}
