package com.bavlo.gemtak.service.ui.itf;

import java.util.List;

import org.springframework.ui.Model;

import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.model.ui.OrderBVO;
import com.bavlo.gemtak.model.ui.OrderVO;
import com.bavlo.gemtak.model.ui.ShoppingCarVO;

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
	 *  �޸�gemVO ��page_views�Ӷ� +1
	 * 3.15 lisuike
	 * 
	 */
	public void updateGemVOPageViews(GemVO gemVO) throws Exception;
	
	/**
	 *1. ��ӵ����ﳵ
	 * @param gemId
	 * @param userId
	 * @throws Exception
	 * lisuike 2016-3-28 ���� 11:13:45
	 */
	public void saveOrupdateShoppingCarVO(Integer gemId,String username,Integer quantity) throws Exception;
	
	/**
	 *2. �����û�����ѯ���ﳵ ����Ʒ����
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public Integer getShoppingCarNumByUname(String username) throws Exception;
	
	/**
	 *3. �����û�����ѯ���ﳵ ����Ʒ
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<GemVO> getShoppingCarListByUname(String username) throws Exception;
	
	/**
	 *4. �����û��� ���ﳵidɾ�����ﳵ ѡ�е���Ʒ
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public void delShoppingCarByGemId(String username,Integer shoppingCarid) throws Exception;
	/**
	 * 5.�����û���ɾ�����ﳵ
	 * @param username
	 * @throws Exception
	 */
	public void delShoppingCarByUname(String username) throws Exception;
	
	/**
	 * 6.��ѯ�洢��cookie�е���Ʒ��Ϣ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<GemVO> getGemByCookie(String ids) throws Exception;
	
	/**
	 * 7.��ѯ���е�GemVO list����
	 * @return 
	 * @throws Exceptionc
	 */
	public List<GemVO> findAllGemVO();
	
	
	
	/**
	 * 8.����id ��ѯһ��gemVO
	 * lisuike 3.15
	 * 
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
	 * 9.ɾ����ť
	 */
	public void updateDrGemById(Integer id) throws Exception;
	
	/**
	 * 
	 * @param sql
	 */
	public Integer getListSizeGem(String contions);
	
	/**
	 * 10.�ύ����  ���涩������
	 */
	public Integer saveOrderRelID(OrderVO orderVO) throws Exception;
	
	/**
	 * 11.�ύ����  ���涩���ӱ�
	 */
	public void saveOrderBVORelID(List<OrderBVO> orderBList) throws Exception;
	
	/**
	 * 12.���ݶ����� ��д����״̬
	 */
	public void rewriteOrderStatus(String orderno);
	
	/**
	 * 13.�����û����鶩��
	 * @param uname
	 */
	public List<OrderVO> getOrderByUname(String uname);
	
	/**
	 * 14.�����û����鶩������
	 * @param uname
	 * @return
	 */
	public Integer getOrderNoByUname(String uname);
	
	/**
	 * 15.���ݶ����Ų鱦ʯ
	 * @param uname
	 */
	public List<GemVO> getOrderGemById(String orderid);
}
