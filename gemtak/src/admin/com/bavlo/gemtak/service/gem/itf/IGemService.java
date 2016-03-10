package com.bavlo.gemtak.service.gem.itf;

/**
 * @Title: ����Gemtak
 * @ClassName: IGemService 
 * @Description: ��ʯ ����ӿ�
 * @author liuzy
 * @date 2016-1-30 ����12:14:02
 */
public interface IGemService {

	/**
	 * @Description: ���汦ʯ��Ϣ������ID
	 * @param @return
	 * @param @throws Exception
	 * @return Integer
	 */
	public Integer saveGemInfo() throws Exception;
	
	/**
	 * @Description: ���汦ʯ��Ϣ
	 * @param @throws Exception
	 * @return void
	 */
	public void saveGemInfoRID() throws Exception;
	
	/**
	 * @Description: ����ID��������
	 * @param @param id
	 * @param @throws Exception
	 * @return void
	 */
	public void updateGemInfo(Integer id) throws Exception;
}
