package com.aizhixin.examination.updatequestion.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ApiModel(description = "试题")
@NoArgsConstructor
@Data
@ToString
public class UpdateQuestionDTO {
	@ApiModelProperty(value = "试题ID")
	private Integer QuestionID;

	@ApiModelProperty(value = "试题内容")
	private String content;

	@ApiModelProperty(value = "试题答案")
	private String answer;

	@ApiModelProperty(value = "知识领域")
	private String KNOWLEDGEAREA;

	@ApiModelProperty(value = "试题选项")
	private List<UpdateQuestionOptionDTO> options;

	public UpdateQuestionDTO(Integer QuestionID, String content, String answer, String KNOWLEDGEAREA) {
		this.QuestionID = QuestionID;
		this.content = content;
		this.answer = answer;
		this.KNOWLEDGEAREA = KNOWLEDGEAREA;
	}
}