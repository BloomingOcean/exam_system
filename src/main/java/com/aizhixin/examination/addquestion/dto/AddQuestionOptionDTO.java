package com.aizhixin.examination.addquestion.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ApiModel(description = "试题选项")
@NoArgsConstructor
@Data
@ToString
public class AddQuestionOptionDTO {
	
//	@ApiModelProperty(value = "questionID")
//	private Integer questionId;

	@ApiModelProperty(value = "选项")
	private String option;

	@ApiModelProperty(value = "选项内容")
	private String OPTION_CONTENT;
	
	public AddQuestionOptionDTO(String option, String OPTION_CONTENT) {
		this.option = option;
		this.OPTION_CONTENT = OPTION_CONTENT;
	}
}
