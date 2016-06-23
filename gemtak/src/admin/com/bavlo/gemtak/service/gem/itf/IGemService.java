package com.bavlo.gemtak.service.gem.itf;

import java.util.List;

import org.springframework.ui.Model;

import com.bavlo.gemtak.model.gem.EquipmentVO;
import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.utils.CommonUtils;

/**
 * @Title: ����Gemtak
 * @ClassName: IGemService 
 * @Description: ��ʯ ����ӿ�
 * @author liuzy
 * @date 2016-1-30 ����12:14:02
 */
public interface IGemService {

	/**
	 * @Description: ���汦ʯ��Ϣ������ID
	 * @param @return
	 * @param @throws Exception
	 * @return Integer
	 */
	public Integer saveGemInfo() throws Exception;
	
	/**
	 * @Description: ���汦ʯ��Ϣ
	 * @param @throws Exception
	 * @return void
	 */
	public void saveGemInfoRID() throws Exception;
	
	/**
	 * @Description: ����ID��������
	 * @param @param id
	 * @param @throws Exception
	 * @return void
	 */
	public void updateGemInfo(Integer id) throws Exception;
	
	/**
	 * @Description:1. ������ �޸ı�ʯ
	 * @param @param gemVO
	 * @param @throws Exception
	 * @return void
	 */
	public void updateGemVO(GemVO gemVO) throws Exception;
	
	/**
	 * lisuike 3.15
	 * @return2. ��ѯ���е�GemVO list����
	 * @throws Exception
	 */
	public List<GemVO> findAllGemVO();
	
	/**
	 * lisuike 3.15
	 * 3.����id��ѯ һ�� GemVO
	 */
	public GemVO findGemVOByID(Integer id);
	
	/**
	 * lisuike 3.16
	 * @return ��ѯ���е�GemVO list����
	 * @throws Exception
	 */
	public List<GemVO> findAllGemVO(String sql,Integer pageNo,Integer pageSize);
	
	/**
	 * @param sql
	 * @param dgpage
	 * @param rows
	 * @return
	 */
	public List<GemVO> findListGem(String contions,Integer dgpage,Integer rows,String order,String orderType);

	/**
	 * ����id����
	 * @param id
	 */
	public void updateGemById(Integer id,String st) throws Exception;
	
	/**
	 * ɾ����ť
	 */
	public void updateDrGemById(Integer id) throws Exception;
	
	/**
	 * ����
	 * @param sql
	 */
	public Integer getListSizeGem(String contions);
	
	
	/**invoke**/
	/**
	 * �ϴ�ͼƬ
	 */
	public String saveHeadAndBody(String vcode)throws Exception;
	
	/**
	 * ����Ϊ gid  ��Ӧ�̵����֡���˾���绰����ʯ�������ӽǡ���ɫ
	 * @param gid
	 * @return
	 */
  public Boolean getGemVOByGid(String Gid,String Direction,
			String ViewAngle,String Height,String Brand,String Weight,String Multiple,Integer LightType)throws Exception;
  
  /**
   * ��ѯ�����еı�ʯ��Ӧ��
   * @return
   */
  public List<EquipmentVO> getSupplier();
  
  public void saveSupplier(EquipmentVO equipment);
  
  public EquipmentVO getEquipmentByid(Integer id);
  
  public void delSupplier(Integer id);
}


