package com.aizhixin.examination.my.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.aizhixin.examination.my.dto.NumDTO;

@Component
public class NumDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 根据userid查询用户答题总分表的数据
	 * @param userID
	 * @return
	 */
	public NumDTO findByUserId(int userID) {
		final String sql = "SELECT Total_Correct_question,Total_Incorrectly_question,Total_Cumulative_question" + 
				" FROM answer_all" + 
				" WHERE User_ID= ? ;";
		List<NumDTO> list = jdbcTemplate.query(sql,new Object[] {userID}, new RowMapper<NumDTO>() {
				public NumDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
					NumDTO num = new NumDTO();
					num.setTotal_Correct_question(rs.getInt("Total_Correct_question"));
					num.setTotal_Incorrectly_question(rs.getInt("Total_Incorrectly_question"));
					num.setTotal_Cumulative_question(rs.getInt("Total_Cumulative_question"));
					return num;
				}
		});
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
}
