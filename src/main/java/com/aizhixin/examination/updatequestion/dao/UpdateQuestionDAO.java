package com.aizhixin.examination.updatequestion.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.aizhixin.examination.updatequestion.dto.UpdateQuestionOptionDTO;
import com.aizhixin.examination.updatequestion.dto.UpdateQuestionDTO;

@Component
public class UpdateQuestionDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 根据questionId查询题目
	 * 
	 * @param questionId：查找questionID
	 * @return 
	 */
	public UpdateQuestionDTO findOneQuestion(int questionId) {
		RowMapper<UpdateQuestionDTO> rowMapper = new BeanPropertyRowMapper<UpdateQuestionDTO>(UpdateQuestionDTO.class);
		String sql = "SELECT * FROM t_question" + 
				" WHERE ID=?";
		return jdbcTemplate.queryForObject(sql, rowMapper, questionId);
	}
	
	
	/**
	 * 根据题目ID，查询对应此题目的选项
	 * 
	 * @param id
	 * @return
	 */
	public List<UpdateQuestionOptionDTO> findOneQuestionId(String id) {

		// RowMapper怎么用
		// BeanPropertyRowMapper怎么用
		// (QuestionOptionDTO.class)后面这一堆什么意思
		RowMapper<UpdateQuestionOptionDTO> rowMapper = new BeanPropertyRowMapper<UpdateQuestionOptionDTO>(UpdateQuestionOptionDTO.class);

		final String sql = "SELECT ID, OPTION_CONTENT, `OPTION` FROM  t_question_option WHERE QUESTION_ID = ?";
		return jdbcTemplate.query(sql, rowMapper, id);
	}
	
	
	/**
	 * 修改题干
	 * @param dto
	 * @return
	 */
	public UpdateQuestionDTO updateQuestion(UpdateQuestionDTO dto) {
        final String sql = "UPDATE  t_question SET CONTENT = ?, ANSWER = ?, KNOWLEDGE_AREA = ? WHERE ID = ?";
        jdbcTemplate.update(sql,  
                new Object[] {dto.getContent(), dto.getAnswer(), dto.getKNOWLEDGEAREA(), dto.getQuestionID()},
                new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR}
                );
        return dto;
    }
	
	
	/**
	 * 修改题目选项
	 * @param testId
	 * @param dtos
	 * @return
	 */
	public int updateOption(Integer questionId, final List<UpdateQuestionOptionDTO> dtos) {
        final String sql = "UPDATE  t_question_option SET OPTION_CONTENT = ?, `OPTION` = ?, QUESTION_ID = ? WHERE ID = ?";

        //批量修改
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
        	@Override
        	public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, dtos.get(i).getOPTIONCONTENT());
                ps.setString(2, dtos.get(i).getOption());
                ps.setInt(3, questionId);
                ps.setLong(4, dtos.get(i).getQuestionID());
			}
			@Override
			public int getBatchSize() {
				return dtos.size();
			}
        });
        
        return dtos.size();
    }
	
	
	
	
	
	
	
	
	
	
	
	
}
