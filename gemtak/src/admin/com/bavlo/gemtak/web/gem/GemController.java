package com.bavlo.gemtak.web.gem;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.constant.page.AGemListLang;
import com.bavlo.gemtak.model.gem.EquipmentVO;
import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.model.gem.LinkmanVO;
import com.bavlo.gemtak.service.gem.itf.IGemService;
import com.bavlo.gemtak.utils.CommonUtils;
import com.bavlo.gemtak.utils.PageLangUtil;
import com.bavlo.gemtak.utils.SelectUtil;
import com.bavlo.gemtak.utils.StringUtil;
import com.bavlo.gemtak.utils.WebUtils;
import com.bavlo.gemtak.web.BaseController;
import com.bavlo.gemtak.weixin.qy.interceptor.OAuthRequired;

/**
 * @Title: ����Gemtak
 * @ClassName: GemController 
 * @Description: ��ʯ������
 * @author liuzy
 * @date 2016-1-26 ����02:59:13
 */
@Controller("gemController")
@RequestMapping(value="gemAdmin")
public class GemController extends BaseController {
	
	@Resource
	IGemService gemService;
	private Object LoginVO;
	
	/**
	 * @Description: У����Ч�û�
	 * @param @return
	 * @return Boolean
	 */
	public Boolean checkU(){
		Object objUid = session.getAttribute("loginInfo");
		if(objUid != null){
			return false;
		}
		return true;
	}
	
	/**
	 * 1. ������ҳ
	 * @param model
	 * @param request
	 * @param response
	 * @param dgpage
	 * @param allgem
	 * @param typegem
	 * @param shapegem
	 * @param inputgem
	 * @return
	 * OAuthRequired ����ע�� ��������Ȩ��
	 */
	@OAuthRequired
	@RequestMapping(value="viewGemList")
	public String viewGemList(Model model,HttpServletRequest request,HttpServletResponse response,Integer dgpage,String allgem,String typegem,String shapegem,String inputgem){
		/*if(checkU()){
			return "/admin/warn";
		}*/
		
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("�������ԣ�"+lang);
		//���ݱ������Ը���ҳ������
		getListPageModel(model,lang);
		
		/**���ݲ�ѯ-start**/
		//��ǰ���������ݵ�¼�̻���΢�ź�����  supplier='"+uid+"'
		//΢����Ȩ��¼��ȡ��Ϣ
		Object objUid = session.getAttribute("loginInfo");
		if(objUid != null){
			String uid = ((com.bavlo.gemtak.model.LoginVO) objUid).getUserId();
			System.out.println("��ǰ��¼���û��ǣ�"+uid);
			StringBuilder sql = new StringBuilder(" supplier='"+uid+"'");
			if(!("A".equals(allgem) || CommonUtils.isNull(allgem))){
				sql.append( "  and  is_release = '"+allgem+"'");
			}
			if(!("-1".equals(typegem) || CommonUtils.isNull(typegem))){
				sql.append( " and type_id = '"+typegem+"'");
			}
			if(!("-1".equals(shapegem) || CommonUtils.isNull(shapegem))){
				sql.append(" and shape_id = '"+shapegem+"'");
			}
			if(StringUtil.isNotEmpty(inputgem)){
				sql.append(" and ( is_release like '%"+inputgem+"%' or type_id like '%"+inputgem+"%' or shape_id like '%"+inputgem+"%')");
			}
			//�߼�����
			Integer total = gemService.getListSizeGem(sql+"");
			if(dgpage == null){
				dgpage = this.dgpage;
			}
			List<GemVO> gems = gemService.findListGem(sql+"",dgpage,rows,null,null);
			
			model.addAttribute("gems",gems);
			model.addAttribute("total",CommonUtils.roundByNum(total,rows)); //CommonUtils���� �������� ��ǰҳ���С��ȡ��ҳ��
		}
		/**���ݲ�ѯ-end**/
		
		
		/*StringBuilder sql = new StringBuilder();
		if(!("A".equals(allgem) || CommonUtils.isNull(allgem))){
			sql.append( "  and  is_release = '"+allgem+"'");
		}
		if(!("-1".equals(typegem) || CommonUtils.isNull(typegem))){
			sql.append( " and type_id = '"+typegem+"'");
		}
		if(!("-1".equals(shapegem) || CommonUtils.isNull(shapegem))){
			sql.append(" and shape_id = '"+shapegem+"'");
		}
		if(StringUtil.isNotEmpty(inputgem)){
			sql.append(" and ( is_release like '%"+inputgem+"%' or type_id like '%"+inputgem+"%' or shape_id like '%"+inputgem+"%')");
		}
		//�߼�����
		Integer total = gemService.getListSizeGem(sql+"");
		if(dgpage == null){
			dgpage = this.dgpage;
		}
		List<GemVO> gems = gemService.findListGem(sql+"",dgpage,rows,null,null);
		
		model.addAttribute("gems",gems);
		model.addAttribute("total",CommonUtils.roundByNum(total,rows)); //CommonUtils���� �������� ��ǰҳ���С��ȡ��ҳ��
*/
		return "/admin/gem/gem-list";
	}
	
	/**
	 *2. ����������ȡ��ʯ�б�����
	 */
	@Deprecated
	@RequestMapping(value="getGemListByWh")
	public void getGemListByWh(Model model,HttpServletRequest request,HttpServletResponse response,Integer dgpage,String allgem,String typegem,String shapegem,String inputgem){
		Object objUid = session.getAttribute("loginInfo");
		if(objUid != null){
			String uid = ((com.bavlo.gemtak.model.LoginVO) objUid).getUserId();
			System.out.println("��ǰ��¼������������ѯ�û��ǣ�"+uid);
			StringBuilder sql = new StringBuilder(" supplier='"+uid+"'");
			if(!("A".equals(allgem) || CommonUtils.isNull(allgem))){
				sql.append( "  and  is_release = '"+allgem+"'");
			}else if(!("-1".equals(typegem) || CommonUtils.isNull(allgem))){
				sql.append( " and type_id = '"+typegem+"'");
			}else if(!("-1".equals(shapegem) || CommonUtils.isNull(allgem))){
				sql.append(" and shape_id = '"+shapegem+"'");
			}else if(StringUtil.isNotEmpty(inputgem)){
				sql.append(" and ( is_release like '%"+inputgem+"%' or type_id like '%"+inputgem+"%' or shape_id like '%"+inputgem+"%')");
			}
			//�߼�����
			Integer total = gemService.getListSizeGem(sql+"");
			List<GemVO> gems = gemService.findListGem(sql+"",dgpage,rows,null,null);
			
			renderJson(gems);
		}
		
		/*Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("items", gems);
		jsonMap.put("total", total);
		renderJson(jsonMap);*/
	}
	
	/**
	 * @Description:������ʯ
	 * @param @param model
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @return String
	 *//*
	@RequestMapping(value="addGem")
	public String insertGem(Model model,HttpServletRequest request,HttpServletResponse response){
		if(checkU()){
			return "/admin/warn";
		}
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		getCardPageModel(model,lang);
		
		return "/admin/gem/gem-card";
	}*/
	
	/**
	 * 3.�����ʯ��� ����gemid��ѯ��һ����ʯ��Ϣ  ��תgem-card.jsp 
	 * @Description:
	 * @param @param model
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="updateGem")
	public String updateGem(Model model,HttpServletRequest request,HttpServletResponse response,String gemid){
		/*if(checkU()){
			return "/admin/warn";
		}*/
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		getCardPageModel(model,lang);
		GemVO gem = gemService.findGemVOByID(Integer.valueOf(gemid));
		model.addAttribute("gem",gem);
		List<EquipmentVO> list = gemService.getSupplier();
		model.addAttribute("list", list);
		return "/admin/gem/gem-card";
	}
	
	/**
	 * 4.�޸�gemVO�ķ���
	 * @Description: 
	 * @param @param GemVO 
	 * @param @param lisuike
	 * @return void
	 */
	@RequestMapping(value="saveOrUpdate")
	public String saveOrupdateGemVO(Model model,HttpServletRequest request,HttpServletResponse response,GemVO gemVO) {
		/*if(checkU()){
			return "/admin/warn";
		}*/
		try {
			gemService.updateGemVO(gemVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/admin/gem/gem-list";
	}
	
	
	
	/**
	 * 5.��ѯ������gemVO
	 * @Description: 
	 * @param @param List<GemVO>
	 * @param @param lisuike
	 * @return void
	 */
	@RequestMapping(value="findAllGemVO")
	public String findAllGemVO(Model model) {
		if(checkU()){
			return "/admin/warn";
		}
		List<GemVO> gems = gemService.findAllGemVO();
		model.addAttribute("gems", gems);
		return "/admin/gem/gem-list";
	}
	
	/**
	 * 6.���ɾ����ť������DR�ֶ�Ϊ1
	 * @Description: TODO(���ɾ����ť������DR�ֶ�Ϊ1) 
	 * @param @param id
	 * @param @param dr
	 * @return void
	 */
	@RequestMapping(value="updateDrGemById")
	public void updateDrGemById(HttpServletRequest request,Model model,Integer id,String st){
		try {
			gemService.updateDrGemById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		renderText("{\"mess\":\"Y\",\"id\":\""+id+"\"}");
	}
	
	
	/**
	 * 7.���������ť �����Ϊ�ر�
	 * @Description: ����id��ѯ��һ��gemVO 
	 * @param @param GemVO
	 * @param @param lisuike
	 * @return void
	 */
	@RequestMapping(value="findGemVOByID")
	public void findGemVOByID(HttpServletRequest request,Model model,Integer id,String st) {
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//��ť��ʾ
		String btnName = AGemListLang.LT_GEM_CLOSE_CN;//�ر�
		//������ʾ
		String warName = AGemListLang.LT_GEM_RELEASE_CN;//����
		//����״̬
		String bkst = st;
		if(!IConstant.RELEASE_C.equals(st)){
			bkst = IConstant.RELEASE_C; //�ѹر�
			if(IConstant.EN_UK.equals(lang)){
				btnName = AGemListLang.LT_GEM_RELEASE_EN;//����
				warName = AGemListLang.LT_GEM_CLOSE_EN;//�ر�
			}else{
				btnName = AGemListLang.LT_GEM_RELEASE_CN;//����
				warName = AGemListLang.LT_GEM_CLOSE_CN;//�ر�
			}
		}else{
			bkst = IConstant.RELEASE_Y; //�ѷ���
			if(IConstant.EN_UK.equals(lang)){
				btnName = AGemListLang.LT_GEM_CLOSE_EN;//�ر�
				warName = AGemListLang.LT_GEM_RELEASE_EN;//����
			}else{
				btnName = AGemListLang.LT_GEM_CLOSE_CN;//�ر�
				warName = AGemListLang.LT_GEM_RELEASE_CN;//����
			}
		}
		try {
			gemService.updateGemById(id,st);
		} catch (Exception e) {
			e.printStackTrace();
			renderText("{\"msg\":\"N\",\"id\":\""+id+"\",\"warName\":\""+warName+"\"}");
		}
		renderText("{\"msg\":\"Y\",\"id\":\""+id+"\",\"btnNm\":\""+btnName+"\",\"warName\":\""+warName+"\",\"bkst\":\""+bkst+"\"}");
	}
	
	/**
	 * @Description: ���ݱ������Ի�ȡCardҳ������
	 * @param @param model
	 * @param @param lang
	 * @param @return
	 * @return Model
	 */
	public void getCardPageModel(Model model,String lang){
		//ҳ��BodyVO
		model.addAttribute("pagevo", PageLangUtil.getAGemCardBodyPageVO(lang));
		//ҳ��HeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		
		//��ʯ����
		model.addAttribute("listGemType", SelectUtil.getListGemType(lang));
		//��ʯ��״
		model.addAttribute("listGemShape", SelectUtil.getListGemShape(lang));
		//��ʯ�й�
		model.addAttribute("listGemCut", SelectUtil.getListGemCut(lang));
		//��ʯ����
		model.addAttribute("listGemClarity", SelectUtil.getListGemClarity(lang));
		//��ʯ����
		model.addAttribute("listGemOrigin", SelectUtil.getListGemOrigin(lang));
		//��ʯ������
		model.addAttribute("listGemTreatment", SelectUtil.getListGemTreatment(lang));
		//��ʯ֤��
		model.addAttribute("listGemLab", SelectUtil.getListGemLab(lang));
		
	}
	
	/**
	 * @Description: ���ݱ������Ի�ȡListҳ������
	 * @param @param model
	 * @param @param lang
	 * @return void
	 */
	private void getListPageModel(Model model, String lang) {
		//ҳ���м�BodyVO
		model.addAttribute("pagevo", PageLangUtil.getAGemListBodyPageVO(lang));
		//ҳ���ͷ����βHeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		//��ʯ����
		model.addAttribute("listGemType", SelectUtil.getListGemType(lang));
		//��ʯ��״
		model.addAttribute("listGemShape", SelectUtil.getListGemShape(lang));
	}

	
	
//------------------------------------------��ʯ��Ӧ�̹���--------------------------------------------------
	@RequestMapping("viewSupplier")
	public String viewSupplier(Model model,HttpServletRequest request,HttpServletResponse response){
		List<EquipmentVO> list = gemService.getSupplier();
		model.addAttribute("list", list);
		/*List<LinkmanVO> linkmanList = gemService.getLinkman();
		model.addAttribute("linkmanList", linkmanList);*/
		return "/admin/gem/supplier_management";
	}
	
	@RequestMapping("addSupplier")
	public String addSupplier(Model model,HttpServletRequest request,HttpServletResponse response,Integer id){
		if(id!=null){
			EquipmentVO equipment=gemService.getEquipmentByid(id);
			model.addAttribute("equipment", equipment);
		}
		return "/admin/gem/addSupplier";
	}
	
	@RequestMapping("saveSupplier")
	public void saveSupplier(Model model,HttpServletRequest request,HttpServletResponse response,EquipmentVO equipment){
		gemService.saveSupplier(equipment);
		//return "redirect:viewSupplier.do";
		renderText("{\"msg\":\"Y\"}");
	}
	
	@RequestMapping("delSupplier")
	public void delSupplier(Model model,HttpServletRequest request,HttpServletResponse response,Integer id){
		gemService.delSupplier(id);
		renderText("{\"msg\":\"Y\"}");
	}
	
	@RequestMapping("addLinkman")
	public String addLinkman(Model model,HttpServletRequest request,HttpServletResponse response,Integer id,Integer equipmentId){
		if(id!=null){
			LinkmanVO linkman=gemService.getLinkmanByid(id);
			model.addAttribute("linkman", linkman);
		}
		model.addAttribute("equipmentId", equipmentId);
		return "/admin/gem/addLinkman";
	}
	
	@RequestMapping("saveLinkman")
	public void saveLinkman(Model model,HttpServletRequest request,HttpServletResponse response,LinkmanVO linkman){
		gemService.saveLinkman(linkman);
		renderText("{\"msg\":\"Y\"}");
	}
	
	@RequestMapping("viewLinkman")
	public String viewLinkman(Model model,HttpServletRequest request,HttpServletResponse response,Integer id){
		List<LinkmanVO> linkmanList = gemService.getLinkman(id);
		if(linkmanList!=null){
			model.addAttribute("linkmanList", linkmanList);
			model.addAttribute("id", id);
		}
		return "/admin/gem/linkman_management";
	}
	
	@RequestMapping("delLinkman")
	public void delLinkman(Model model,HttpServletRequest request,HttpServletResponse response,Integer id){
		gemService.delLinkman(id);
		renderText("{\"msg\":\"Y\"}");
	}
}
