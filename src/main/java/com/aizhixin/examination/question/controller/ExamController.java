package com.aizhixin.examination.question.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aizhixin.examination.question.dto.QuestionDTO;
import com.aizhixin.examination.question.service.QuestionService;
import com.aizhixin.examination.question.utils.IdQuestonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/open/test")
@Api("随机选题API")
public class ExamController {
	@Autowired
	private QuestionService questionService;

	@GetMapping(value = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "GET", value = "随机选题", notes = "随机选题<br><br><br>@author Fuqiang.Wu</b>")
	public QuestionDTO get() {
		return questionService.getByRandom(IdQuestonUtil.getQuestionId());
	}
}
