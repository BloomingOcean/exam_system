package com.aizhixin.examination.commons.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(description="OpenidDTO")
@Data
@NoArgsConstructor
@Component
public class OpenidDTO {

	
	@ApiModelProperty(value = "openid")
	@Getter @Setter private String openId;

	public OpenidDTO(String openId) {
		this.openId = openId;
}

}
