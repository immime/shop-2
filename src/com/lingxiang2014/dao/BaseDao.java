
package com.lingxiang2014.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.LockModeType;

import com.lingxiang2014.Filter;
import com.lingxiang2014.Order;
import com.lingxiang2014.Page;
import com.lingxiang2014.Pageable;

public interface BaseDao<T, ID extends Serializable> {

	T find(ID id);

	T find(ID id, LockModeType lockModeType);

	List<T> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	Page<T> findPage(Pageable pageable);

	long count(Filter... filters);

	void persist(T entity);

	T merge(T entity);

	void remove(T entity);

	void refresh(T entity);

	void refresh(T entity, LockModeType lockModeType);

	ID getIdentifier(T entity);

	boolean isManaged(T entity);

	void detach(T entity);

	void lock(T entity, LockModeType lockModeType);

	void clear();

	void flush();
	

}