package com.aizhixin.examination.questionBank.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description="试题")
@NoArgsConstructor

@Data
public class BankQuestionDTO {
	@ApiModelProperty(value = "id")
	private Integer ID;
	@ApiModelProperty(value = "试题内容")
	private String CONTENT;
	@ApiModelProperty(value = "试题答案")
	private String ANSWER;
	@ApiModelProperty(value = "知识领域")
	private String knowledgeArea;
	@ApiModelProperty(value = "试题选项")
	private List<QuestionOptionDTO> options;
	
}
