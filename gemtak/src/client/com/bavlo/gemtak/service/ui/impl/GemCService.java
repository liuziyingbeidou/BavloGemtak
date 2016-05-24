package com.bavlo.gemtak.service.ui.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.sql.dialect.sqlserver.ast.SQLServerColumnDefinition.Identity;
import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.model.IdEntity;
import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.model.ui.OrderBVO;
import com.bavlo.gemtak.model.ui.OrderVO;
import com.bavlo.gemtak.model.ui.ShoppingCarVO;
import com.bavlo.gemtak.service.ui.itf.IGemService;
import com.bavlo.gemtak.service.impl.CommonService;
import com.bavlo.gemtak.utils.CommonUtils;
import com.bavlo.gemtak.utils.DateUtil;
import com.bavlo.gemtak.utils.ObjectToJSON;
import com.bavlo.gemtak.web.BaseController;
import com.google.zxing.common.StringUtils;

/**
 * @Title: ����Gemtak
 * @ClassName: GemAService 
 * @Description: ��ʯ���Service
 * @author liuzy
 * @date 2016-3-14 ����11:59:09
 */
@SuppressWarnings("unchecked")
@Service
public class GemCService extends CommonService implements IGemService {

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

	/**
	 *  ����GemVO
	 * 3.15 lisuike
	 * @see com.bavlo.gemtak.service.gem.itf.IGemService#saveGemVO(com.bavlo.gemtak.model.gem.GemVO)
	 */
	@Override
	public void saveOrupdateGemVO(GemVO gemVO) throws Exception {
		gemVO.setTs(DateUtil.getStrTimestamp(DateUtil.getCurDateTime()));
		//saveOrUpdate(gemVO);
		saveReID(gemVO);
	}

	/**
	 *  �޸�gemVO ��page_views�Ӷ� +1
	 * 3.15 lisuike
	 * 
	 */
	@Override
	public void updateGemVOPageViews(GemVO gemVO) throws Exception {
		if(gemVO.getPage_views() == null){
			gemVO.setPage_views(0);
		}
		gemVO.setPage_views(gemVO.getPage_views()+1);
		//saveOrUpdate(gemVO);
		update(gemVO);
	}
	
	/**
	 * ��ѯ���� ��ʯ
	 * 3.15 lisuike
	 * @see com.bavlo.gemtak.service.gem.itf.IGemService#findAllGemVO()
	 */
	@Override
	public List<GemVO> findAllGemVO(){
		// TODO Auto-generated method stub
		return findAll(GemVO.class);
	}

	/**
	 * ����id��ѯ һ��GemVO
	 * 3.15 lisuike
	 * 
	 */
	@Override
	public GemVO findGemVOByID(Integer id) {
		if(id != null){
			return findFirst(GemVO.class, " id="+id);
		}
		return null;
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
		List<GemVO> listvo = new ArrayList<GemVO>();
		if(conditions != null && conditions != ""){
			listvo = findPage(GemVO.class, dgpage, rows, conditions,order, orderType);
		}
		return listvo;
	}

	
	/**
	 * ���������ť���޸����ݿ��ֶ�
	 */
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

	/**
	 * ���ɾ����ť���޸����ݿ��ֶ�
	 */
	public void updateDrGemById(Integer id) throws Exception {
		if(id != null){
			String[] attrname = new String[]{"dr"};
			Short[] attrval = new Short[]{1};
			if(id != null){
				updateAttrs(GemVO.class, attrname, attrval, " id="+id);
			}
		}
	}

	/**
	 * ��ѯ��ʯ����
	 * @param sql
	 * @return
	 */
	@Override
	public Integer getListSizeGem(String typegem,String shapegem,String fromWeight,String toWeight,String fromPrice,String toPrice,String inwhere,String inwheres) {
		if(CommonUtils.isNull(typegem) && CommonUtils.isNull(shapegem) && CommonUtils.isNull(fromWeight) && CommonUtils.isNull(toWeight)
				&& CommonUtils.isNull(fromPrice) && CommonUtils.isNull(toPrice) && CommonUtils.isNull(inwhere) && CommonUtils.isNull(inwheres)){
			return getCountByHQL(GemVO.class);
		}else{
			StringBuilder sql = new StringBuilder(" 1=1");
			if((!CommonUtils.isNull(typegem)) && (!"a".equals(typegem))){
				sql.append( " and type_id = '"+typegem+"'");
			}
			if((!CommonUtils.isNull(shapegem)) && (!"a".equals(shapegem))){
				sql.append(" and shape_id = '"+shapegem+"'");
			}
			if(!CommonUtils.isNull(fromWeight) && !CommonUtils.isNull(toWeight)){
				sql.append(" and weight between "+fromWeight+" and "+toWeight+"");
			}
			if(!CommonUtils.isNull(fromPrice) && !CommonUtils.isNull(toPrice)){
				sql.append(" and retail_price between "+fromPrice+" and "+toPrice+"");
			}
			
			if(!CommonUtils.isNull(inwhere)){
				sql.append(" and pairs in ("+inwhere+")");
			}
			//��״ ���ȡ�����
			if(!CommonUtils.isNull(inwheres)){
				sql.append(" and pairs in ("+inwheres+")");
			}
			return getCountByHQL(GemVO.class, sql+"");
		}
		
		
	}

	/**
	 *1. ��ӵ����ﳵ
	 * @param gemId
	 * @param userId
	 * @throws Exception
	 * lisuike 2016-3-28 ���� 11:13:45
	 */
	@Override
	public void saveOrupdateShoppingCarVO(Integer gemId, String username,Integer quantity)
			throws Exception {
		ShoppingCarVO carVO = new ShoppingCarVO();
		carVO.setGem_id(gemId);
		carVO.setUser_name(username);
		carVO.setQuantity(quantity);
		save(carVO);
	}
    
	/**
	 *2. �����û�����ѯ���ﳵ ����Ʒ����
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public Integer getShoppingCarNumByUname(String username) throws Exception {
		return getCountByHQL(ShoppingCarVO.class, "user_name='"+username+"'");
	}

	/**
	 *3. �����û�����ѯ���ﳵ ����Ʒ
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<GemVO> getShoppingCarListByUname(String username)
			throws Exception {
		StringBuilder sql = new StringBuilder();
	    sql.append("select ");
	    sql.append(" g.id, g.type_cn,g.weight,g.company,g.shape_cn,g.size_l,g.size_w,g.size_h,g.average_color,g.clarity_cn,g.cut_cn," +
	    		"g.origin_cn,g.treatment_cn,g.lab_cn,g.supplier,g.retail_price,g.trade_price, s.quantity as vdef1,s.id as vdef2");
	    sql.append(" from gt_shopping s");
	    sql.append(" left join gt_gem g");
	    sql.append(" on s.gem_id=g.id");
	    sql.append("  where s.user_name='"+username+"'");
	    sql.append("  and ifnull(g.dr,0)=0");
	    sql.append(" order by s.id desc");
	    Integer count = getCountBySQL(sql.toString());
	    List<GemVO> list = (List<GemVO>) findListBySQL(sql.toString(), null, 0, count);
	    List<GemVO> nlist = new ArrayList<GemVO>();
	    if(list != null){
	    	String jsonStr = ObjectToJSON.writeListJSON(list);
	    	JSONArray jsonArr = JSONArray.fromObject(jsonStr);
	    	int size = jsonArr.size();
	    	for(int i = 0; i < size; i++){
	    		GemVO gem = new GemVO();
	    		Object [] arry = jsonArr.getJSONArray(i).toArray();
	    		Integer id = CommonUtils.isNull(arry[0]) ? null:Integer.valueOf(arry[0]+"");
	    		gem.setId(id);
	    		gem.setType_cn(CommonUtils.isNull(arry[1]) ? null:arry[1]+"");
	    		gem.setWeight(CommonUtils.isNull(arry[2]) ? null:arry[2]+"");
	    		gem.setCompany(CommonUtils.isNull(arry[3]) ? null:arry[3]+"");
	    		gem.setShape_cn(CommonUtils.isNull(arry[4]) ? null:arry[4]+"");
	    		gem.setSize_l(CommonUtils.isNull(arry[5]) ? null:arry[5]+"");
	    		gem.setSize_w(CommonUtils.isNull(arry[6]) ? null:arry[6]+"");
	    		gem.setSize_h(CommonUtils.isNull(arry[7]) ? null:arry[7]+"");
	    		gem.setAverage_color(CommonUtils.isNull(arry[8]) ? null:arry[8]+"");
	    		gem.setClarity_cn(CommonUtils.isNull(arry[9]) ? null:arry[9]+"");
	    		gem.setCut_cn(CommonUtils.isNull(arry[10]) ? null:arry[10]+"");
	    		gem.setOrigin_cn(CommonUtils.isNull(arry[11]) ? null:arry[11]+"");
	    		gem.setTreatment_cn(CommonUtils.isNull(arry[12]) ? null:arry[12]+"");
	    		gem.setLab_cn(CommonUtils.isNull(arry[13]) ? null:arry[13]+"");
	    		gem.setSupplier(CommonUtils.isNull(arry[14]) ? null:arry[14]+"");
	    		gem.setRetail_price(CommonUtils.isNull(arry[15]) ? null:Double.valueOf(arry[15]+""));
	    		gem.setTrade_price(CommonUtils.isNull(arry[16]) ? null:Double.valueOf(arry[16]+""));
	    		gem.setVdef1(CommonUtils.isNull(arry[17]) ? null:arry[17]+"");
	    		gem.setVdef2(CommonUtils.isNull(arry[18]) ? null:arry[18]+"");
	    		nlist.add(gem);
	    	}
	    }
		return nlist;
	}

	/**
	 *4. �����û��� ���ﳵidɾ�����ﳵ ѡ�е���Ʒ
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public void delShoppingCarByGemId(String username, Integer shoppingCarid)
			throws Exception {
		delete(ShoppingCarVO.class, shoppingCarid);
	}

	/**
	 * 6.��ѯ�洢��cookie�е���Ʒ��Ϣ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<GemVO> getGemByCookie(String ids) throws Exception {
		List<GemVO> gemList = null;
		if(!"".equals(ids)){
			gemList = findAll(GemVO.class, " id in("+ids+")");
		}
	    return gemList;
	}

	/**
	 * 6.�ύ����  ���涩������
	 */
	@Override
	public Integer saveOrderRelID(OrderVO orderVO) throws Exception {
		orderVO.setStatus("N");
		orderVO.setCreated(DateUtil.getStrTimestamp(DateUtil.getCurDateTime()));
		Integer id  = saveReID(orderVO);
		return id;
	}

	/**
	 * 7.�ύ����  ���涩���ӱ�
	 */
	@Override
	public void saveOrderBVORelID(List<OrderBVO> orderBList) throws Exception {
			save(orderBList);
	}

	/**
	 * 5.�����û���ɾ�����ﳵ
	 * @param username
	 * @throws Exception
	 */
	@Override
	public void delShoppingCarByUname(String username) throws Exception {
		delete(ShoppingCarVO.class, " and user_name='"+username+"'");
		
	}

	/**
	 * 9.���ݶ����� ��д����״̬
	 */
	@Override
	public void rewriteOrderStatus(String orderno) {
		String[] attrname = new String[]{"status","ts"};//Ҫ���µ��ֶ�
		Object[] attrval = new Object[]{"Y",DateUtil.getStrTimestamp(DateUtil.getCurDateTime())};        //���µ�ֵ
		if(orderno != null){
			updateAttrs(OrderVO.class, attrname, attrval, " order_no="+orderno);
		}
	}

	/**
	 * 13.�����û����鶩��
	 * @param uname
	 */
	@Override
	public List<OrderVO> getOrderByUname(String uname) {
		List<OrderVO> orderList = findAll(OrderVO.class, " username='"+uname+"'",null,"created","desc");
		return orderList;
	}

	/**
	 * 14.�����û����鶩������
	 * @param uname
	 * @return
	 */
	@Override
	public Integer getOrderNoByUname(String uname) {
		return getCountByHQL(OrderVO.class, " username='"+uname+"'");
	}

	/**
	 * 15.���ݶ����Ų鱦ʯ
	 * @param uname
	 */
	@Override
	public List<GemVO> getOrderGemById(String orderid) {
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		sql.append(" g.type_cn,g.type_en,b.price,b.quantity");
		sql.append(" from gt_order_b b");
		sql.append(" left join gt_gem g");
		sql.append(" on b.gem_id = g.id");
		sql.append(" where order_id = "+orderid+"");
		sql.append("  and ifnull(g.dr,0)=0");
	    sql.append(" order by g.id desc");
	    Integer count = getCountBySQL(sql.toString());
	    List<GemVO> list = (List<GemVO>) findListBySQL(sql.toString(), null, 0, count);
	    List<GemVO> nlist = new ArrayList<GemVO>();
	    if(list != null){
	    	String jsonStr = ObjectToJSON.writeListJSON(list);
	    	JSONArray jsonArr = JSONArray.fromObject(jsonStr);
	    	int size = jsonArr.size();
	    	for(int i = 0; i < size; i++){
	    		GemVO gem = new GemVO();
	    		Object [] arry = jsonArr.getJSONArray(i).toArray();
	    		gem.setType_cn(CommonUtils.isNull(arry[0]) ? null:arry[0]+"");
	    		gem.setType_en(CommonUtils.isNull(arry[1]) ? null:arry[1]+"");
	    		gem.setVdef1(CommonUtils.isNull(arry[2]) ? null:arry[2]+"");
	    		gem.setVdef2(CommonUtils.isNull(arry[3]) ? null:arry[3]+"");
	    		nlist.add(gem);
	    	}
	   }
	    return nlist;
	}
	
	/**
	 * 16.��ѯ���б�ʯ����
	 * @param uname
	 */
	@Override
	public List<OrderVO> getOrderVO(Integer dgpage,Integer rows,String startDate,String endDate,String typeNo){
	   //return findAll(OrderVO.class);
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		sql.append(" g.is_cover,b.gem_id,b.price,b.quantity,");
		sql.append(" o.order_no,o.username,o.real_name,");
		sql.append(" o.mail_address,o.zipcode,o.shipping_fee,");
		sql.append(" o.support_fee,o.total_price,");
		sql.append(" o.coupon_fee,o.invoice_title,o.invoice_content,");
		sql.append(" o.pay_date,o.`status`,o.shipping_no,o.shipping_date,o.coupon,o.id");
		sql.append(" from gt_order o,");
		sql.append(" gt_order_b b, gt_gem g");
		sql.append("  where o.id=b.order_id ");
		sql.append("  and b.gem_id=g.id");
		if(!CommonUtils.isNull(typeNo)){
			sql.append("  and o.order_no like '%"+typeNo+"%' or o.shipping_no like '%"+typeNo+"%'");
		}
		if(!CommonUtils.isNull(startDate) && !CommonUtils.isNull(endDate)){
			sql.append("  and o.shipping_date BETWEEN '"+startDate+"' AND '"+endDate+"'");
		}
		sql.append("  and ifnull(g.dr,0)=0");
	    //sql.append(" ORDER BY o.created DESC");
	    Integer count = getCountBySQL(sql.toString());
	    
	    List<OrderVO> list = (List<OrderVO>) findListBySQL(sql.toString(),null,dgpage,rows);
	    List<OrderVO> nlist = new ArrayList<OrderVO>();
	    if(list != null){
	    	String jsonStr = ObjectToJSON.writeListJSON(list);
	    	JSONArray jsonArr = JSONArray.fromObject(jsonStr);
	    	int size = jsonArr.size();
	    	for(int i = 0; i < size; i++){
	    		OrderVO order = new OrderVO();
	    		Object [] arry = jsonArr.getJSONArray(i).toArray();
	    		order.setVdef1(CommonUtils.isNull(arry[0]) ? null:arry[0]+"");
	    		order.setVdef2(CommonUtils.isNull(arry[1]) ? null:arry[1]+"");
	    		order.setVdef3(CommonUtils.isNull(arry[2]) ? null:arry[2]+"");
	    		order.setVdef4(CommonUtils.isNull(arry[3]) ? null:arry[3]+"");
	    		order.setOrder_no(CommonUtils.isNull(arry[4]) ? null:arry[4]+"");
	    		order.setUsername(CommonUtils.isNull(arry[5]) ? null:arry[5]+"");
	    		order.setReal_name(CommonUtils.isNull(arry[6]) ? null:arry[6]+"");
	    		order.setMail_address(CommonUtils.isNull(arry[7]) ? null:arry[7]+"");
	    		order.setZipcode(CommonUtils.isNull(arry[8]) ? null:arry[8]+"");
	    		order.setShipping_fee(CommonUtils.isNull(arry[9]) ? null:Double.valueOf(arry[9]+""));
	    		order.setSupport_fee(CommonUtils.isNull(arry[10]) ? null:Double.valueOf(arry[10]+""));
	    		order.setTotalPrice(CommonUtils.isNull(arry[11]) ? null:Double.valueOf(arry[11]+""));
	    		order.setCoupon_fee(CommonUtils.isNull(arry[12]) ? null:Double.valueOf(arry[12]+""));
	    		order.setInvoice_title(CommonUtils.isNull(arry[13]) ? null:arry[13]+"");
	    		order.setInvoice_content(CommonUtils.isNull(arry[14]) ? null:arry[14]+"");
	    		order.setPay_date(CommonUtils.isNull(arry[15]) ? null:DateUtil.getDate(arry[15]+""));
	    		order.setStatus(CommonUtils.isNull(arry[16]) ? null:arry[16]+"");
	    		order.setShipping_no(CommonUtils.isNull(arry[17]) ? null:arry[17]+"");
	    		order.setShipping_date(CommonUtils.isNull(arry[18]) ? null:arry[18]+"");
	    		order.setCoupon(CommonUtils.isNull(arry[19]) ? null:arry[19]+"");
	    		order.setId(CommonUtils.isNull(arry[20]) ? null:Integer.valueOf(arry[20]+""));
	    		nlist.add(order);
	    	}
	   }
	    return nlist;
	}
	
	/**
	 * 17.ģ����ѯ���б�ʯ����
	 * @param uname
	 */
	@Override
	public List<OrderVO> getOrderVOBytype(Integer dgpage,Integer total,String startDate,String endDate,String typeNo){
	   //return findAll(OrderVO.class);
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		sql.append(" g.is_cover,b.gem_id,b.price,b.quantity,");
		sql.append(" o.order_no,o.username,o.real_name,");
		sql.append(" o.mail_address,o.zipcode,o.shipping_fee,");
		sql.append(" o.support_fee,o.total_price,");
		sql.append(" o.coupon_fee,o.invoice_title,o.invoice_content,");
		sql.append(" o.pay_date,o.`status`,o.shipping_no,o.shipping_date,o.coupon,o.id");
		sql.append(" from gt_order o,");
		sql.append(" gt_order_b b, gt_gem g");
		sql.append("  where o.id=b.order_id ");
		sql.append("  and b.gem_id=g.id");
		if(!CommonUtils.isNull(typeNo)){
			sql.append("  and o.order_no like '%"+typeNo+"%' or o.shipping_no like '%"+typeNo+"%'");
		}
		if(!CommonUtils.isNull(startDate) && !CommonUtils.isNull(endDate)){
			sql.append("  and o.shipping_date BETWEEN '"+startDate+"' AND '"+endDate+"'");
		}
		sql.append("  and ifnull(g.dr,0)=0");
	    //sql.append(" ORDER BY o.created DESC");
	    //Integer count = getCountBySQL(sql.toString());
	   
	    List<OrderVO> list = (List<OrderVO>)  findBySql(sql.toString(), null);
	    List<OrderVO> nlist = new ArrayList<OrderVO>();
	    if(list != null){
	    	String jsonStr = ObjectToJSON.writeListJSON(list);
	    	JSONArray jsonArr = JSONArray.fromObject(jsonStr);
	    	int size = jsonArr.size();
	    	for(int i = 0; i < size; i++){
	    		OrderVO order = new OrderVO();
	    		Object [] arry = jsonArr.getJSONArray(i).toArray();
	    		order.setVdef1(CommonUtils.isNull(arry[0]) ? null:arry[0]+"");
	    		order.setVdef2(CommonUtils.isNull(arry[1]) ? null:arry[1]+"");
	    		order.setVdef3(CommonUtils.isNull(arry[2]) ? null:arry[2]+"");
	    		order.setVdef4(CommonUtils.isNull(arry[3]) ? null:arry[3]+"");
	    		order.setOrder_no(CommonUtils.isNull(arry[4]) ? null:arry[4]+"");
	    		order.setUsername(CommonUtils.isNull(arry[5]) ? null:arry[5]+"");
	    		order.setReal_name(CommonUtils.isNull(arry[6]) ? null:arry[6]+"");
	    		order.setMail_address(CommonUtils.isNull(arry[7]) ? null:arry[7]+"");
	    		order.setZipcode(CommonUtils.isNull(arry[8]) ? null:arry[8]+"");
	    		order.setShipping_fee(CommonUtils.isNull(arry[9]) ? null:Double.valueOf(arry[9]+""));
	    		order.setSupport_fee(CommonUtils.isNull(arry[10]) ? null:Double.valueOf(arry[10]+""));
	    		order.setTotalPrice(CommonUtils.isNull(arry[11]) ? null:Double.valueOf(arry[11]+""));
	    		order.setCoupon_fee(CommonUtils.isNull(arry[12]) ? null:Double.valueOf(arry[12]+""));
	    		order.setInvoice_title(CommonUtils.isNull(arry[13]) ? null:arry[13]+"");
	    		order.setInvoice_content(CommonUtils.isNull(arry[14]) ? null:arry[14]+"");
	    		order.setPay_date(CommonUtils.isNull(arry[15]) ? null:DateUtil.getDate(arry[15]+""));
	    		order.setStatus(CommonUtils.isNull(arry[16]) ? null:arry[16]+"");
	    		order.setShipping_no(CommonUtils.isNull(arry[17]) ? null:arry[17]+"");
	    		order.setShipping_date(CommonUtils.isNull(arry[18]) ? null:arry[18]+"");
	    		order.setCoupon(CommonUtils.isNull(arry[19]) ? null:arry[19]+"");
	    		order.setId(CommonUtils.isNull(arry[20]) ? null:Integer.valueOf(arry[20]+""));
	    		nlist.add(order);
	    	}
	   }
	    return nlist;
	}
	
	/**
	 * 18.����idɾ������
	 */
	public void delOrderVOById(Integer id){
		delete(OrderVO.class, id);
		delete(OrderBVO.class, id);
	}
	
	
	/**
	 * 20.����id �޸Ŀ�ݵ��ţ�����ʱ��
	 */
	@Override
	public void selOrderVOById(Integer id,String ship,String shippingNo){
		//getById(OrderVO.class, id, null);
		String[] attrname = new String[]{"shipping_date","shipping_no"};//Ҫ���µ��ֶ�
		Object[] attrval = new Object[]{ship,shippingNo};        //���µ�ֵ
		if(id != null){
			updateAttrs(OrderVO.class, attrname, attrval, " id="+id);
		}
	}
	
	/**
	 * 21.��ѯ��ʯ��������
	 * @param contions
	 * @return
	 */
	@Override
	public Integer getListSizeOrder(String startDate,String endDate,String typeNo){
		StringBuilder sql = new StringBuilder(" 1=1");
		if(!CommonUtils.isNull(typeNo)){
			sql.append("  and order_no like '%"+typeNo+"%' or shipping_no like '%"+typeNo+"%'");
		}
		if(!CommonUtils.isNull(startDate) && !CommonUtils.isNull(endDate)){
			sql.append("  and shipping_date BETWEEN '"+startDate+"' AND '"+endDate+"'");
		}
		return getCountByHQL(OrderVO.class,sql+"");
	}
}
