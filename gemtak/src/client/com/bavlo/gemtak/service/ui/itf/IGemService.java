package com.bavlo.gemtak.service.ui.itf;

import java.util.List;

import org.springframework.ui.Model;

import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.model.ui.OrderBVO;
import com.bavlo.gemtak.model.ui.OrderVO;
import com.bavlo.gemtak.model.ui.ShoppingCarVO;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: IGemService 
 * @Description: 宝石 服务接口
 * @author liuzy
 * @date 2016-1-30 下午12:14:02
 */
public interface IGemService {

	/**
	 * @Description: 保存宝石信息并返回ID
	 * @param @return
	 * @param @throws Exception
	 * @return Integer
	 */
	public Integer saveGemInfo() throws Exception;
	
	/**
	 * @Description: 保存宝石信息
	 * @param @throws Exception
	 * @return void
	 */
	public void saveGemInfoRID() throws Exception;
	
	/**
	 * @Description: 根据ID更新数据
	 * @param @param id
	 * @param @throws Exception
	 * @return void
	 */
	public void updateGemInfo(Integer id) throws Exception;
	
	/**
	 * @Description: 新增GemVO
	 * @param @param gemVO
	 * @param @throws Exception
	 * @return void
	 */
	public void saveOrupdateGemVO(GemVO gemVO) throws Exception;
	
	/**
	 *1. 添加到购物车
	 * @param gemId
	 * @param userId
	 * @throws Exception
	 * lisuike 2016-3-28 上午 11:13:45
	 */
	public void saveOrupdateShoppingCarVO(Integer gemId,String username,Integer quantity) throws Exception;
	
	/**
	 *2. 根据用户名查询购物车 的商品数量
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public Integer getShoppingCarNumByUname(String username) throws Exception;
	
	/**
	 *3. 根据用户名查询购物车 的商品
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<GemVO> getShoppingCarListByUname(String username) throws Exception;
	
	/**
	 *4. 根据用户名 购物车id删除购物车 选中的商品
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public void delShoppingCarByGemId(String username,Integer shoppingCarid) throws Exception;
	
	public void delShoppingCarByUname(String username) throws Exception;
	
	/**
	 * 5.查询存储到cookie中的商品信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<GemVO> getGemByCookie(String ids) throws Exception;
	
	/**
	 * 
	 * @return 查询所有的GemVO list集合
	 * @throws Exceptionc
	 */
	public List<GemVO> findAllGemVO();
	
	/**
	 * lisuike 3.15
	 * 给据id查询 一个 GemVO
	 */
	public GemVO findGemVOByID(Integer id);
	
	/**
	 * lisuike 3.16
	 * @return 查询所有的GemVO list集合
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
	 * 根据id更新
	 * @param id
	 */
	public void updateGemById(Integer id,String st) throws Exception;
	
	/**
	 * 删除按钮
	 */
	public void updateDrGemById(Integer id) throws Exception;
	
	/**
	 * 根据
	 * @param sql
	 */
	public Integer getListSizeGem(String contions);
	
	/**
	 * 6.提交订单  保存订单主表
	 */
	public Integer saveOrderRelID(OrderVO orderVO) throws Exception;
	
	/**
	 * 7.提交订单  保存订单子表
	 */
	public void saveOrderBVORelID(List<OrderBVO> orderBList) throws Exception;
	
	/**
	 * 8.根据订单号 改写订单状态
	 */
	public void rewriteOrderStatus(String orderno);
}
