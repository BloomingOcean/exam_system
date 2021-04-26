package com.aizhixin.examination.addquestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aizhixin.examination.addquestion.dto.AddQuestionDTO;
import com.aizhixin.examination.addquestion.service.AddQuestionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/open/test")
@Api("添加试题API")
@Slf4j
public class AddQuestionController {

	@Autowired
	private AddQuestionService addQuestionService;
	
	@PostMapping(value = "/addquestion", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "POST", value = "储存一道题目", notes = "储存一道题目<br><br><b>@author 李洋</b>")
	public boolean set(
			@ApiParam(value = "题目信息DTO", required = true,type="QuestionDTO") @RequestBody AddQuestionDTO addQuestionDTO) {
		log.debug("获取题目信息：{}", addQuestionDTO);

		// 输出题目
		System.out.println(addQuestionDTO.toString());
		
		return addQuestionService.addQuestion(addQuestionDTO);
}}
