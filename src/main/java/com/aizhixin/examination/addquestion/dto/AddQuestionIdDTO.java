package com.aizhixin.examination.addquestion.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ApiModel(description="题目ID")
@NoArgsConstructor
@Data
@ToString
public class AddQuestionIdDTO {

	@ApiModelProperty(dataType="Integer",value = "问题ID",name = "QuestionId")
	private Integer QuestionId;
	
}
