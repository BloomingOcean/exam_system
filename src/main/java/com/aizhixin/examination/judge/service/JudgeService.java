package com.aizhixin.examination.judge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aizhixin.examination.judge.dao.JudgeDAO;
import com.aizhixin.examination.judge.dto.AnswerAllDTO;
import com.aizhixin.examination.judge.dto.AnswerDailyDTO;
import com.aizhixin.examination.judge.dto.AnswerRecordDTO;
import com.aizhixin.examination.judge.dto.ExistAnswerAllDTO;
import com.aizhixin.examination.judge.dto.InputDTO;
import com.aizhixin.examination.score.service.ScoreService;

/**
 * 
 * @author Gentle
 *
 */
@Service
@Transactional
public class JudgeService {

	@Autowired
	private JudgeDAO judgeDAO;

	@Autowired
	private ScoreService scoreService;

	// 构建不同对象的框架
	AnswerAllDTO answerAllDTO = new AnswerAllDTO();
	AnswerDailyDTO answerDailyDTO = new AnswerDailyDTO();
	AnswerRecordDTO answerRecordDTO = new AnswerRecordDTO();
	ExistAnswerAllDTO existAnswerAllDTO = new ExistAnswerAllDTO();

	/**
	 * 通过judgeDTO的userid返回此人的总分
	 * 
	 * @param judgeDTO
	 * @return
	 */
	public int returnScore(InputDTO dto) {
		// 1为true 0为false
		if (dto.getJudgeAnswer() == 1) {
			// 把前端传入的数据传给答题记录表
			answerRecordDTO.setQuestionId(dto.getQuestionId());
			answerRecordDTO.setUserID(dto.getUserId());
			answerRecordDTO.setSubmitAnswer(dto.getUserAnswer());
			answerRecordDTO.setRightAnswer(dto.getRightAnswer());
			answerRecordDTO.setAnswerjudge(dto.getJudgeAnswer());
			answerRecordDTO.setKnowledgeRange(dto.getKnowledgeRange());
			answerRecordDTO.setQuestionScore(2);

			// 添加一条用户回答正确的答题记录
			judgeDAO.addAnswerRecord(answerRecordDTO);

			// 判断在库中是否有这个用户的记录（答题记录总表）
			if (judgeDAO.queryUserid(dto) == null) {
				// 在答题记录总表中初始化一条该用户的答题总分记录
				judgeDAO.addAnswerAll(answerAllDTO);
			}

			// 做题正确在answer_all表中加分（答题记录总表）
			judgeDAO.correctUpdateAnswerAll(dto);

			// 判断在库中是否有这个用户的每日答题分数表（每日答题分数表）
			if (judgeDAO.queryCreatTime(dto) == null) {
				// 在每日答题分数表中初始化一条该用户的每日答题分数记录
				judgeDAO.addAnswerDaily(answerDailyDTO, dto);
			}

			// 做题正确在answer_daliy表中加分（每日答题分数表）
			judgeDAO.correctUpdateAnswerDaily(dto);

		} else {
			answerRecordDTO.setQuestionId(dto.getQuestionId());
			answerRecordDTO.setUserID(dto.getUserId());
			answerRecordDTO.setSubmitAnswer(dto.getUserAnswer());
			answerRecordDTO.setRightAnswer(dto.getRightAnswer());
			answerRecordDTO.setAnswerjudge(dto.getJudgeAnswer());
			answerRecordDTO.setKnowledgeRange(dto.getKnowledgeRange());
			answerRecordDTO.setQuestionScore(-1);

			// 添加一条用户回答错误的答题记录
			judgeDAO.addAnswerRecord(answerRecordDTO);

			// 判断在库中是否有这个用户的记录
			if (judgeDAO.queryUserid(dto) == null) {
				// 在答题记录总表中添加一条该用户的答题记录
				judgeDAO.addAnswerAll(answerAllDTO);
			}

			//如果用户的总分不为0
			if(scoreService.getById(dto.getUserId()).getAll_Score() != 0) {
				// 做题错误在answer_all表中减分
				judgeDAO.incorrectUpdateAnswerAll(dto);
			}

			// 如果没有此用户的每日答题记录表，就添加
			if (judgeDAO.queryCreatTime(dto) == null) {
				judgeDAO.addAnswerDaily(answerDailyDTO, dto);
			}
			
			//如果用户的总分不为0
			if(scoreService.getById(dto.getUserId()).getAll_Score() != 0) {
				// 做题错误在answer_daliy表中减分
				judgeDAO.incorrectUpdateAnswerDaily1(dto);
			}
			//用户的总分为0
			else {
				// 做题错误在answer_daliy表中减分（不减总分）
				judgeDAO.incorrectUpdateAnswerDaily2(dto);
			}
		}
		// 返回用户答题之后的分数
		return scoreService.getById(dto.getUserId()).getAll_Score();
	}

}
