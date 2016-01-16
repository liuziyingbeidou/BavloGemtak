package itf;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.CustomerVO;

/**
 * @Title: 宝珑Counter
 * @ClassName: ICustomerService
 * @Description: 客户接口
 * @author shijf
 * @date 2015-10-20 下午04:12:56
 */
public interface ICustomerService {

	/**
	 * @Description: 保存客户
	 * @param
	 * @return void
	 */
	public void saveCustomer(CustomerVO customerVO);

	/**
	 * @Description: 删除客户
	 * @param
	 * @return void
	 */
	public void deleteCustomer(CustomerVO customerVO);

	/**
	 * @Description: 更新客户
	 * @param
	 * @return void
	 */
	public void updateCustomer(CustomerVO customerVO);
	
	/**
	 * @Description: 更新客户
	 * @param
	 * @return void
	 */
	public void saveOrUpdateCustomer(CustomerVO customerVO);

	/**
	 * @Description: 通过ID查找客户
	 * @param @return
	 * @return CustomerVO
	 */
	public CustomerVO findCustomerById(Integer id);

	/**
	 * @Description: 通过条件查找客户
	 * @param @return
	 * @return List<CustomerVO>
	 */
	public List<CustomerVO> findCustomerByWh();

	/**
	 * @Description: 查找客户列表
	 * @param @return
	 * @return List<CustomerVO>
	 */
	public List<CustomerVO> findCustomerList(String wh);
	
	//***以下是外围接口----开始****/
	/**
	 * 根据条件查找，结果集是否存在
	 */
	public boolean isExistByCondition(String condition);

	/**
	 * @Description: 扫描新增客户
	 * @param @param openId
	 * @param @param session
	 * @param @param scene_str
	 * @param @return
	 * @return String
	 */
	public String addCustomerByScan(String openId,HttpSession session,String scene_str);
	
	/**
	 * @Description: 查询客户信息
	 * @param @param condition
	 * @param @return
	 * @return CustomerVO
	 */
	public CustomerVO findCustomerByWhere(String condition);
	
	/**
	 * @Description: 根据id更新某些值
	 * @param @param id
	 * @param @param attrFiled
	 * @param @param attrValue
	 * @return void
	 */
	public void updateCustomerByCondition(String conditions,String[] attrFiled,String[] attrValue);
	//***以下是外围接口----结束****/
}
