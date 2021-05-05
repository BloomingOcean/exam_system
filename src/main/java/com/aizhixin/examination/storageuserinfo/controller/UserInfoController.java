package com.aizhixin.examination.storageuserinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aizhixin.examination.storageuserinfo.dto.UserInfoDTO;
import com.aizhixin.examination.storageuserinfo.service.ReturnUseridService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/open/user/information")
@Api("用户基本信息API")
@Slf4j
public class UserInfoController {

	@Autowired
	private ReturnUseridService returnUseridService;

	@PostMapping(value = "/userInformation", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "POST", value = "储存用户基本信息", notes = "储存用户基本信息<br><br><b>@author 李洋</b>")
	public void get(
			@ApiParam(value = "用户基本信息DTO", required = true, type = "ReturnUseridDTO") UserInfoDTO userInfoDTO) {
		log.debug("获取用户信息：{}", userInfoDTO);

		// 添加用户信息
		System.out.println(userInfoDTO.toString());
		returnUseridService.addUserInformation(userInfoDTO);

	}
}
