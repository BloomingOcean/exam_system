package com.aizhixin.examination.updatequestion.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ApiModel(description = "试题选项")
@NoArgsConstructor
@Data
@ToString
public class UpdateQuestionOptionDTO {
	@ApiModelProperty(value = "试题ID")
	private Integer QuestionID;

	@ApiModelProperty(value = "选项")
	private String option;

	@ApiModelProperty(value = "选项内容")
	private String OPTIONCONTENT;

	public UpdateQuestionOptionDTO(Integer QuestionID, String option, String OPTIONCONTENT) {
		this.QuestionID = QuestionID;
		this.option = option;
		this.OPTIONCONTENT = OPTIONCONTENT;
	}
}
