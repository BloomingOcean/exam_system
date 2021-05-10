package com.aizhixin.examination.knowledge.dao;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.aizhixin.examination.knowledge.dto.KnowledgeRangeDTO;

@Component
public class KnowledgeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 根据userid查询用户的排名和其最擅长的前三个知识领域
	 * 
	 * @param userID
	 * @return
	 */
	public List<KnowledgeRangeDTO> findById(int userID) {
		final String sql = "SELECT c.Knowledge_range, SUM(c.correct) as correct, SUM(c.incorrect) as incorrect, SUM(c.correct)/(SUM(c.correct)+SUM(c.incorrect)) as `rank` " + 
				" FROM (" + 
				" SELECT Knowledge_range, CASE WHEN Answer_judge = 1 THEN 1 ELSE 0 END correct, CASE WHEN Answer_judge = 0 THEN 1 ELSE 0 END incorrect" + 
				" FROM answer_record " + 
				" WHERE  User_ID=?" + 
				" ) c" + 
				" GROUP BY c.Knowledge_range" + 
				" ORDER BY `rank` DESC" + 
				" LIMIT 0,5";

		// 这个rs.get里面的字段是做什么用的（在sql语句查找到的数据中找“Knowledge_range”这个字段并把值作参数给DTO）
		// new int[] {Types.VARCHAR},这个又是干嘛用的
		List<KnowledgeRangeDTO> list = jdbcTemplate.query(sql, new Object[] { userID }, new int[] { Types.VARCHAR },
				(ResultSet rs, int rowNum) -> new KnowledgeRangeDTO(rs.getString("Knowledge_range"),rs.getInt("Correct"),rs.getInt("incorrect"),rs.getDouble("rank")));

		if (null != list && list.size() > 0) {
			return list;
		}
		return null;
	}

}
