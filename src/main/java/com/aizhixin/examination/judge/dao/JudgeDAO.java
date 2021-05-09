package com.aizhixin.examination.judge.dao;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.aizhixin.examination.judge.dto.AnswerAllDTO;
import com.aizhixin.examination.judge.dto.AnswerDailyDTO;
import com.aizhixin.examination.judge.dto.AnswerRecordDTO;
import com.aizhixin.examination.judge.dto.ExistAnswerAllDTO;
import com.aizhixin.examination.judge.dto.InputDTO;

@Component
public class JudgeDAO {

	   @Autowired
	    private JdbcTemplate jdbcTemplate;
	    
	    
	/**
	 * 插入一条答题分数总表（用户还从未过答题）（表：answer_all）
	 * 必须要为每个字段赋初值为0
	 * @param dto
	 * @return
	 */
	public AnswerAllDTO addAnswerAll(AnswerAllDTO dto) {
        final String sql = "INSERT INTO  answer_all (User_ID, all_Score, Total_Correct_question, Total_Incorrectly_question, Total_Cumulative_question)" + 
        		" VALUES (?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql,  
                dto.getUserID(), dto.getAllScore(), dto.getTotalCorrectQuestion(), dto.getTotalIncorrectlyQuestion(), dto.getTotalCumulativeQuestion() );
        return dto;
    }
	
	
	/**
	 * 答题“正确”后对答题分数总表分数的修改（用户已答过题）（表：answer_all）
	 * 
	 * @param dto
	 * @return
	 */
	public void correctUpdateAnswerAll(InputDTO dto) {
        final String sql = "UPDATE answer_all SET all_Score=all_Score+2,Total_Correct_question=Total_Correct_question+1,Total_Cumulative_question=Total_Cumulative_question+1" + 
        		" WHERE User_ID = ?";
        jdbcTemplate.update(sql, new Object[] {dto.getUserId()}, new int[] {Types.INTEGER});
    }
	
	
	/**
	 * 答题“错误”后对答题分数总表分数的修改（用户已答过题）（表：answer_all）
	 * 
	 * @param dto
	 * @return
	 */
	public void incorrectUpdateAnswerAll(InputDTO dto) {
        final String sql = "UPDATE answer_all SET all_Score=all_Score-1,Total_Incorrectly_question=Total_Incorrectly_question+1,Total_Cumulative_question=Total_Cumulative_question+1" + 
        		" WHERE User_ID = ?";
        jdbcTemplate.update(sql, new Object[] {dto.getUserId()}, new int[] {Types.INTEGER});
    }
	
		
	/**
	 * 
	 * 插入一条每日答题表（用户今日还未答题）（ 表： answer_daily）
	 * 必须要为每个字段赋初值为0
	 * @param dto
	 * @return
	 */
	public AnswerDailyDTO addAnswerDaily(AnswerDailyDTO dto,InputDTO judge) {
        final String sql = "INSERT INTO  answer_daily (User_ID, Correct_Number, Wrong_Number, Total_Number, All_score, Daliy_score, Reply_Date)" + 
        		" VALUES (?, ?, ?, ?, ?, ?, CURDATE());";
        jdbcTemplate.update(sql,  
                judge.getUserId(), dto.getCorrectNumber(), dto.getWrongNumber(), dto.getTotalNumber(), dto.getAllscore(), dto.getDaliyScore() );
        return dto;
    }
	
	
	/**
	 * 答题“正确”后对每日答题分数表分数的修改（用户今日已答过题）（表：answer_daily）
	 * 
	 * @param dto
	 * @return
	 */
	public void correctUpdateAnswerDaily(InputDTO dto) {
        final String sql = "UPDATE answer_daily SET Correct_Number=Correct_Number+1,Total_Number=Total_Number+1,All_score=All_score+2,Daliy_score=Daliy_score+2" + 
        		" WHERE User_ID = ? AND Reply_Date = CURDATE();";
        jdbcTemplate.update(sql, new Object[] {dto.getUserId()}, new int[] {Types.INTEGER});
    }
	
	
	/**
	 * 答题“错误”后对每日答题分数表分数的修改（用户今日已答过题）（表：answer_daily）
	 * 
	 * @param dto
	 * @return
	 */
	public void incorrectUpdateAnswerDaily1(InputDTO dto) {
        final String sql = "UPDATE answer_daily SET Wrong_Number=Wrong_Number+1,Total_Number=Total_Number+1,All_score=All_score-1,Daliy_score=Daliy_score-1" + 
        		" WHERE User_ID = ? AND  Reply_Date = CURDATE();";
        jdbcTemplate.update(sql, new Object[] {dto.getUserId()}, new int[] {Types.INTEGER});
    }
	
	
	/**
	 * 答题“错误”后对每日答题分数表分数的修改（分数为0的时候）（用户今日已答过题）（表：answer_daily）
	 * 
	 * @param dto
	 * @return
	 */
	public void incorrectUpdateAnswerDaily2(InputDTO dto) {
        final String sql = "UPDATE answer_daily SET Wrong_Number=Wrong_Number+1,Total_Number=Total_Number+1" + 
        		" WHERE User_ID = ? AND  Reply_Date = CURDATE();";
        jdbcTemplate.update(sql, new Object[] {dto.getUserId()}, new int[] {Types.INTEGER});
    }
	

	/**
	 * 插入一条答题记录（表：answer_record）
	 * @param dto
	 * @return
	 */
	public AnswerRecordDTO addAnswerRecord(AnswerRecordDTO dto) {
        final String sql = "INSERT INTO  answer_record" + 
        		" (question_ID, Submit_Answer, Answer_judge, User_ID, RIGHT_answer, Answer_Time, Knowledge_range,question_Score)" + 
        		" VALUES (?, ?, ?, ?, ?, NOW(), ?, ?);";
        jdbcTemplate.update(sql,  
                dto.getQuestionId(), dto.getSubmitAnswer(), dto.getAnswerjudge(), dto.getUserID(), dto.getRightAnswer(), dto.getKnowledgeRange(), dto.getQuestionScore() );
        return dto;
    }
	
	
	/**
	 * 查询此表是否有userid这个用户（表：answer_all）
	 * @param dto
	 * @return
	 */
	public ExistAnswerAllDTO queryUserid(InputDTO dto) {
        final String sql = "SELECT User_ID FROM answer_all" + 
        		" WHERE User_ID = ?";
      //通过前端传入的userid查找数据库中的userid，如果没有就是null
    	List<ExistAnswerAllDTO> list = jdbcTemplate.query(sql, 
                new Object[] {dto.getUserId()},
                new int[] {Types.INTEGER},
				(ResultSet rs, int rowNum) -> new ExistAnswerAllDTO (rs.getInt("User_ID"))
				);
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
    }
	
	
	/**
	 * 查询此表是否有userid这个用户在creattime这个时间的记录（表：answer_daily）
	 * @param dto
	 * @return
	 */
	public ExistAnswerAllDTO queryCreatTime(InputDTO dto) {
        final String sql = "SELECT User_ID FROM answer_daily" + 
        		" WHERE Reply_Date = CURDATE() AND User_ID = ?;";
    	List<ExistAnswerAllDTO> list = jdbcTemplate.query(sql, 
                new Object[] {dto.getUserId()},
                new int[] {Types.INTEGER},
				(ResultSet rs, int rowNum) -> new ExistAnswerAllDTO (rs.getInt("User_ID"))
				);
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
    }
	
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		/**
		 * 回答正确加2分
		 * @param dto
		 * @return
		 */
		public InputDTO addScore(InputDTO dto) {
	        final String sql = "UPDATE  answer_all SET all_Score = all_Score + 2 WHERE User_ID = ?;";
	        jdbcTemplate.update(sql,  
	                new Object[] {dto.getUserId()},
	                new int[] {Types.VARCHAR}
	                );
	        return dto;
	    }
		
		
		/**
		 * 回答错误减1分
		 * @param dto
		 * @return
		 */
		public InputDTO reduceScore(InputDTO dto) {
	        final String sql = "UPDATE  answer_all SET all_Score = all_Score - 1 WHERE User_ID = ?;";
	        jdbcTemplate.update(sql,  
	                new Object[] {dto.getUserId()},
	                new int[] {Types.VARCHAR}
	                );
	        return dto;
	    }
		
		
		/**
		 * 根据Question_ID查找题目的某些信息（问题ID，答案，知识领域）
		 * @param QuestionID
		 * @return 
		 */
		public InputDTO findQuestionByQuestionId (String QuestionID) {
			final String sql = "SELECT ID, ANSWER, KNOWLEDGE_AREA  FROM  t_question WHERE ID = ?";
			List<InputDTO> list = jdbcTemplate.query(sql, 
	                new Object[] {QuestionID},
	                new int[] {Types.VARCHAR},
					(ResultSet rs, int rowNum) -> new InputDTO (rs.getInt("ID"), rs.getString("ANSWER"), rs.getString("KNOWLEDGE_AREA"))
					);
			if (null != list && list.size() > 0) {
				return list.get(0);	
			}
			return null;
		}
		
		
}
