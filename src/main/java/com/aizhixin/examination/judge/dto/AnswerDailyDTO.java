package com.aizhixin.examination.judge.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "每日答题分数表")
@Data
@NoArgsConstructor
public class AnswerDailyDTO {

	@ApiModelProperty(value = "UserID",name = "User_ID")
	private int userID;
	
	@ApiModelProperty(value = "CorrectNumber",name = "Correct_Number")
	private int correctNumber = 0;
	
	@ApiModelProperty(value = "WrongNumber",name = "Wrong_Number")
	private int wrongNumber = 0;
	
	@ApiModelProperty(value = "TotalNumber",name = "Total_Number")
	private int totalNumber = 0;
	
	@ApiModelProperty(value = "Allscore",name = "All_score")
	private int allscore = 0;
	
	@ApiModelProperty(value = "Daliyscore",name = "Daliy_score")
	private int daliyScore = 0;
	
//	@ApiModelProperty(value = "ReplyDate",name = "Reply_Date")
//	private int replyDate = 0;
	
	public AnswerDailyDTO(int userID, int correctNumber, int wrongNumber, int totalNumber, int allscore, int daliyScore){
		this.userID = userID;
		this.correctNumber = correctNumber;
		this.wrongNumber = wrongNumber;
		this.totalNumber = totalNumber;
		this.allscore = allscore;
		this.daliyScore = daliyScore;
	}

}
