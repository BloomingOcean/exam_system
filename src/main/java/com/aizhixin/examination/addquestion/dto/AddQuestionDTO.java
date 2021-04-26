package com.aizhixin.examination.addquestion.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ApiModel(description="题目信息")
@NoArgsConstructor
@Data
@ToString
public class AddQuestionDTO {

	@ApiModelProperty(dataType="String",value = "题干内容",name = "content")
	private String content;
	
	@ApiModelProperty(dataType="String",value = "答案",name = "answer")
	private String answer;	
	
	@ApiModelProperty(dataType="String",value = "知识领域",name = "konwledgeArea")
	private String konwledgeArea;
	
	@ApiModelProperty(dataType="List<AddQuestionOptionDTO>",value = "选项",name = "konwledgeArea")
	private List<AddQuestionOptionDTO> optionContent;
}
