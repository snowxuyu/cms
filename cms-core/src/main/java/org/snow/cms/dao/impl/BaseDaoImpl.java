package org.snow.cms.dao.impl;

import java.util.HashMap;

import java.util.List;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import org.snow.cms.dao.IBaseDao;

import org.snow.cms.util.Pager;

import org.snow.cms.util.SystemContext;

public class BaseDaoImpl<T> implements IBaseDao<T> {

	@Inject
	private SqlSession sqlSession;

	public void add(T t) {
		this.sqlSession.insert(t.getClass().getName() + ".add", t);
	}

	public void update(T t) {
		this.sqlSession.update(t.getClass().getName() + ".update", t);
	}

	public void delete(Class<T> clz, Object id) {
		this.sqlSession.delete(clz.getName() + ".delete", id);
	}

	public T load(Class<T> clz, Object id) {
		return this.sqlSession.selectOne(clz.getName() + ".load", id);
	}

	public void deleteById(Class<T> clz, Object id) {
		delete(clz, id);
	}

	public T loadById(Class<T> clz, Object id) {
		return load(clz, id);
	}

	public T loadBySqlId(String sqlId, Map<String, Object> map) {
		return this.sqlSession.selectOne(sqlId, map);
	}

	public T loadBySqlId(String sqlId, Object obj) {
		return this.sqlSession.selectOne(sqlId, obj);
	}

	public List<T> list(Class<T> clz, Map<String, Object> map) {
		return list(clz.getName() + ".list", map);
	}

	public List<T> list(String sqlId, Map<String, Object> map) {
		List<T> list = null;
		list = this.sqlSession.selectList(sqlId, map);
		return list;
	}

	public Pager<T> find(Class<T> clz, Map<String, Object> map) {
		return find(clz.getName() + ".find", map);
	}

	public Pager<T> find(String sqlId, Map<String, Object> map) {
		Pager<T> page = new Pager<T>();
		if (null == map)
			map = new HashMap<String, Object>();
		Integer pageSize = SystemContext.getPageSize();
		Integer pageOffset = SystemContext.getPageOffset();
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		if ((pageSize == null) || (pageSize.intValue() < 0)) {
			pageSize = Integer.valueOf(10);
		}
		if ((pageOffset == null) || (pageOffset.intValue() < 0)) {
			pageOffset = Integer.valueOf(0);
		}
		map.put("pageSize", pageSize);
		map.put("pageOffset", pageOffset);
		map.put("order", order);
		map.put("sort", sort);
		List<T> datas = this.sqlSession.selectList(sqlId, map);
		long total = ((Long) this.sqlSession.selectOne(sqlId + "_count", map)).longValue();
		page.setSize(pageSize.intValue());
		page.setOffset(pageOffset.intValue());
		page.setDatas(datas);
		page.setTotalRecord(total);
		return page;
	}

}
