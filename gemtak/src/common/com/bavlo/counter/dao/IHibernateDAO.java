package com.bavlo.counter.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.bavlo.counter.commonbeans.Page;
import com.bavlo.counter.utils.ICheckRule;
import com.bavlo.counter.utils.IUniqueRule;

/**
 * @Title: ����Counter
 * @ClassName: IHibernateDAO 
 * @Description: �ӿ�
 * @author liuzy
 * @date 2015-9-20 ����11:54:04
 */
@SuppressWarnings("unchecked")
public interface IHibernateDAO {
	
	public Object fidId(Class entityClass,Integer id);
	
	/**
	 * 
	* @Description: ͨ��Ԥ��sql��ֵ�������ݿ� 
	* @param @param hql
	* @param @param valueList
	* @return void
	 */
	public void updateDateWithHql(String sql, List<Object> valueList);
	
	public Page findPageBySQL(Class entityClass, String eString,
			String countProjection, String sql, Object[] args, int start,
			int limit);
	
	public Page findPageBySQL(Class entityClass,String eString,String sql, Object[] args, int start, int limit);
	public int execute(String hql, Object... args);
	
	public void flush();
	
	public void refresh(Object entity);
	
	
	// ����
	
	public void save(Object entity) throws Exception;
	
	// add by liuzy begin
	
	// ��������
	public void saveAll(List<?> entities);
	// ����ֵΪInternet�� ����
	public Integer saveReInt(Object entity) throws Exception;
	// ��������
	public void updateAll(List<?> entities);
	// ���ӱ���  ����
	public void saveAll(String zbjson , String deleted , String inserted , String updated , Class<?> zhubiao , Class<?> zibiao , String parentid);
	// ���ӱ���  ����
	public Integer saveAllReturnHeadId(String zbjson , String deleted , String inserted , String updated , Class<?> zhubiao , Class<?> zibiao , String parentid);
	
	// ���ӱ���  ���� -- 
	public Integer saveAllReturnHeadIdByDelete(String zbjson , String deleted , String inserted , String updated , Class<?> zhubiao , Class<?> zibiao , String parentid);
		
	/**
	 * ��ҳ���� 
	 * @param dgpage ��ǰҳ
	 * @param rows   ÿҳ��������
	 */
	public <E> List<E> findPage(Class<E> clasz , Integer dgpage , Integer rows);
	public <E> List<E> findPage(Class<E> clasz, Integer dgpage, Integer rows ,String conditions) ;
	public <E> List<E> findPageByDr(Class<E> clasz, Integer dgpage, Integer rows ,String conditions);
	public <E> List<E> findPage(Class<E> clasz, Integer dgpage, Integer rows ,String conditions,String order) ;
	public <E> List<E> findPage(Class<E> clasz, Integer dgpage, Integer rows ,String conditions,String order,String orderType) ;
	// ���������ֶ�
	public void updateAttrs(Class<?> clasz , String[] attrname , Object[] attrval , String conditions);
	// ͨ��ids ���������ֶ�
	public void updateAttrsByIDs(Class<?> clasz , String[] attrname , Object[] attrval , Integer[] ids);
	// ��ѯ�ܹ��ж�����
	public Integer getCountByHQL( Class<?> clasz );
	// ��ѯ�ܹ��ж����� ͨ������
	public Integer getCountByHQL( Class<?> clasz  , String conditions);
	//��ѯ��������û��Dr��
	public Integer getCountByHQLByDr(Class<?> clasz, String conditions);
	
	// add by liuzy end
	
	// ����
	
	public void update(Object entity) ;
	
	// ɾ��
	
	public void delete(Object entity) ;
	
	//��ѯ HQL
	public <E> List<E> findByHQL(Class<E> clasz, String hql, Object... args);
	
	public <E> E findUniqueByHQL(Class<E> clasz, String hql, Object... args);
	
	//��ѯhql
	public <E> List<E> findByHQLWithPamaList(Class<E> clasz, String hql, List<Object> pamaList);
	
	//��ѯ ����
	
	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Object[] args, String order, int start, int limit, String[] includes);
	
	
	public int executeSQL(String sql, Object... args);
	
	
	public boolean isExist(Class<?> entityClass, String whereClause,
			Object... values);
	
	public void saveOrUpdate(Object entity) throws Exception;
	
	public void deleteAll(Collection<?> entities);
	
	
	public void delete(Class<?> clasz, Object id) ;
	public void delete(Class<?> clasz, Object[] ids);
	
	// add by liuzy begin
	public void deleteByDr(Object entity) ;
	public void deleteAllByDr(Collection<?> entities);
	public void deleteByDr(Class<?> clasz, Object id) ;
	public void deleteByDrAry(Class<?> clasz, Integer[] ids);
	// add by liuzy end
	
	//xuelin ����ɾ��enties ���Դ����entities
	public void deleteAllEntiesByDr(Collection<?> entities) throws Exception;
	
	//��������ɾ�� --  2015-5-29
	public void deleteByCondition(Class<?> clasz, Object condition) throws Exception;
	
	public void delete(Class<?> clasz, String property, Object[] values);

	public void deleteByCont(Class<?> clasz, Object conditions);
	// ��������
	
	public <E> E getByProperty(Class<E> clasz, String name, Object value,
			String... includes);
	
	public <E> E getById(Class<E> clasz, Serializable id, String... includes);
	// Hibernate����һ��
	
	public <E> E findFirst(Class<E> clasz);
	
	public <E> E findFirst(Class<E> clasz, String[] includes);
	
	public <E> E findFirst(Class<E> clasz, String conditions);
	
	public <E> E findFirst(Class<E> clasz, String conditions, String[] includes);
	
	public <E> E findFirst(Class<E> clasz, String conditions, Object[] args);
	public <E> E findFirstByDr(Class<E> clasz, String conditions) ;
	
	public <E> E findFirst(Class<E> clasz, String conditions, Object[] args,
			String[] includes);
	
	public <E> E findFirst(Class<E> clasz, String conditions, Object[] args,
			String order);
	
	public <E> E findFirst(Class<E> clasz, String conditions, Object[] args,
			String order, String[] includes);
	
	public <E> E findFirst(Class<E> clasz, String conditions, Object[] args,
			String order, int start, int limit, String[] includes);
	
	// Hibernate����ȫ��
	
	public <E> List<E> findAll(Class<E> clasz) ;
	
	public <E> List<E> findAll(Class<E> clasz, String[] includes);
	
	public <E> List<E> findAll(Class<E> clasz, String conditions);
	/** ��ѯ��������order�ֶΰ���ordertype���� */
	public <E> List<E> findAll(Class<E> clasz, String conditions,String order,String orderType);
	public <E> List<E> findAllByDr(Class<E> clasz, String conditions);
	public <E> List<E> findAll(Class<E> clasz, String conditions,
			String[] includes);
	
	public <E> List<E> findAll(Class<E> clasz, String conditions, Object[] args);
	
	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Object[] args, String[] includes) ;
	
	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Object[] args, String order);
	
	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Object[] args, String order, String[] includes);
	
	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Object[] args, String order, int limit) ;
	
	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Object[] args, String order, int limit, String[] includes);
	public <E> List<E> findAllByDr(Class<E> clasz, String conditions,
			Object[] args, String order, int start, int limit, String[] includes);

	
	public <E> E findFirstByHQL(Class<E> clasz, String hql, Object... args) ;
	
	
	public <E> List<E> findByHQL(Class<E> clasz, String hql, Object[] args,
			int limit);
	
	
	// ����
	
	public Integer findInt(String hql, Object... args) ;

	
	public Long findLong(String hql, Object... args) ;
	
	public Double findDouble(String hql, Object... args);
	
	//xuelin  ����֧�ְ�sql ��ѯ���
	public Double findDoublebySQL(String sql, Object... args);
	
	public BigDecimal findBigDecimal(String hql, Object... args) ;
	
	public String findString(String hql, Object... args) ;


	
	// ��ҳ��ѯ
	
	public Page findPage(final DetachedCriteria dc, final int start,
			final int limit) ;

	
	public Page findPageByHQL(Class<?> clasz, String hql, Object[] args,
			int start, int limit) ;
	
	
	public Page findPageBySQL(String sql, Object[] args, int start, int limit);

	
	public List<?> findListBySQL(String sql, Object[] args, int start, int limit);
	
	
	public Integer getCountBySQL(String count_sql, Object... args) ;
	
	
	public Object getFirstBySQL(String sql, Object... args);
	
	
	public <E> List<E> findByCriteria(DetachedCriteria dc);
	
	
	public Page findPageBySQL(String sql, String count_sql, Object[] args,
			int start, int limit) ;
	
	public int findIntBySQL(String sql, Object... args);
	
	public void saveOrUpdateAll(List<?> entities) throws Exception ;
	
	public List findBySql(String sql,List<Object> valueList) ;
	
	public Object getMax(Class<?> entityClass, String propertyName,
			String scope, Object value) ;
	
	public Object getMin(Class<?> entityClass, String propertyName,
			String scope, Object value);
	
	public void down(Class<?> mappingClass, Serializable id, String groupBy) ;
	public void up(Class<?> mappingClass, Serializable id, String groupBy);
	public void orderNumUpOrDown(Class<?> mappingClass, Serializable id,
			String groupBy, boolean isDown);

	public List callProc(String name);
    //lumzhao ��Ψһ���ж�ע��У����
	public void setUniquerule(IUniqueRule uniquerule);
	  //lumzh  ע�������У���ࡣ
	public void setCheckrule(ICheckRule checkrule);
	//��ѯ ����
	
	public <E> List<E> findALLByCond(Class<E> clasz, String conditions,
			Object[] args, String order);
	public <E> List<E> findALLByCond(Class<E> clasz, String conditions);
	//����sql��������ѯ��--
	public List findBySqlAndConditions(String sql,List<Object> valueList);
	//����sql��������ѯ��--
	public List findBySqlAndConditions(String sql,List<Object> valueList,Class clazz);
}
