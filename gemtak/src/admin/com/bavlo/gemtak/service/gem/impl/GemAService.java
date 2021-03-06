package com.bavlo.gemtak.service.gem.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.model.gem.EquipmentVO;
import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.model.gem.LinkmanVO;
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


	/**
	 * 1. 修改宝石
	 * @atuhor lsk 3.15
	 */
	@Override
	public void updateGemVO(GemVO gemVO) throws Exception {
		gemVO.setTs(DateUtil.getStrTimestamp(DateUtil.getCurDateTime()));
		gemVO.setDr(IConstant.SHORT_ZERO);
		//saveOrUpdate(gemVO);
		update(gemVO);
	}

	/**
	 *2. 查询所有的宝石
	 * @author 3.15 lisuike 
	 * @see com.bavlo.gemtak.service.gem.itf.IGemService#findAllGemVO()
	 */
	@Override
	public List<GemVO> findAllGemVO(){
		// TODO Auto-generated method stub
		return findAll(GemVO.class);
	}

	/**
	 * 3.根据id查询一个宝石
	 * @author 3.15 lisuike 
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
	 * 4. 分页查询
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

	/**
	 * 5.点击发布按钮，修改数据库字段
	 */
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

	
	/**
	 * 6.点击删除按钮，更新DR字段为1
	 */
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

	/**
	 * 7.设备上传时，传GID
	 */
	@Transactional
	@Override
	public String saveHeadAndBody(String vcode){
		String gid = null;
			GemVO gvo = new GemVO();
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
		return gid;
	}
	
	/**
	 * 8.根据供应商公司  查询供应商
	 * @param @param vcode
	 * @param @return
	 * @return Integer
	 */
	public Integer getMidByCode(String company){
		Integer mid = null;
		String conts = " ifnull(bisClose,'N')='N' and company='"+company+"'";
		EquipmentVO vo = findFirst(EquipmentVO.class, conts);
		if(vo != null){
			mid = vo.getId();
		}
		return mid;
	}

	/**
	 * 9.参数为Gid、不传方位，视角、高度、公司、重量、倍数、光源色 Integer LightType、宝石类型
	 */
	@Override
	public Boolean getGemVOByGid(String Gid,String GemtypeId,String ViewAngle,String Height,String Brand,String Weight,String Multiple)throws Exception{
		Boolean flag = false;
		
		/**
		 * 1、首先根据供应商公司全称判断是否已存在,非关闭态
		 * 2、存在，返回主表ID；
		 */
		Integer mid = getMidByCode(Brand);
		/**
		 * 3、根据传回的Gid和其他信息组织子表VO，保存
		 */
		if(mid != null){
			String conts = " ifnull(dr,'0')='0' and gid='"+Gid+"'";
			GemVO gvo = findFirst(GemVO.class, conts);
			
			if(gvo != null){
				String cond = " ifnull(bisClose,'N')='N' and id='"+mid+"'";
				EquipmentVO evo = findFirst(EquipmentVO.class, cond);
				LinkmanVO lvo = findFirst(LinkmanVO.class, " equipmentId="+mid);
				gvo.setEquipment_id(mid);
				gvo.setSupplier(lvo.getSupplier());
				gvo.setCompany(evo.getCompany());
				gvo.setSupplier_tel(lvo.getTel());
				gvo.setLocation(evo.getAddress());
				//gvo.setPosition(Direction);        方位
				gvo.setType_id(GemtypeId);
				gvo.setHeight(Height);
				gvo.setMultiple(Multiple);
				gvo.setWeight(Weight);
				gvo.setViewpoint(ViewAngle);
				//gvo.setLightType(LightType);
				try {
					update(gvo);
					flag = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return flag;
	}

	/**
	 * 10.查询出所有的宝石供应商
	 */
	@Override
	public List<EquipmentVO> getSupplier(){
		List<EquipmentVO> list = findAll(EquipmentVO.class);
		return list;
	}
	
	/**
	 * 11.根据供应商id查询供应商联系人
	 */
	@Override
	 public List<LinkmanVO> getLinkman(Integer id){
		List<LinkmanVO> linkmanlist = findAll(LinkmanVO.class,"  equipmentId="+id);
		return linkmanlist;
	  }
	
	/**
	 * 12.保存供应商
	 */
	@Override
	public void saveSupplier(EquipmentVO equipment){
		try {
			saveOrUpdate(equipment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 13.根据id查询供应商
	 */
	@Override
	public EquipmentVO getEquipmentByid(Integer id){
		EquipmentVO equipmentVO = findFirst(EquipmentVO.class, "  id="+id);
		return equipmentVO;
	}
	
	/**
	 * 14.删除
	 */
	@Override
	 public void delSupplier(Integer id){
		delete(EquipmentVO.class, id);
	}
	
	/**
	 * 15.根据id查询一个联系人
	 */
	@Override
	public LinkmanVO getLinkmanByid(Integer id){
		LinkmanVO linkman = findFirst(LinkmanVO.class, "  id="+id);
		return linkman;
	}

	/**
	 * 16.删除联系人
	 */
	@Override
	public void delLinkman(Integer id) {
		delete(LinkmanVO.class, id);
		
	}

	/**
	 * 17.保存联系人
	 */
	@Override
	public void saveLinkman(LinkmanVO linkman) {
		try {
			saveOrUpdate(linkman);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/* (non-Javadoc)
	 * @see com.bavlo.gemtak.service.gem.itf.IGemService#saveGemInfo()
	 */
	public Integer saveGemInfo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.bavlo.gemtak.service.gem.itf.IGemService#saveGemInfoRID()
	 */
	public void saveGemInfoRID() throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.bavlo.gemtak.service.gem.itf.IGemService#updateGemInfo(java.lang.Integer)
	 */
	public void updateGemInfo(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}
}