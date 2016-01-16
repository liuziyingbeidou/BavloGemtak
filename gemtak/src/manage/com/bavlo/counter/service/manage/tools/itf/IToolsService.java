package com.bavlo.counter.service.manage.tools.itf;

import java.util.Map;

import com.bavlo.counter.model.manage.tools.QrcodeVO;

/**
 * @Title: 宝珑Counter
 * @ClassName: IToolsService 
 * @Description: 工具管理
 * @author liuzy
 * @date 2015-12-7 下午04:08:20
 */
public interface IToolsService {
	
	/**
	 * @Description: 创建二维码
	 * @param @param qrcodeVO
	 * @param @return
	 * @return QrcodeVO
	 */
	public QrcodeVO saveQrcode(QrcodeVO qrcodeVO);
	
	/**
	 * @Description: 列表数据
	 * @param @param condition
	 * @param @return
	 * @return List<QrcodeVO>
	 */
	public Map<String, Object> getListQrcode(String condition,Integer dgpage,
			Integer rows);
	
	/**
	 * @Description: id对应二维码数据
	 * @param @param id
	 * @param @return
	 * @return QrcodeVO
	 */
	public QrcodeVO getQrcodeVOById(Integer id);
	
	/**
	 * @Description: condition对应二维码数据
	 * @param @param id
	 * @param @return
	 * @return QrcodeVO
	 */
	public QrcodeVO getQrcodeVOByWh(String condition);
	
}
