package com.aizhixin.examination.storageuserinfo.dto;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "用户信息")
@NoArgsConstructor
@Component
@Data
public class UserInfoDTO {

	@ApiModelProperty(value = "userid", name = "userid")
	private int userid;

	@ApiModelProperty(value = "头像", name = "Portrait")
	private String Portrait;

	@ApiModelProperty(value = "昵称", name = "nikename")
	private String nikename;

	@ApiModelProperty(value = "国家", name = "Country")
	private String Country;

	@ApiModelProperty(value = "省份", name = "Province")
	private String Province;

	@ApiModelProperty(value = "城市", name = "City")
	private String City;

	public UserInfoDTO(String Portrait, String nikename, String Country, String Province, String City) {
		this.Portrait = Portrait;
		this.nikename = nikename;
		this.Country = Country;
		this.Province = Province;
		this.City = City;
		// this.Creation_time = Creation_time;
	}

}
