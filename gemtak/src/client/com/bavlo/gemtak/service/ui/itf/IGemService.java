package com.bavlo.gemtak.service.ui.itf;

import java.util.List;

import org.springframework.ui.Model;

import com.bavlo.gemtak.model.gem.GemVO;

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
	 * @Description: ����GemVO
	 * @param @param gemVO
	 * @param @throws Exception
	 * @return void
	 */
	public void saveOrupdateGemVO(GemVO gemVO) throws Exception;
	
	/**
	 * lisuike 3.15
	 * @return ��ѯ���е�GemVO list����
	 * @throws Exception
	 */
	public List<GemVO> findAllGemVO();
	
	/**
	 * lisuike 3.15
	 * ����id��ѯ һ�� GemVO
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
}