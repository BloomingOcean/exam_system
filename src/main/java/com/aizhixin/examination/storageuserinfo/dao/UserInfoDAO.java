package com.aizhixin.examination.storageuserinfo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.aizhixin.examination.storageuserinfo.dto.UserInfoDTO;

@Component
public class UserInfoDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 添加用户基本信息
	 * 
	 * @param dto
	 * @return
	 */
	public UserInfoDTO add(UserInfoDTO dto) {
		final String sql = "UPDATE user_information"
				+ " SET Portrait = ?, nikename = ?, Country = ?, Province = ?, City = ?" + " WHERE ID = ?;";

		// 执行sql语句并把数据给（为什么是get，感觉应该是set）

		jdbcTemplate.update(sql, dto.getPortrait(), dto.getNikename(), dto.getCountry(), dto.getProvince(),
				dto.getCity(), dto.getUserid());// new 一个时间（包含了时分秒）

		return dto;
	}

}
