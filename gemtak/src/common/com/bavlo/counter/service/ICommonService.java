package com.bavlo.counter.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.bavlo.counter.commonbeans.Page;
import com.bavlo.counter.dao.IHibernateDAO;


public interface ICommonService {
	public List<?> findListBySQL(String sql, Object[] args, int start, int limit) ;
	public IHibernateDAO getDao();
	//
	public boolean isExist(Class<?> entityClass,String whereClause, Object... values );
	public Page findPageBySQL(Class entityClass, String eString,
			String countProjection, String sql, Object[] args, int start,
			int limit);
	public Page findPageBySQL(Class entityClass,String eString,String sql, Object[] args, int start, int limit);
	// ִ��
	public int execute(String hql, Object... args);

	// �־û�
	public void save(Object entity) throws Exception;

	public void update(Object entity);

	public void saveOrUpdate(Object entity) throws Exception;
	
	public void saveOrUpdateAll(List<?> entities) throws Exception;
	
	public void delete(Object entity);

	public void deleteAll(Collection<?> entities);

	public void delete(Class<?> clasz, Object id);

	public void delete(Class<?> clasz, Object[] ids);
   
	public void delete(Class<?> clasz,String conditions);
	
	// add by liuzy begin �߼�ɾ��
	public void deleteByDr(Object entity);

	public void deleteAllByDr(Collection<?> entities);

	public void deleteByDr(Class<?> clasz, Object id) ;
	
	public void deleteByDrAry(Class<?> clasz, Integer[] ids);
	// ���������ֶ�
	public void updateAttrs(Class<?> clasz , String[] attrname , Object[] attrval , String conditions);
	// ͨ��ids ���������ֶ�
	public void updateAttrsByIDs(Class<?> clasz , String[] attrname , Object[] attrval , Integer[] ids);
	/**
	 * ��ҳ���� 
	 * @param dgpage ��ǰҳ
	 * @param rows   ÿҳ��������
	 */
	public <E> List<E> findPage(Class<E> clasz , Integer dgpage , Integer rows);
	public <E> List<E> findPage(Class<E> clasz, Integer dgpage, Integer rows ,String conditions) ;
	public <E> List<E> findPageByDr(Class<E> clasz, Integer dgpage, Integer rows ,String conditions) ;
	public <E> List<E> findPage(Class<E> clasz, Integer dgpage, Integer rows ,String conditions,String order,String orderType) ;
	// ��ѯ�ܹ��ж�����
	public Integer getCountByHQL( Class<?> clasz );
	// ��ѯ�ܹ��ж����� ͨ������
	public Integer getCountByHQL( Class<?> clasz  , String conditions);
	public Integer getCountByHQLByDr(Class<?> clasz, String conditions);
		
	// add by liuzy end �߼�ɾ��
	
	
	// ��������
	public <E> E getByProperty(Class<E> clasz, String name, Object value,
			String... includes);

	public <E> E getById(Class<E> clasz, Serializable id, String... includes);

	// Hibernate����һ��
	public <E> E findFirst(Class<E> clasz);

	public <E> E findFirst(Class<E> clasz, String[] includes);

	public <E> E findFirst(Class<E> clasz, String conditions);
	public <E> E findFirstByDr(Class<E> clasz, String conditions);

	public <E> E findFirst(Class<E> clasz, String conditions, String[] includes);

	public <E> E findFirst(Class<E> clasz, String conditions, Object[] args);

	public <E> E findFirst(Class<E> clasz, String conditions, Object[] args,
			String[] includes);

	public <E> E findFirst(Class<E> clasz, String conditions, Object[] args,
			String order);

	public <E> E findFirst(Class<E> clasz, String conditions, Object[] args,
			String order, String[] includes);

	// Hibernate����ȫ��
	public <E> List<E> findAll(Class<E> clasz);

	public <E> List<E> findAll(Class<E> clasz, String[] includes);

	public <E> List<E> findAll(Class<E> clasz, String conditions);
	
	public <E> List<E> findAllByDr(Class<E> clasz, String conditions);

	public <E> List<E> findAll(Class<E> clasz, String conditions,
			String[] includes);

	public <E> List<E> findAll(Class<E> clasz, String conditions, Object[] args);

	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Object[] args, String[] includes);

	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Object[] args, String order);

	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Object[] args, String order, String[] includes);

	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Object[] args, String order, int limit);

	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Object[] args, String order, int limit, String[] includes);

	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Object[] args, String order,String orderType);
	
	// HQL��ѯ
	public <E> E findFirstByHQL(Class<E> clasz, String hql, Object... args);

	public <E> List<E> findByHQL(Class<E> clasz, String hql, Object... args);

	public <E> List<E> findByHQL(Class<E> clasz, String hql, Object[] args,
			int limit);

	// ����
	public Integer findInt(String hql, Object... args);

	public Long findLong(String hql, Object... args);

	public Double findDouble(String hql, Object... args);

	public BigDecimal findBigDecimal(String hql, Object... args);

	public String findString(String hql, Object... args);

	// ��ҳ��ѯ
	public Page findPage(final DetachedCriteria dc, final int start,
			final int limit);

	public Page findPageByHQL(Class<?> clasz, String hql, Object[] args,
			int start, int limit);
	public Page findPageBySQL(String sql, Object[] args,
			int start, int limit);
	public <E> List<E> findByCriteria(DetachedCriteria dc);
	public Page findPageBySQL(String sql, String count_sql, Object[] args,
			int start, int limit);
	
	public Object getMax(Class<?> entityClass,String propertyName,String scope,Object value);
	public Object getMin(Class<?> entityClass,String propertyName,String scope,Object value);
	
	public void down(Class<?>  mappingClass,Serializable id,String groupBy);
	public void up(Class<?>  mappingClass,Serializable id,String groupBy);
	
	public int executeSQL(String sql, Object... args);
	public int findIntBySQL(String sql, Object... args);
	public List callProc(String string);
	// �־û� ��������
	public int saveReID(Object entity) throws Exception;
	// �־û� ����VO
	public Object saveReDTO(Object entity) throws Exception;
}
