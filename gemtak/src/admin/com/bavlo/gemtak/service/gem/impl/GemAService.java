package com.bavlo.gemtak.service.gem.impl;

import org.springframework.stereotype.Service;

import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.service.gem.itf.IGemService;
import com.bavlo.gemtak.service.impl.CommonService;

/**
 * @Title: ±¦ççGemtak
 * @ClassName: GemAService 
 * @Description: ±¦Ê¯ºó¶ËService
 * @author liuzy
 * @date 2016-3-14 ÉÏÎç11:59:09
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
		//saveOrupdateGemVO(gemVO);
		//saveOrUpdate(gemVO);
		saveReID(gemVO);
	}

}
