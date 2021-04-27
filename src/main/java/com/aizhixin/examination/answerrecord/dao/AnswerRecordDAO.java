package com.aizhixin.examination.answerrecord.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.aizhixin.examination.answerrecord.dto.RecordQuestionDTO;
import com.aizhixin.examination.question.dto.QuestionOptionDTO;

@Component
public class AnswerRecordDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 查询用户详细总答题记录
	 * @return
	 */
	public List<RecordQuestionDTO> findAnswers0(){
		RowMapper<QuestionOptionDTO> optionrowMapper=new BeanPropertyRowMapper<QuestionOptionDTO>(QuestionOptionDTO.class);
		RowMapper<RecordQuestionDTO>rowMapper=new BeanPropertyRowMapper<RecordQuestionDTO>(RecordQuestionDTO.class);
		String questionSql ="SELECT Q.ID, Q.CONTENT,Q.ANSWER,Q.KNOWLEDGE_AREA,S.submit_Answers,S.answer_time\r\n" + 
				"FROM `t_question` AS Q\r\n" + 
				"INNER JOIN `answer_record`AS S\r\n" + 
				"ON Q.ID=S.topicID";
		String optionSql = "SELECT `OPTION`,OPTION_CONTENT FROM t_question_option WHERE QUESTION_ID = ?";
		List<RecordQuestionDTO> findAnswer = jdbcTemplate.query(questionSql, rowMapper);
		for(RecordQuestionDTO f : findAnswer) {
			f.setQuestionOptions(jdbcTemplate.query(optionSql, optionrowMapper,f.getId()));
		}
		jdbcTemplate.query(optionSql,rowMapper);
		return findAnswer;
	}
	
	/**
	 * 查询用户答对题目
	 */
	
	public List<RecordQuestionDTO> findAnswers1 (){
		RowMapper<QuestionOptionDTO> optionrowMapper=new BeanPropertyRowMapper<QuestionOptionDTO>(QuestionOptionDTO.class);
		RowMapper<RecordQuestionDTO>rowMapper=new BeanPropertyRowMapper<RecordQuestionDTO>(RecordQuestionDTO.class);
		String questionSql ="SELECT  Q.CONTENT,Q.ANSWER,Q.KNOWLEDGE_AREA,S.submit_Answers,S.answer_time\r\n" + 
				"FROM `t_question` AS Q\r\n" + 
				"INNER JOIN `answer_record`AS S\r\n" + 
				"ON Q.ID=S.topicID AND Q.ANSWER=S.submit_Answers";
		String optionSql = "SELECT `OPTION`,OPTION_CONTENT FROM t_question_option WHERE QUESTION_ID = ?";
		List<RecordQuestionDTO> findAnswer = jdbcTemplate.query(questionSql, rowMapper);
		for(RecordQuestionDTO f : findAnswer) {
			f.setQuestionOptions(jdbcTemplate.query(optionSql, optionrowMapper,f.getId()));
		}
		return findAnswer;
	}
	
	/**
	 * 查询答错的题目
	 * @return
	 */
	public List<RecordQuestionDTO> findAnswers2(){
		RowMapper<QuestionOptionDTO> optionrowMapper=new BeanPropertyRowMapper<QuestionOptionDTO>(QuestionOptionDTO.class);
		RowMapper<RecordQuestionDTO>rowMapper=new BeanPropertyRowMapper<RecordQuestionDTO>(RecordQuestionDTO.class);
		String questionSql ="SELECT  Q.CONTENT,Q.ANSWER,Q.KNOWLEDGE_AREA,S.submit_Answers,S.answer_time\r\n" + 
				"FROM `t_question` AS Q\r\n" + 
				"INNER JOIN `answer_record`AS S\r\n" + 
				"ON Q.ID=S.topicID AND Q.ANSWER!=S.submit_Answers";
		String optionSql = "SELECT `OPTION`,OPTION_CONTENT FROM t_question_option WHERE QUESTION_ID = ?";
		List<RecordQuestionDTO> findAnswer = jdbcTemplate.query(questionSql, rowMapper);
		for(RecordQuestionDTO f : findAnswer) {
			f.setQuestionOptions(jdbcTemplate.query(optionSql, optionrowMapper,f.getId()));
		}
		return findAnswer;
	}

}
