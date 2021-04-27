package com.aizhixin.examination.updatequestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aizhixin.examination.updatequestion.dto.UpdateQuestionDTO;
import com.aizhixin.examination.updatequestion.service.UpdateQuestionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/v1/open/test")
@Api("修改试题API")
public class UpdateQuestionController {
	@Autowired
	private UpdateQuestionService updateQuestionService;

	@PostMapping(value = "/questionId", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "POST", value = "修改试题", notes = "修改试题<br><br><br>@author 李洋</b>")
	public boolean update(@ApiParam(value = "试题", required = true) @RequestBody UpdateQuestionDTO dto) {
		return updateQuestionService.updateQuestion(dto);
	}
}
