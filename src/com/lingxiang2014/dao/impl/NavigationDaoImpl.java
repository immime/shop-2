/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.dao.impl;

import java.util.List;

import javax.persistence.FlushModeType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.lingxiang2014.dao.NavigationDao;
import com.lingxiang2014.entity.Navigation;
import com.lingxiang2014.entity.Navigation.Position;

@Repository("navigationDaoImpl")
public class NavigationDaoImpl extends BaseDaoImpl<Navigation, Long> implements NavigationDao {

	public List<Navigation> findList(Position position) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Navigation> criteriaQuery = criteriaBuilder.createQuery(Navigation.class);
		Root<Navigation> root = criteriaQuery.from(Navigation.class);
		criteriaQuery.select(root);
		if (position != null) {
			criteriaQuery.where(criteriaBuilder.equal(root.get("position"), position));
		}
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("order")));
		return entityManager.createQuery(criteriaQuery).setFlushMode(FlushModeType.COMMIT).getResultList();
	}

}