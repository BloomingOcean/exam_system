package com.aizhixin.examination.question.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.aizhixin.examination.question.dto.QuestionOptionDTO;

@Component
public class QuestionOptionDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 根据题目ID，查询对应此题目的选项
	 * 
	 * @param id
	 * @return
	 */
	public List<QuestionOptionDTO> findOneQuestionId(String id) {

		// RowMapper怎么用
		// BeanPropertyRowMapper怎么用
		// (QuestionOptionDTO.class)后面这一堆什么意思
		RowMapper<QuestionOptionDTO> rowMapper = new BeanPropertyRowMapper<QuestionOptionDTO>(QuestionOptionDTO.class);

		final String sql = "SELECT ID, OPTION_CONTENT, `OPTION` FROM  t_question_option WHERE QUESTION_ID = ?";
		return jdbcTemplate.query(sql, rowMapper, id);
	}
}
