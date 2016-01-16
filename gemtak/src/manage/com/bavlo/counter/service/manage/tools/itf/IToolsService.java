package com.bavlo.counter.service.manage.tools.itf;

import java.util.Map;

import com.bavlo.counter.model.manage.tools.QrcodeVO;

/**
 * @Title: ����Counter
 * @ClassName: IToolsService 
 * @Description: ���߹���
 * @author liuzy
 * @date 2015-12-7 ����04:08:20
 */
public interface IToolsService {
	
	/**
	 * @Description: ������ά��
	 * @param @param qrcodeVO
	 * @param @return
	 * @return QrcodeVO
	 */
	public QrcodeVO saveQrcode(QrcodeVO qrcodeVO);
	
	/**
	 * @Description: �б�����
	 * @param @param condition
	 * @param @return
	 * @return List<QrcodeVO>
	 */
	public Map<String, Object> getListQrcode(String condition,Integer dgpage,
			Integer rows);
	
	/**
	 * @Description: id��Ӧ��ά������
	 * @param @param id
	 * @param @return
	 * @return QrcodeVO
	 */
	public QrcodeVO getQrcodeVOById(Integer id);
	
	/**
	 * @Description: condition��Ӧ��ά������
	 * @param @param id
	 * @param @return
	 * @return QrcodeVO
	 */
	public QrcodeVO getQrcodeVOByWh(String condition);
	
}
