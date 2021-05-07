package com.aizhixin.examination.rank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aizhixin.examination.rank.dao.RankDAO;
import com.aizhixin.examination.rank.dto.RankINFODTO;

@Service
@Transactional
public class RankService {

	@Autowired
	private RankDAO rank_dao;

	/**
	 * 
	 * @Title: findRanking
	 * @version:V0.1
	 * @return:List<TotalCollcetSubject>
	 */
	public List<RankINFODTO> Rank() {
		return rank_dao.Rank();
	}

}
