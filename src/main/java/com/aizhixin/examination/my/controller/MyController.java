package com.aizhixin.examination.my.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aizhixin.examination.my.dto.NumDTO;
import com.aizhixin.examination.my.service.NumService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/open/user/my")
@Api("实现我的页面答题记录的API")
@Slf4j
public class MyController {
	@Autowired
	private NumService numService;
	
	@GetMapping(value = "/{userID}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "GET", value = "根据userID查询用户答题总数量情况", notes = "根据userID查询用户答题总数量情况<br><br><b>@author 伍富强</b>")
	public NumDTO get(@ApiParam(value = "用户User_ID", required = true) @PathVariable("userID") int userID) {
		log.info("获取用户User_ID： {}", userID);
		return numService.getByUserId(userID);
	}
}
