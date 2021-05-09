package com.aizhixin.examination.judge.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "存储答题记录总表是否有此人的记录")
@Data
@NoArgsConstructor
public class ExistAnswerAllDTO {
	
	@ApiModelProperty(value = "userid",name = "userid")
	private int userid;
	
	public ExistAnswerAllDTO(int userid) {
		this.userid = userid;
	}

}
