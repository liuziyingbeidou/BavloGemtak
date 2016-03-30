package com.bavlo.gemtak.service.gem.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.alibaba.druid.sql.dialect.sqlserver.ast.SQLServerColumnDefinition.Identity;
import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.model.IdEntity;
import com.bavlo.gemtak.model.gem.EquipmentVO;
import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.service.gem.itf.IGemService;
import com.bavlo.gemtak.service.impl.CommonService;
import com.bavlo.gemtak.utils.DateUtil;

/**
 * @Title: ����Gemtak
 * @ClassName: GemAService 
 * @Description: ��ʯ���Service
 * @author liuzy
 * @date 2016-3-14 ����11:59:09
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
	 * ����id��ѯ һ��GemVO
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
	 * ��ҳ��ѯ
	 * select * from tableName where ���� limit ��ǰҳ��*ҳ������-1 , ҳ������
	 */
	@Override
	public List<GemVO> findListGem(String conditions,Integer dgpage, Integer rows,String order,String orderType) {
		List<GemVO> listvo = null;
		if(conditions != null && conditions != ""){
			listvo = findPage(GemVO.class, dgpage, rows, conditions,order, orderType);
		}
		
		return listvo;
	}

	//���������ť���޸����ݿ��ֶ�
	@Override
	public void updateGemById(Integer id,String st) throws Exception {
		String vrel = IConstant.RELEASE_S;
		if(!IConstant.RELEASE_Y.equals(st)){
			vrel = IConstant.RELEASE_Y;
		}else if(IConstant.RELEASE_Y.equals(st)){
			vrel = IConstant.RELEASE_C;
		}
		
		String[] attrname = new String[]{"is_release","releasedate"};//Ҫ���µ��ֶ�
		Object[] attrval = new Object[]{vrel,DateUtil.getStrTimestamp(DateUtil.getCurDateTime())};        //���µ�ֵ
		if(id != null){
			updateAttrs(GemVO.class, attrname, attrval, " id="+id);
		}
		
	}

	//���ɾ����ť���޸����ݿ��ֶ�
	
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

	@Override
	public Boolean saveHeadAndBody(String vcode, String vfolder){
		/**
		 * 1�����ȸ����豸���ж��Ƿ��Ѵ���,�ǹر�̬
		 * 2�����ڣ���������ID�����򣬱��淵��ID
		 */
		Integer mid = getMidByCode(vcode);
		/**
		 * 3����������ID��������Ϣ��֯�ӱ�VO������
		 */
		if(mid != null){
			GemVO gvo = new GemVO();
			gvo.setEquipment_id(mid);
			gvo.setUrl_360(vfolder);
			gvo.setPower(IConstant.POWER_A);
			gvo.setPage_views(0);
			gvo.setIs_release(IConstant.RELEASE_E);
			gvo.setCreatedate(DateUtil.getStrTimestamp(DateUtil.getCurDate()));
			gvo.setIs_cover(IConstant.PIC_COVER);
			try {
				save(gvo);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @Description: �����豸��vcode,��ȡ��������id
	 * @param @param vcode
	 * @param @return
	 * @return Integer
	 */
	public Integer getMidByCode(String vcode){
		Integer mid = null;
		String conts = " ifnull(bisClose,N)=N and vcode='"+vcode+"'";
		EquipmentVO vo = findFirst(EquipmentVO.class, conts);
		if(vo == null){
			EquipmentVO evo = new EquipmentVO();
			evo.setVcode(vcode);
			evo.setCreatedate(DateUtil.getStrTimestamp(DateUtil.getCurDate()));
			evo.setBisClose("N");
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
	
}
