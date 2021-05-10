package com.aizhixin.examination.questionBank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aizhixin.examination.commons.core.PageData;
import com.aizhixin.examination.questionBank.dto.BankQuestionDTO;
import com.aizhixin.examination.questionBank.dto.QueryTestDomain;
import com.aizhixin.examination.questionBank.service.QuestionBankService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/open/test/manager")
@Api("题库管理相关API")
@Slf4j
public class QuestionBankController {
	@Autowired
	private QuestionBankService questionBankService;
	
	/**
	 * 添加试题
	 * @param questionDto
	 * @return
	 */
	@PostMapping(value = "/add",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "POST", value = "添加试题",notes = "添加试题<br><br><b>@author 伍富强</b>")
	public BankQuestionDTO add(@ApiParam(value = "题干及选项", required = true)@RequestBody BankQuestionDTO questionDto) {
		log.debug("添加试题内容：{}", questionDto);
		questionBankService.add(questionDto);
		return questionDto;
	}
	
	/**
	 * 删除试题
	 * @param id
	 */
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod = "DELETE", value = "删除试题及对应的选项", notes = "删除试题及对应的选项<br><br><b>@author 伍富强</b>")
    public void delete(@ApiParam(value = "题干ID", required = true) @PathVariable String id) {
    	log.debug("删除试题ID：{}", id);
    	questionBankService.delete(id);
    }
	
	/**
	 * 修改试题
	 * @param id
	 * @param questionDto
	 * @return
	 */
	 @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(httpMethod = "PUT", value = "修改试题", notes = "修改试题<br><br><b>@author zhen.pan</b>")
	    public BankQuestionDTO update(
	    		@ApiParam(value = "题干ID", required = true) @PathVariable Integer id,
	    		@ApiParam(value = "题干ID及选项ID是必须的", required = true)@RequestBody BankQuestionDTO questionDto
	    		) {
		 questionDto.setID(id);
	    	log.debug("修改试题内容：{}", questionDto);
	    	questionBankService.update(questionDto);
	        return questionDto;
	    }
	 
	 /**
	  * 分页查询
	  * @param token
	  * @param domain
	  * @return
	  */
	 @RequestMapping(value = "/page", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(httpMethod = "POST", value = "分页查询题目信息", response = Void.class, notes = "分页查询题目信息<br><br><b>@author 郑宁</b>")
		public PageData<BankQuestionDTO> page(
				@RequestHeader("Authorization") String token,
				@ApiParam(value = "<b>选填:</b><br>keyWords:查询关键字<br>pageNumber:第几页<br>pageSize:每页数据的数目<br>") @RequestBody QueryTestDomain domain) {
			
			return questionBankService.getTestPage(domain);
		}
}
