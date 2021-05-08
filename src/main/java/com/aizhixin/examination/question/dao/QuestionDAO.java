package com.aizhixin.examination.question.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.aizhixin.examination.question.dto.QuestionDTO;

@Component
public class QuestionDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 查询questionIdSubscript此下标下的问题
	 * 
	 * @param questionIdSubscript：查找的下标
	 * @return
	 */
	public QuestionDTO findOneQuestion(int questionIdSubscript) {
		RowMapper<QuestionDTO> rowMapper = new BeanPropertyRowMapper<QuestionDTO>(QuestionDTO.class);
		String sql = "SELECT ID, CONTENT,ANSWER,KNOWLEDGE_AREA  FROM  `t_question`  LIMIT ?, 1;";
		return jdbcTemplate.queryForObject(sql, rowMapper, questionIdSubscript);
	}

}
