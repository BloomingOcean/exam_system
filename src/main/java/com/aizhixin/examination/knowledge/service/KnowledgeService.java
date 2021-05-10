package com.aizhixin.examination.knowledge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aizhixin.examination.knowledge.dao.KnowledgeDAO;
import com.aizhixin.examination.knowledge.dto.KnowledgeRangeDTO;


@Service
@Transactional
public class KnowledgeService {
	
	@Autowired
	private KnowledgeDAO knowledgeDao;
	
	@Transactional (readOnly = true)
	public List<KnowledgeRangeDTO> getById(int userID) {
		//通过查找得到 小于等于3个的最擅长知识领域
		List<KnowledgeRangeDTO> KnowledgeRangeDto = knowledgeDao.findById(userID);
		return KnowledgeRangeDto;
	}
}
