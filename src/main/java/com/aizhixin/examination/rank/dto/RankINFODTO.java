package com.aizhixin.examination.rank.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "用户")
@Data
public class RankINFODTO {

	@ApiModelProperty(value = "排名", name = "rownum")
	private Integer rownum;

	@ApiModelProperty(value = "用户id", name = "userID")
	private String userID;

	@ApiModelProperty(value = "用户总成绩", name = "all_Score")
	private Integer all_Score;

	@ApiModelProperty(value = "微信昵称", name = "nikename")
	private String nikename;

	@ApiModelProperty(value = "头像地址", name = "Portrait")
	private String Portrait;

	@ApiModelProperty(value = "城市", name = "City")
	private String City;

	public RankINFODTO(int rownum, String userID, String Portrait, String nikename, int all_Score, String City) {
		this.rownum = rownum;
		this.userID = userID;
		this.all_Score = all_Score;
		this.nikename = nikename;
		this.Portrait = Portrait;
		this.City = City;

	}

}
