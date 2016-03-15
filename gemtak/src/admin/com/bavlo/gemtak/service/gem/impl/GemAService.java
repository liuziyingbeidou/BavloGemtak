package com.bavlo.gemtak.service.gem.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.service.gem.itf.IGemService;
import com.bavlo.gemtak.service.impl.CommonService;
import com.bavlo.gemtak.utils.DateUtil;
import com.bavlo.gemtak.utils.DateUtils;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: GemAService 
 * @Description: 宝石后端Service
 * @author liuzy
 * @date 2016-3-14 上午11:59:09
 */
@Service
public class GemAService extends CommonService implements IGemService {

	@Override
	public Integer saveGemInfo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveGemInfoRID() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateGemInfo(Integer id) throws Exception {
		// TODO Auto-generated method stub

	
	}

	/*
	 * 3.15 lisuike
	 * @see com.bavlo.gemtak.service.gem.itf.IGemService#saveGemVO(com.bavlo.gemtak.model.gem.GemVO)
	 */
	@Override
	public void saveOrupdateGemVO(GemVO gemVO) throws Exception {
		gemVO.setTs(DateUtil.getStrTimestamp(DateUtil.getCurDateTime()));
		//saveOrUpdate(gemVO);
		saveReID(gemVO);
	}

	/*
	 * 3.15 lisuike
	 * @see com.bavlo.gemtak.service.gem.itf.IGemService#findAllGemVO()
	 */
	@Override
	public List<GemVO> findAllGemVO(){
		// TODO Auto-generated method stub
		return findAll(GemVO.class);
	}

	/**
	 * 3.15 lisuike
	 * 给据id查询 一个GemVO
	 */
	@Override
	public GemVO findGemVOByID(Integer id) {
		// TODO Auto-generated method stub
		return findFirst(GemVO.class, id.toString());
	}

	
	
	
	
}
