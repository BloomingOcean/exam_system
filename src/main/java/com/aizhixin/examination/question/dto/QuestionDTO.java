package com.aizhixin.examination.question.dto;

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
public class QuestionDTO {
	@ApiModelProperty(value = "ID")
	private String id;

	@ApiModelProperty(value = "试题内容")
	private String content;

	@ApiModelProperty(value = "试题答案")
	private String answer;

	@ApiModelProperty(value = "知识领域")
	private String KNOWLEDGE_AREA;

	@ApiModelProperty(value = "试题选项")
	private List<QuestionOptionDTO> options;

	public QuestionDTO(String id, String content, String answer, String KNOWLEDGE_AREA) {
		this.id = id;
		this.content = content;
		this.answer = answer;
		this.KNOWLEDGE_AREA = KNOWLEDGE_AREA;
	}
}