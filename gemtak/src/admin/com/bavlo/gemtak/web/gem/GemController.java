package com.bavlo.gemtak.web.gem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.constant.page.AGemListLang;
import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.service.gem.itf.IGemService;
import com.bavlo.gemtak.utils.CommonUtils;
import com.bavlo.gemtak.utils.PageLangUtil;
import com.bavlo.gemtak.utils.SelectUtil;
import com.bavlo.gemtak.utils.StringUtil;
import com.bavlo.gemtak.utils.WebUtils;
import com.bavlo.gemtak.web.BaseController;

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
	
	
	/**
	 * @Description: ������ҳ
	 * @param @param model
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="viewGemList")
	public String viewGemList(Model model,HttpServletRequest request,HttpServletResponse response,Integer dgpage,String allgem,String typegem,String shapegem,String inputgem){
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("�������ԣ�"+lang);
		//���ݱ������Ը���ҳ������
		getListPageModel(model,lang);
		
		/**���ݲ�ѯ-start**/
		
		//��������
		StringBuilder sql = new StringBuilder(" 1=1");
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
		List<GemVO> gems = gemService.findListGem(sql+"",dgpage,rows);
		
		model.addAttribute("gems",gems);
		model.addAttribute("total",total/rows);
		/**���ݲ�ѯ-end**/
		
		return "/admin/gem/gem-list";
	}
	
	/**
	 * ����������ȡ��ʯ�б�����
	 */
	@Deprecated
	@RequestMapping(value="getGemListByWh")
	public void getGemListByWh(Model model,HttpServletRequest request,HttpServletResponse response,Integer dgpage,String allgem,String typegem,String shapegem,String inputgem){
		
		StringBuilder sql = new StringBuilder(" 1=1");
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
		List<GemVO> gems = gemService.findListGem(sql+"",dgpage,rows);
		
		renderJson(gems);
		/*Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("items", gems);
		jsonMap.put("total", total);
		renderJson(jsonMap);*/
	}
	
	/**
	 * @Description: ������ʯ
	 * @param @param model
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="addGem")
	public String insertGem(Model model,HttpServletRequest request,HttpServletResponse response){
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		getCardPageModel(model,lang);
		
		return "/admin/gem/gem-card";
	}
	
	/**
	 * @Description: ����gemVO�ķ���
	 * @param @param GemVO 
	 * @param @param lisuike
	 * @return void
	 */
	@RequestMapping(value="saveOrUpdate")
	public String saveOrupdateGemVO(Model model,HttpServletRequest request,HttpServletResponse response,GemVO gemVO) {
		try {
			gemService.saveOrupdateGemVO(gemVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/admin/gem/gem-list";
	}
	
	
	
	/**
	 * @Description: ��ѯ������gemVO
	 * @param @param List<GemVO>
	 * @param @param lisuike
	 * @return void
	 */
	@RequestMapping(value="findAllGemVO")
	public String findAllGemVO(Model model) {
		
		List<GemVO> gems = gemService.findAllGemVO();
		model.addAttribute("gems", gems);
		return "/admin/gem/gem-list";
	}
	
	/**
	 * 
	 * @Description: TODO(���ɾ����ť������DR�ֶ�Ϊ1) 
	 * @param @param id
	 * @param @param dr
	 * @return void
	 */
	@RequestMapping(value="updateDrGemById")
	public void updateDrGemById(Integer id){
		try {
			gemService.updateDrGemById(id);
		} catch (Exception e) {
			e.printStackTrace();
			renderText("{\"msg\":\"N\",\"id\":\""+id+"\"}");
		}
		renderText("{\"msg\":\"Y\",\"id\":\""+id+"\"}");
	}
	
	
	/**
	 * @Description: ����id��ѯ��һ��gemVO ���������ť �����Ϊ�ر�
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
			bkst = IConstant.RELEASE_C;
			if(IConstant.EN_UK.equals(lang)){
				btnName = AGemListLang.LT_GEM_RELEASE_EN;//����
				warName = AGemListLang.LT_GEM_CLOSE_EN;//�ر�
			}else{
				btnName = AGemListLang.LT_GEM_RELEASE_CN;//����
				warName = AGemListLang.LT_GEM_CLOSE_CN;//�ر�
			}
		}else{
			bkst = IConstant.RELEASE_Y;
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
	
	
}
