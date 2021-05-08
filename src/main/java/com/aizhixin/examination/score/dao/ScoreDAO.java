package com.aizhixin.examination.score.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.aizhixin.examination.score.dto.ScoreDTO;

@Component
public class ScoreDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
	/**
	 * 根据userid查询用户分数
	 * @param id
	 * @return
	 */
	public ScoreDTO findById (Integer userID) {
		
		final String sql = "SELECT u.* FROM answer_all INNER JOIN" + 
				" (SELECT u.ID, b.all_Score, b.rownum, u.`nikename`,u.`Portrait` ,u.`City`" + 
				" FROM (SELECT  t.*, @rownum := @rownum + 1 AS rownum  FROM  (SELECT @rownum := 0) r, answer_all AS t" + 
				" ORDER BY all_Score DESC ) as b  INNER JOIN `user_information` AS u ON b.User_ID = u.ID" + 
				" WHERE u.ID=?) as u " + 
				" on u.ID = answer_all.User_ID" + 
				" ORDER BY all_Score DESC" + 
				" LIMIT 0,50;";
		List<ScoreDTO> list = jdbcTemplate.query(sql, new Object[]{userID}, new RowMapper<ScoreDTO>() {
	            public ScoreDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	ScoreDTO score = new ScoreDTO();
	            	score.setAll_Score(rs.getInt("all_Score"));
	            	score.setRank(rs.getInt("rownum"));
	                return score;
	            }
	        });

		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}


