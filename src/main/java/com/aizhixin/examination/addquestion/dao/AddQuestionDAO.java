package com.aizhixin.examination.addquestion.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.aizhixin.examination.addquestion.dto.AddQuestionDTO;
import com.aizhixin.examination.addquestion.dto.AddQuestionIdDTO;
import com.aizhixin.examination.addquestion.dto.AddQuestionOptionDTO;

@Component
public class AddQuestionDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 添加题目
	 * @param dto
	 * @return
	 */
	public void add(AddQuestionDTO dto) {
        final String sql = "INSERT INTO  t_question (CONTENT, ANSWER, KNOWLEDGE_AREA) VALUES (?, ?, ?)";
       
        jdbcTemplate.update(sql,  
                dto.getContent(), dto.getAnswer(), dto.getKonwledgeArea());
        
      //  return dto;
    }
	
	
	/**
	 * 根据题目内容查找questionID
	 * @param id
	 * @return
	 */
	public AddQuestionIdDTO findId (AddQuestionDTO dto) {
		final String sql = "SELECT ID FROM t_question" + 
				" WHERE CONTENT=?";
		
		//内部类，封装多个不同的DTO并存储在一个List中
		List<AddQuestionIdDTO> list = jdbcTemplate.query(sql, new Object[]{dto.getContent()}, new RowMapper<AddQuestionIdDTO>() {
	            public AddQuestionIdDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	AddQuestionIdDTO test = new AddQuestionIdDTO();
	            	test.setQuestionId(rs.getInt("ID"));
	                return test;
	            }
	        });

		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	
	
	
	 /**
     * 添加题目选项
     * @param testId
     * @param dtos
     * @return
     */
	public int addOption(Integer questionId, final List<AddQuestionOptionDTO> dtos) {
        final String sql = "INSERT INTO  t_question_option (OPTION_CONTENT, `OPTION`, QUESTION_ID) VALUES (?, ?, ?)";

        //添加题目选项（batchUpdate）
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
        	@Override
        	public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, dtos.get(i).getOPTION_CONTENT());
                ps.setString(2, dtos.get(i).getOption());
                ps.setInt(3, questionId);
			}
        	
			@Override
			public int getBatchSize() {
				return dtos.size();
			}
        });
        
        return dtos.size();
    }
	
	
	
	
	
	
	
	
	
	
	
}
