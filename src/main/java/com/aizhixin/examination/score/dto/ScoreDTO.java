package com.aizhixin.examination.score.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description="用户分数")
@NoArgsConstructor
@Data
@ToString
public class ScoreDTO {

    @ApiModelProperty(value = "总分")
    @Getter @Setter private int all_Score;
    
    @ApiModelProperty(value = "排名")
    @Getter @Setter private int rank;

    public ScoreDTO (int all_Score,int rank) {
    	this.all_Score = all_Score;	
    	this.rank = rank;
    }
}
