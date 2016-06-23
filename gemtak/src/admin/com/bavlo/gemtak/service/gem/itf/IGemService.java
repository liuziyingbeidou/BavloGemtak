package com.bavlo.gemtak.service.gem.itf;

import java.util.List;

import org.springframework.ui.Model;

import com.bavlo.gemtak.model.gem.EquipmentVO;
import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.utils.CommonUtils;

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
	 * @Description:1. 新增、 修改宝石
	 * @param @param gemVO
	 * @param @throws Exception
	 * @return void
	 */
	public void updateGemVO(GemVO gemVO) throws Exception;
	
	/**
	 * lisuike 3.15
	 * @return2. 查询所有的GemVO list集合
	 * @throws Exception
	 */
	public List<GemVO> findAllGemVO();
	
	/**
	 * lisuike 3.15
	 * 3.给据id查询 一个 GemVO
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
	
	
	/**invoke**/
	/**
	 * 上传图片
	 */
	public String saveHeadAndBody(String vcode)throws Exception;
	
	/**
	 * 参数为 gid  供应商的名字、公司、电话。宝石重量、视角、颜色
	 * @param gid
	 * @return
	 */
  public Boolean getGemVOByGid(String Gid,String Direction,
			String ViewAngle,String Height,String Brand,String Weight,String Multiple,Integer LightType)throws Exception;
  
  /**
   * 查询出所有的宝石供应商
   * @return
   */
  public List<EquipmentVO> getSupplier();
  
  public void saveSupplier(EquipmentVO equipment);
  
  public EquipmentVO getEquipmentByid(Integer id);
  
  public void delSupplier(Integer id);
}


