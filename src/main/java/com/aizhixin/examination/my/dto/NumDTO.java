package com.aizhixin.examination.my.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ApiModel(description = "答题数量情况")
@NoArgsConstructor
@Data
@ToString

public class NumDTO {
	@ApiModelProperty(value = "答题总数")
	private Integer Total_Cumulative_question;

	@ApiModelProperty(value = "正确答题数")
	private Integer Total_Correct_question;

	@ApiModelProperty(value = "错误答题数")
	private Integer Total_Incorrectly_question;

	public NumDTO(int Total_Cumulative_question, int Total_Correct_question, int Total_Incorrectly_question) {
		this.Total_Cumulative_question = Total_Cumulative_question;
		this.Total_Correct_question = Total_Correct_question;
		this.Total_Incorrectly_question = Total_Incorrectly_question;
	}
}
