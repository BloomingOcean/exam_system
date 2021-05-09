package com.aizhixin.examination.judge.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(value = "前端传入的信息")
@Data
public class InputDTO {
	@ApiModelProperty(value = "问题的ID",name = "questionId")
	private int questionId;
	
	@ApiModelProperty(value = "用户Userid",name = "userId")
	private Integer userId;
	
	@ApiModelProperty(value = "用户答题是否正确",name = "TorF")
	private byte judgeAnswer;

	@ApiModelProperty(value = "问题的正确答案",name = "RIGHT_answer")
	private String RightAnswer;
	
	@ApiModelProperty(value = "用户提交的答案",name = "correctAnswer")
	private String userAnswer;
	
	@ApiModelProperty(value = "知识领域",name = "Knowledge_range")
	private String KnowledgeRange;
	
	/**
	 * 更多关于问题的信息
	 * @param KnowledgeRange
	 * @param RightAnswer
	 */
	public InputDTO(int questionId, String RightAnswer, String KnowledgeRange){
		this.questionId = questionId;
		this.KnowledgeRange = KnowledgeRange;
		this.RightAnswer = RightAnswer;
	}

	
}
