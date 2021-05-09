package com.aizhixin.examination.judge.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value ="答题分数总表")
@Data
@NoArgsConstructor
public class AnswerAllDTO {

	@ApiModelProperty(value = "userID",name = "userID")
	private int userID;
	
	@ApiModelProperty(value = "allScore",name = "userID")
	private int allScore = 0;
	
	@ApiModelProperty(value = "TotalCorrectQuestion",name = "Total_Correct_question")
	private int TotalCorrectQuestion = 0;
	
	@ApiModelProperty(value = "TotalIncorrectlyQuestion",name = "Total_Incorrectly_question")
	private int TotalIncorrectlyQuestion = 0;
	
	@ApiModelProperty(value = "TotalCumulativeQuestion",name = "Total_Cumulative_question")
	private int TotalCumulativeQuestion = 0;
	
	public AnswerAllDTO(int userID, int allScore, int TotalCorrectQuestion, int TotalIncorrectlyQuestion, int TotalCumulativeQuestion) {
		this.userID = userID;
		this.allScore = allScore;
		this.TotalCorrectQuestion = TotalCorrectQuestion;
		this.TotalIncorrectlyQuestion = TotalIncorrectlyQuestion;
		this.TotalCumulativeQuestion = TotalCumulativeQuestion;
	}
}
