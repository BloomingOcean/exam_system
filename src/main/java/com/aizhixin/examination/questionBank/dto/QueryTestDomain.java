package com.aizhixin.examination.questionBank.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel(description="题目查询")
@Data
@EqualsAndHashCode(callSuper=false)
public class QueryTestDomain {
	
	
	@ApiModelProperty(value = "第几页", required = true)
	private Integer pageNumber;
	
	@ApiModelProperty(value = "每页数据的数目", required = false)
	private Integer pageSize;
	
	@ApiModelProperty(value = "查询关键字", required = false)
	private String keyWords;
	
}
