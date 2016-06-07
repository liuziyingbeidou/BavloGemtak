package com.bavlo.gemtak.service.gem.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.alibaba.druid.sql.dialect.sqlserver.ast.SQLServerColumnDefinition.Identity;
import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.model.IdEntity;
import com.bavlo.gemtak.model.gem.EquipmentVO;
import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.service.gem.itf.IGemService;
import com.bavlo.gemtak.service.impl.CommonService;
import com.bavlo.gemtak.utils.CommonUtils;
import com.bavlo.gemtak.utils.DateUtil;

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
	 * 3.15 lisuike  新增、修改宝石
	 * @see com.bavlo.gemtak.service.gem.itf.IGemService#saveGemVO(com.bavlo.gemtak.model.gem.GemVO)
	 */
	@Override
	public void updateGemVO(GemVO gemVO) throws Exception {
		gemVO.setTs(DateUtil.getStrTimestamp(DateUtil.getCurDateTime()));
		//gemVO.setDr(IConstant.SHORT_ZERO);
		//saveOrUpdate(gemVO);
		update(gemVO);
	}

	/**
	 * 3.15 lisuike 查询所有的宝石
	 * @see com.bavlo.gemtak.service.gem.itf.IGemService#findAllGemVO()
	 */
	@Override
	public List<GemVO> findAllGemVO(){
		// TODO Auto-generated method stub
		return findAll(GemVO.class);
	}

	/**
	 * 3.15 lisuike 根据id查询 一个GemVO
	 * 
	 */
	@Override
	public GemVO findGemVOByID(Integer id) {
		// TODO Auto-generated method stub
		return findFirst(GemVO.class, " id="+id.toString());
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

	
	//点击删除按钮，更新DR字段为1
	public void updateDrGemById(Integer id) throws Exception {
		if(id != null){
			String[] attrname = new String[]{"dr"};
			Short[] attrval = new Short[]{1};
			updateAttrs(GemVO.class, attrname, attrval, " id="+id);
		}
		
	}

	@Override
	public Integer getListSizeGem(String contions) {
		return getCountByHQL(GemVO.class, contions);
	}

	@Transactional
	@Override
	public String saveHeadAndBody(String vcode, Integer equipmentId){
		String gid = null;
		/**
		 * 1、首先根据供应商ID号判断是否已存在,非关闭态
		 * 2、存在，返回主表ID；否则，保存返回ID
		 */
		Integer mid = getMidByCode(equipmentId);
		/**
		 * 3、根据主表ID和其他信息组织子表VO，保存
		 */
		if(mid != null){
			GemVO gvo = new GemVO();
			gvo.setEquipment_id(mid);
			gvo.setGid(CommonUtils.getGidCode("GID"));
			gvo.setUrl_360(CommonUtils.getGidCode("GID"));
			gvo.setVcode(vcode);
			gvo.setPower(IConstant.POWER_A);
			gvo.setPage_views(0);
			gvo.setIs_release(IConstant.RELEASE_E);
			gvo.setCreatedate(DateUtil.getStrTimestamp(DateUtil.getCurDateTime()));
			gvo.setIs_cover(IConstant.PIC_COVER);
			gvo.setDr(IConstant.SHORT_ZERO);
			gvo.setTs(DateUtil.getCurTimestamp());
			try {
				save(gvo);
				gid = CommonUtils.getGidCode("GID");
			} catch (Exception e) {
				e.printStackTrace();
				gid = null;
			}
		}
		return gid;
	}
	
	/**
	 * @Description: 根据供应商ID 查询 如果为空新增一条
	 * @param @param vcode
	 * @param @return
	 * @return Integer
	 */
	public Integer getMidByCode(Integer equipmentId){
		Integer mid = null;
		String conts = " ifnull(bisClose,'N')='N' and id='"+equipmentId+"'";
		EquipmentVO vo = findFirst(EquipmentVO.class, conts);
		if(vo == null){
			EquipmentVO evo = new EquipmentVO();
			evo.setCreatedate(DateUtil.getCurTimestamp());
			evo.setBisClose("N");
			evo.setDr(IConstant.SHORT_ZERO);
			evo.setTs(DateUtil.getCurTimestamp());
			try {
				mid = saveReID(evo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			mid = vo.getId();
		}
		return mid;
	}

	//参数为 gid  宝石重量、视角、颜色
	@Override
	public Boolean getGemVOByGid(String gid,String weight,String viewpoint,String average_color)throws Exception{
		Boolean flag = false;
		String conts = " ifnull(dr,'0')='0' and gid='"+gid+"'";
		GemVO vo = findFirst(GemVO.class, conts);
		if(vo != null){
			String econts = " ifnull(bisClose,'N')='N' and id='"+vo.getEquipment_id()+"'";
			EquipmentVO evo = findFirst(EquipmentVO.class, econts);
			vo.setSupplier_code(evo.getVsupplierCode());
			vo.setCompany(evo.getCompany());
			vo.setSupplier_tel(evo.getTel());
			vo.setLocation(evo.getAddress());
		    vo.setWeight(weight);
		    vo.setViewpoint(viewpoint);
		    vo.setAverage_color(average_color);
			try {
				update(vo);
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		return flag;
	}

}