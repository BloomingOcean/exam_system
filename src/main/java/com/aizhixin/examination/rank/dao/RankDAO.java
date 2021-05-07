package com.aizhixin.examination.rank.dao;

import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.aizhixin.examination.rank.dto.RankINFODTO;
//import com.aizhixin.test5.exam.dto.TestDTO;
//import cn.xiaoandx.exam.vo.AnswerRanking;
//import com.aizhixin.test5.exam.dto.TestDTO;
//import cn.xiaoandx.exam.entity.AnswerRecord;

@Component
public class RankDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 把前50个用户的总分进行排名，并根据名词依次把用户的信息通过userid封装到RankINFODTO里面
	 * @Title: findRanking
	 * @version:V0.1
	 * @return:List<TotalCollcetSubject>
	 */
	public List<RankINFODTO> Rank() {
		final String sql = "SELECT u.ID, b.all_Score, b.rownum, u.`nikename`,u.`Portrait` ,u.`City`"
				+ " FROM (SELECT  t.*, @rownum := @rownum + 1 AS rownum  FROM  (SELECT @rownum := 0) r, answer_all AS t"
				+ " ORDER BY all_Score DESC ) as b  INNER JOIN `user_information` AS u ON b.User_ID = u.ID"
				+ " ORDER BY all_Score DESC" + " LIMIT 0,50";

		List<RankINFODTO> list = jdbcTemplate.query(sql,
				(ResultSet rs, int rowNum) -> new RankINFODTO(rs.getInt("rownum"), rs.getString("ID"),
						rs.getString("Portrait"), rs.getString("nikename"), rs.getInt("all_Score"),
						rs.getString("City")));

		if (null != list && list.size() > 0) {
			return list;
		}
		return null;
	}

}
