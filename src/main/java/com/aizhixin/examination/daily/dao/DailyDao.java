package com.aizhixin.examination.daily.dao;

import java.sql.ResultSet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.aizhixin.examination.daily.dto.DailyDto;

@Component
public class DailyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 获取该用户的 答题错误数，答题正确数，答题总数，总分，答题时间
	 * 
	 * @param userId
	 * @return
	 */
	public List<DailyDto> getInfo(int userId) {
		final String sql = "SELECT A.Wrong_Number,A.Correct_Number,A.Total_Number,A.All_score,A.Reply_Date FROM answer_daily as A"
				+ " INNER JOIN user_information as U ON A.User_ID = U.ID" + " WHERE User_ID = ?"
				+ " ORDER BY Reply_Date DESC";
		List<DailyDto> list = jdbcTemplate.query(sql, new Object[] { userId },
				(ResultSet rs, int rowNum) -> new DailyDto(rs.getInt("Wrong_Number"), rs.getInt("Correct_Number"),
						rs.getInt("Total_Number"), rs.getInt("All_score"), rs.getDate("Reply_Date")));
		if (null != list && list.size() > 0) {
			return list;
		}
		return null;
	}
}
