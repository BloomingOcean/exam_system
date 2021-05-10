package com.aizhixin.examination.questionBank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.aizhixin.examination.commons.core.PageData;
import com.aizhixin.examination.commons.uitl.PageJdbcUtil;
import com.aizhixin.examination.questionBank.dto.BankQuestionDTO;
import com.aizhixin.examination.questionBank.dto.QueryTestDomain;

@Component
public class BankQuestionDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private PageJdbcUtil pageJdbcUtil;

	
	/**
	 * 添加试题
	 */
	public BankQuestionDTO add(BankQuestionDTO dto) {
		final String sql = "INSERT INTO  t_question (ID, CONTENT, ANSWER, KNOWLEDGE_AREA) VALUES (?, ?, ?, ?)";
		dto.setID(Integer.parseInt(UUID.randomUUID().toString()));//生成ID
		jdbcTemplate.update(sql,
				dto.getID(), dto.getCONTENT(), dto.getANSWER(), dto.getKnowledgeArea());
		return dto;
	}
	
	/**
	 * 删除试题
	 * @param id
	 * @return
	 */
	public int delete(String id) {
        final String sql = "DELETE FROM  t_question WHERE ID = ?";
        return jdbcTemplate.update(sql,  
                new Object[] {id},
                new int[] {Types.VARCHAR}
                );
    }
	
	/**
	 * 修改试题
	 * @param dto
	 * @return
	 */
	public BankQuestionDTO update(BankQuestionDTO dto) {
        final String sql = "UPDATE  t_question SET CONTENT = ?, ANSWER = ?, KNOWLEDGE_AREA = ? WHERE ID = ?";
        jdbcTemplate.update(sql,  
                new Object[] {dto.getCONTENT(), dto.getANSWER(), dto.getKnowledgeArea(), dto.getID()},
                new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR}
                );
        return dto;
	}
	
	
	
	RowMapper<BankQuestionDTO> testRM = new RowMapper<BankQuestionDTO>() {

		@Override
		public BankQuestionDTO mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			// TODO Auto-generated method stub
			BankQuestionDTO test = new BankQuestionDTO();
			test.setID(rs.getInt("ID"));
        	test.setCONTENT(rs.getString("CONTENT"));
        	test.setANSWER(rs.getString("ANSWER"));
        	test.setKnowledgeArea(rs.getString("KNOWLEDGE_AREA"));
			return test;
		}
	};
	
	
	/**
	 * 分页查询
	 * @param domain
	 * @return
	 */
	public PageData<BankQuestionDTO> getTestPage(
			QueryTestDomain domain) {

		String querySql = "SELECT ID, CONTENT, ANSWER,KNOWLEDGE_AREA  FROM  `t_question` ";
		String countSql = "SELECT count(1) FROM `t_question` ";
		
		return pageJdbcUtil.getPageData(domain.getPageSize(),
				domain.getPageNumber(), testRM, querySql, countSql);
	}
}
