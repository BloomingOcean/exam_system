package com.aizhixin.examination.daily.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aizhixin.examination.daily.dto.DailyDto;
import com.aizhixin.examination.daily.service.DailyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/v1/open/user/daily")
@Api("查询用户每日答题分数API")
@Slf4j
public class DailyController {
	@Autowired
	private DailyService DailyService;
	
	 @GetMapping(value = "/{UserId}", produces = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(httpMethod = "GET", value = "查询用户每日答题分数", notes = "查询用户每日答题分数<br><br><b>@author J·T</b>")
	 public List<DailyDto> get(@ApiParam(value = "查询列表", required = true) @PathVariable("UserId") int USER_ID) {
		 log.info("获取用户userID：{}", USER_ID);
	     return DailyService.userInfo(USER_ID);
	    }
}
