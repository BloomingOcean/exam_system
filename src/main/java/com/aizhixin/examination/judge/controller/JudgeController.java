package com.aizhixin.examination.judge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aizhixin.examination.judge.dto.InputDTO;
import com.aizhixin.examination.judge.service.JudgeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController 
@RequestMapping("/v1/open/test/judge")
@Api("返回用户答题后的分数API")
public class JudgeController {

	@Autowired
	private JudgeService judgeService;
	
	/**
	 *提交答案（判断正确更新答题记录数据）
	 * @version  0.3
	 * @param	后台需要利用或者存储的信息
	 * @return	用户做题之后的分数
	 */
	@PostMapping(value = "/{True(or)False}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "POST",value = "前端传入用户答题数据，后端进行数据库数据更改并返回用户的分数）",notes = "需传入Input对象的数据<br><br><b>@author 李洋</b>")
	public int judge(@ApiParam(value = "提交对象*必填",required = true) @RequestBody InputDTO inputDTO) {
			return judgeService.returnScore(inputDTO);
	}
}
