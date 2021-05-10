package com.aizhixin.examination.commons.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.aizhixin.examination.commons.vo.OpenidDTO;
import com.aizhixin.examination.commons.vo.UserIDDTO;

@Component
public class InOpenidDAO {

	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	    
	
	 /**
		 * 添加用户openid（并递增生成userid）
		 * @param dto
		 * @return
		 */
		public void add(String openid) {
	        final String sql = "INSERT INTO user_information(openID,Creation_time)" + 
	        		" VALUES(?, ?);";
	 
	        
	        //执行sql语句并把数据给（为什么是get，感觉应该是set）
	        jdbcTemplate.update(sql,  
	        		openid, new Date());
	        
//	        return dto;
	    }
	
		
		/**
		 * 根据openid查找userid
		 * @param openid
		 * @return
		 */
		public UserIDDTO useridByOpenid (String Openid) {
			final String sql = "SELECT ID from user_information" + 
					" WHERE openID = ?;";
			
			//内部类，封装多个不同的DTO并存储在一个List中
			List<UserIDDTO> list = jdbcTemplate.query(sql, new Object[]{Openid}, new RowMapper<UserIDDTO>() {
		            public UserIDDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	UserIDDTO test = new UserIDDTO();
		            	test.setUserId(rs.getInt("ID"));
		                return test;
		            }
		        });

			if (null != list && list.size() > 0) {
				return list.get(0);
			}
			return null;
		}
		
		
		/**
		 * 根据查找openid
		 * @param openid
		 * @return
		 */
		public OpenidDTO foundOpenid (String Openid) {
			final String sql = "SELECT openID from user_information" + 
					" WHERE openID = ?;";
	
			
			List<OpenidDTO> list = jdbcTemplate.query(sql, new Object[]{Openid}, new RowMapper<OpenidDTO>() {
		            public OpenidDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	OpenidDTO test = new OpenidDTO();
		            	test.setOpenId(rs.getString("openID"));
		                return test;
		            }
		        });

			if (null != list && list.size() > 0) {
				return list.get(0);
			}
			return null;
		}
}
