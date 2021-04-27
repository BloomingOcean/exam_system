package com.aizhixin.examination.judge.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "答题记录表")
@Data
@NoArgsConstructor
public class AnswerRecordDTO {

	@ApiModelProperty(value = "问题的ID",name = "questionId")
	private int questionId;
		
	@ApiModelProperty(value = "SubmitAnswer",name = "Submit_Answer")
	private String submitAnswer;
	
	@ApiModelProperty(value = "Answerjudge",name = "Answer_judge")
	private byte answerjudge;
	
	@ApiModelProperty(value = "UserID",name = "User_ID")
	private int userID;
	
	@ApiModelProperty(value = "RightAnswer",name = "RIGHT_answer")
	private String rightAnswer;
	
//	@ApiModelProperty(value = "AnswerTime",name = "Answer_Time")
//	private Date answerTime;
	
	@ApiModelProperty(value = "Knowledgerange",name = "Knowledge_range")
	private String knowledgeRange;
	
	@ApiModelProperty(value = "questionScore",name = "question_Score")
	private int questionScore;
	
	public AnswerRecordDTO(int questionId, String submitAnswer, byte answerjudge, int userID, String rightAnswer,  String knowledgeRange, int questionScore) {
		this.questionId = questionId;
		this.submitAnswer = submitAnswer;
		this.answerjudge = answerjudge;
		this.userID = userID;
		this.rightAnswer = rightAnswer;
		this.knowledgeRange = knowledgeRange;
		this.questionScore = questionScore;
	}
}
