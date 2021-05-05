package com.aizhixin.examination.commons.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(description="userID")
@Data
@NoArgsConstructor
@Component
public class UserIDDTO {

	@ApiModelProperty(value = "userId")
	@Getter @Setter private int userId;
	
	public UserIDDTO(int userId) {
		this.userId = userId;
	}
}
