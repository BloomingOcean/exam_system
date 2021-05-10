package com.aizhixin.examination.questionBank.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import lombok.NoArgsConstructor;

@ApiModel(description="试题选项")
@NoArgsConstructor
@Data
public class QuestionOptionDTO {
    @ApiModelProperty(value = "ID")
     private Integer ID;
    
    @ApiModelProperty(value = "选项")
     private String OPTION;
    
    @ApiModelProperty(value = "选项内容")
    private String optionContent;
}