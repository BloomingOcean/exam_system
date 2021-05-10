package com.aizhixin.examination.knowledge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aizhixin.examination.knowledge.dto.KnowledgeRangeDTO;
import com.aizhixin.examination.knowledge.service.KnowledgeService;
//import com.aizhixin.examination.score.dto.ScoreDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController 
@RequestMapping("/v1/open/test/knowledge")
@Api("擅长知识领域相关API")
@Slf4j
public class KnowledgeController {
	@Autowired
	private KnowledgeService knowledgeService;
	
	@GetMapping(value = "/{userID}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod = "GET", value = "根据userID查询擅长知识领域", notes = "根据userID查询擅长知识领域<br><br><b>@author 李洋</b>")
    public List<KnowledgeRangeDTO> get(@ApiParam(value = "用户User_ID", required = true) @PathVariable int userID) {
    	log.debug("获取用户ID：{}", userID);
        return knowledgeService.getById(userID);
    }
}
