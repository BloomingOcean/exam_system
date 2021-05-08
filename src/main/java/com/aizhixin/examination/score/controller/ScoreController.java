package com.aizhixin.examination.score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aizhixin.examination.score.dto.ScoreDTO;
import com.aizhixin.examination.score.service.ScoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/open/user/score")
@Api("用户分数相关API")
@Slf4j
public class ScoreController {
	@Autowired
	private ScoreService scoreService;

    @GetMapping(value = "/{userID}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod = "GET", value = "根据userID查询用户总分和排名", notes = "根据userID查询用户总分和排名<br><br><b>@author 李洋</b>")
    public ScoreDTO get(@ApiParam(value = "用户ID", required = true) @PathVariable Integer userID) {
    	log.debug("获取用户ID：{}", userID);
        return scoreService.getById(userID);
    }
}
