package com.bavlo.gemtak.service.ui.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.alibaba.druid.sql.dialect.sqlserver.ast.SQLServerColumnDefinition.Identity;
import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.model.IdEntity;
import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.service.ui.itf.IGemService;
import com.bavlo.gemtak.service.impl.CommonService;
import com.bavlo.gemtak.utils.DateUtil;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: GemAService 
 * @Description: 宝石后端Service
 * @author liuzy
 * @date 2016-3-14 上午11:59:09
 */
@Service
public class GemCService extends CommonService implements IGemService {

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

	@Override
	public List<GemVO> findAllGemVO(String sql, Integer pageNo, Integer pageSize) {
		return null;
	}

	
	/**
	 * 分页查询
	 * select * from tableName where 条件 limit 当前页码*页面容量-1 , 页面容量
	 */
	@Override
	public List<GemVO> findListGem(String conditions,Integer dgpage, Integer rows,String order,String orderType) {
		List<GemVO> listvo = null;
		if(conditions != null && conditions != ""){
			listvo = findPage(GemVO.class, dgpage, rows, conditions,order, orderType);
		}
		
		return listvo;
	}

	//点击发布按钮，修改数据库字段
	@Override
	public void updateGemById(Integer id,String st) throws Exception {
		String vrel = IConstant.RELEASE_S;
		if(!IConstant.RELEASE_Y.equals(st)){
			vrel = IConstant.RELEASE_Y;
		}else if(IConstant.RELEASE_Y.equals(st)){
			vrel = IConstant.RELEASE_C;
		}
		
		String[] attrname = new String[]{"is_release","releasedate"};//要更新的字段
		Object[] attrval = new Object[]{vrel,DateUtil.getStrTimestamp(DateUtil.getCurDateTime())};        //更新的值
		if(id != null){
			updateAttrs(GemVO.class, attrname, attrval, " id="+id);
		}
		
	}

	//点击删除按钮，修改数据库字段
	
	public void updateDrGemById(Integer id) throws Exception {
		if(id != null){
			String[] attrname = new String[]{"dr"};
			Short[] attrval = new Short[]{1};
			if(id != null){
				updateAttrs(GemVO.class, attrname, attrval, " id="+id);
			}
			
		}
		
	}

	@Override
	public Integer getListSizeGem(String contions) {
		return getCountByHQL(GemVO.class, contions);
	}
	
	
	
}
