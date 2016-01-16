package itf;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.CustomerVO;

/**
 * @Title: ����Counter
 * @ClassName: ICustomerService
 * @Description: �ͻ��ӿ�
 * @author shijf
 * @date 2015-10-20 ����04:12:56
 */
public interface ICustomerService {

	/**
	 * @Description: ����ͻ�
	 * @param
	 * @return void
	 */
	public void saveCustomer(CustomerVO customerVO);

	/**
	 * @Description: ɾ���ͻ�
	 * @param
	 * @return void
	 */
	public void deleteCustomer(CustomerVO customerVO);

	/**
	 * @Description: ���¿ͻ�
	 * @param
	 * @return void
	 */
	public void updateCustomer(CustomerVO customerVO);
	
	/**
	 * @Description: ���¿ͻ�
	 * @param
	 * @return void
	 */
	public void saveOrUpdateCustomer(CustomerVO customerVO);

	/**
	 * @Description: ͨ��ID���ҿͻ�
	 * @param @return
	 * @return CustomerVO
	 */
	public CustomerVO findCustomerById(Integer id);

	/**
	 * @Description: ͨ���������ҿͻ�
	 * @param @return
	 * @return List<CustomerVO>
	 */
	public List<CustomerVO> findCustomerByWh();

	/**
	 * @Description: ���ҿͻ��б�
	 * @param @return
	 * @return List<CustomerVO>
	 */
	public List<CustomerVO> findCustomerList(String wh);
	
	//***��������Χ�ӿ�----��ʼ****/
	/**
	 * �����������ң�������Ƿ����
	 */
	public boolean isExistByCondition(String condition);

	/**
	 * @Description: ɨ�������ͻ�
	 * @param @param openId
	 * @param @param session
	 * @param @param scene_str
	 * @param @return
	 * @return String
	 */
	public String addCustomerByScan(String openId,HttpSession session,String scene_str);
	
	/**
	 * @Description: ��ѯ�ͻ���Ϣ
	 * @param @param condition
	 * @param @return
	 * @return CustomerVO
	 */
	public CustomerVO findCustomerByWhere(String condition);
	
	/**
	 * @Description: ����id����ĳЩֵ
	 * @param @param id
	 * @param @param attrFiled
	 * @param @param attrValue
	 * @return void
	 */
	public void updateCustomerByCondition(String conditions,String[] attrFiled,String[] attrValue);
	//***��������Χ�ӿ�----����****/
}
