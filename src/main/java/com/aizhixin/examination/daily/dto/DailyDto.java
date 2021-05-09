package com.aizhixin.examination.daily.dto;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description="每日答题")
@NoArgsConstructor
@ToString
public class DailyDto {
	    
	    
	    @ApiModelProperty(value = "回答错误题目数量（当日）")	//我的
	    @Getter @Setter private int Wrong_Number;
	 
	    @ApiModelProperty(value = "回答正确题目数量（当日）")	//我的
	    @Getter @Setter private int  Correct_Number; 
	    
	    @ApiModelProperty(value = "答题题目数量（当日）")		//我的&排行
	    @Getter @Setter private int  Total_Number; 
	    
	    @ApiModelProperty(value = "用户累计总分（总）")		//排行
	    @Getter @Setter private int  All_score;
	    
	    @ApiModelProperty(value = "答题时的时间")			//我的&排行
	    @Getter @Setter private Date Reply_Date;
	    
	    public DailyDto (int Wrong_Number, int Correct_Number, int Total_Number, int All_score, Date Reply_Date) {
	    	this.Wrong_Number = Wrong_Number;
	    	this.Correct_Number = Correct_Number;
	    	this.Total_Number = Total_Number;
	    	this.All_score = All_score;
	    	this.Reply_Date = Reply_Date;
	    }
}
