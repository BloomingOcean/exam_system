package com.aizhixin.examination.questionBank.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.aizhixin.examination.questionBank.dto.QuestionOptionDTO;

@Component
public class RankQuestionOptionDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 添加试题选项
	 * @param questionId
	 * @param dtos
	 * @return
	 */
	public int add(Integer questionId, final List<QuestionOptionDTO>dtos) {
		final String sql = "INSERT INTO  t_question_option (OPTION_CONTENT, `OPTION`, QUESTION_ID) VALUES (?, ?, ?)";
		
		//批量添加
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, dtos.get(i).getOptionContent());
				ps.setString(2, dtos.get(i).getOPTION());
				ps.setInt(3, questionId);
			}
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return dtos.size();
			}
		});
		return dtos.size();
	}
	
	/**
	 * 删除试题选项
	 * @param testId
	 * @return
	 */
	public int delete(String questionId) {
        final String sql = "DELETE FROM  t_question_option WHERE QUESTION_ID = ?";
        return jdbcTemplate.update(sql,  
                new Object[] {questionId},
                new int[] {Types.VARCHAR}
                );
    }
	
	/**
	 * 修改选项
	 * @param testId
	 * @param dtos
	 * @return
	 */
	public int update(Integer testId, final List<QuestionOptionDTO> dtos) {
        final String sql = "UPDATE  t_question_option SET OPTION_CONTENT = ?, `OPTION` = ?, QUESTION_ID = ? WHERE ID = ?";

        //批量修改
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
        	@Override
        	public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, dtos.get(i).getOptionContent());
                ps.setString(2, dtos.get(i).getOPTION());
                ps.setInt(3, testId);
                ps.setLong(4, dtos.get(i).getID());
			}
			@Override
			public int getBatchSize() {
				return dtos.size();
			}
        });
        
        return dtos.size();
    }

}
