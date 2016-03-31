package com.bavlo.gemtak.service.ui.impl;

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
import com.bavlo.gemtak.model.ui.ShoppingCarVO;
import com.bavlo.gemtak.service.ui.itf.IGemService;
import com.bavlo.gemtak.service.impl.CommonService;
import com.bavlo.gemtak.utils.CommonUtils;
import com.bavlo.gemtak.utils.DateUtil;
import com.bavlo.gemtak.utils.ObjectToJSON;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: GemAService 
 * @Description: 宝石后端Service
 * @author liuzy
 * @date 2016-3-14 上午11:59:09
 */
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
	 * 给据id查询 一个GemVO
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
	 * 分页查询
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
	 * 点击发布按钮，修改数据库字段
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
	 * 点击删除按钮，修改数据库字段
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

	@Override
	public Integer getListSizeGem(String contions) {
		return getCountByHQL(GemVO.class, contions);
	}

	/**
	 * 新增到购物车
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
	 * 根据用户名查询 查询当前用户的购物车商品数量
	 */
	@Override
	public Integer getShoppingCarNumByUname(String username) throws Exception {
		return getCountByHQL(ShoppingCarVO.class, "user_name='"+username+"'");
	}

	/**
	 * 根据用户名查询 查询当前用户的购物车
	 */
	@Override
	public List<GemVO> getShoppingCarListByUname(String username)
			throws Exception {
		StringBuilder sql = new StringBuilder();
	    sql.append("select ");
	    sql.append(" g.id, g.type_cn,g.weight,g.company,g.shape_cn,g.size_l,g.size_w,g.size_h,g.average_color,g.clarity_cn,g.cut_cn," +
	    		"g.origin_cn,g.treatment_cn,g.lab_cn,g.supplier,g.retail_price,g.trade_price, s.quantity as vdef1");
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
	    		nlist.add(gem);
	    	}
	    }
		return nlist;
	}

	/**
	 * 根据用户名 商品id 删除购物车中选中的 商品
	 */
	@Override
	public void delShoppingCarByGemId(String username, Integer gemid)
			throws Exception {
		delete(ShoppingCarVO.class, gemid);
	}
	
	
	
}
