package com.aizhixin.examination.answerrecord.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aizhixin.examination.answerrecord.dto.RecordQuestionDTO;
import com.aizhixin.examination.answerrecord.service.AnswerRecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/open/user/AnswerRecord")
@Api("查询答题详细记录API")
@Slf4j
public class AnswerRecordController {

	@Autowired
	private AnswerRecordService answerRecordService;
	
	/**
	 * 查询答题详细记录
	 * 
	 */
	@GetMapping(value = "/{AnswerRecord}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "GET",value = "查询关于用户的详细答题记录",notes = "查询关于用户的详细答题记录<br><br><b>@author 李洋)</b>")
	
	public List<RecordQuestionDTO>findAnswers(@ApiParam(value = "用户ID", required = true) @PathVariable("AnswerRecord") int userid){
		log.debug("用户的userid：{}", userid);
		return answerRecordService.findAnswers(userid);
	}

}
