package com.aizhixin.examination.knowledge.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description="知识领域")
@NoArgsConstructor
@ToString
public class KnowledgeRangeDTO {

	 @ApiModelProperty(value = "知识领域")
	 @Getter @Setter private String knowledgeRange;
	
	 @ApiModelProperty(value = "此知识领域正确数")
	 @Getter @Setter private int CorrectKnowledgeRange;
	 
	 @ApiModelProperty(value = "此知识领域错误数")
	 @Getter @Setter private int inCorrectKnowledgeRange;
	 
	 @ApiModelProperty(value = "正确率")
	 @Getter @Setter private double knowledgeRangeProportion;
	 
	 public KnowledgeRangeDTO(String knowledgeRange, int CorrectKnowledgeRange, int inCorrectKnowledgeRange,double knowledgeRangeProportion) {
		 this.knowledgeRange = knowledgeRange;
		 this.CorrectKnowledgeRange = CorrectKnowledgeRange;
		 this.inCorrectKnowledgeRange = inCorrectKnowledgeRange;
		 this.knowledgeRangeProportion = knowledgeRangeProportion;
	 }
}
