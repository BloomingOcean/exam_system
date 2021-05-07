package com.aizhixin.examination.rank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aizhixin.examination.rank.dto.RankINFODTO;
import com.aizhixin.examination.rank.service.RankService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/open/user")
@Api("总分排行榜API")
//@Slf4j
public class rankController {

	@Autowired
	private RankService rankService;

	@GetMapping(value = "/rank", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "GET", value = "总分排行榜", notes = "按总分降序排序<br><br><b>@author 李洋</b>")
	public List<RankINFODTO> getrank() {
		return rankService.Rank();
	}
}
