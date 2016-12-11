/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.hedu.groovy.scripts.portlet.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.hedu.groovy.scripts.portlet.exception.NoSuchGroovyScriptException;
import com.hedu.groovy.scripts.portlet.model.GroovyScript;
import com.hedu.groovy.scripts.portlet.model.impl.GroovyScriptImpl;
import com.hedu.groovy.scripts.portlet.model.impl.GroovyScriptModelImpl;
import com.hedu.groovy.scripts.portlet.service.persistence.GroovyScriptPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the groovy script service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroovyScriptPersistence
 * @see com.hedu.groovy.scripts.portlet.service.persistence.GroovyScriptUtil
 * @generated
 */
@ProviderType
public class GroovyScriptPersistenceImpl extends BasePersistenceImpl<GroovyScript>
	implements GroovyScriptPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GroovyScriptUtil} to access the groovy script persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GroovyScriptImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
			GroovyScriptModelImpl.FINDER_CACHE_ENABLED, GroovyScriptImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
			GroovyScriptModelImpl.FINDER_CACHE_ENABLED, GroovyScriptImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
			GroovyScriptModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
			GroovyScriptModelImpl.FINDER_CACHE_ENABLED, GroovyScriptImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
			GroovyScriptModelImpl.FINDER_CACHE_ENABLED, GroovyScriptImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			GroovyScriptModelImpl.UUID_COLUMN_BITMASK |
			GroovyScriptModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
			GroovyScriptModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the groovy scripts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching groovy scripts
	 */
	@Override
	public List<GroovyScript> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the groovy scripts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GroovyScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of groovy scripts
	 * @param end the upper bound of the range of groovy scripts (not inclusive)
	 * @return the range of matching groovy scripts
	 */
	@Override
	public List<GroovyScript> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the groovy scripts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GroovyScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of groovy scripts
	 * @param end the upper bound of the range of groovy scripts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching groovy scripts
	 */
	@Override
	public List<GroovyScript> findByUuid(String uuid, int start, int end,
		OrderByComparator<GroovyScript> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the groovy scripts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GroovyScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of groovy scripts
	 * @param end the upper bound of the range of groovy scripts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching groovy scripts
	 */
	@Override
	public List<GroovyScript> findByUuid(String uuid, int start, int end,
		OrderByComparator<GroovyScript> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<GroovyScript> list = null;

		if (retrieveFromCache) {
			list = (List<GroovyScript>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroovyScript groovyScript : list) {
					if (!Objects.equals(uuid, groovyScript.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_GROOVYSCRIPT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GroovyScriptModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<GroovyScript>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GroovyScript>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first groovy script in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching groovy script
	 * @throws NoSuchGroovyScriptException if a matching groovy script could not be found
	 */
	@Override
	public GroovyScript findByUuid_First(String uuid,
		OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException {
		GroovyScript groovyScript = fetchByUuid_First(uuid, orderByComparator);

		if (groovyScript != null) {
			return groovyScript;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGroovyScriptException(msg.toString());
	}

	/**
	 * Returns the first groovy script in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching groovy script, or <code>null</code> if a matching groovy script could not be found
	 */
	@Override
	public GroovyScript fetchByUuid_First(String uuid,
		OrderByComparator<GroovyScript> orderByComparator) {
		List<GroovyScript> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last groovy script in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching groovy script
	 * @throws NoSuchGroovyScriptException if a matching groovy script could not be found
	 */
	@Override
	public GroovyScript findByUuid_Last(String uuid,
		OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException {
		GroovyScript groovyScript = fetchByUuid_Last(uuid, orderByComparator);

		if (groovyScript != null) {
			return groovyScript;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGroovyScriptException(msg.toString());
	}

	/**
	 * Returns the last groovy script in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching groovy script, or <code>null</code> if a matching groovy script could not be found
	 */
	@Override
	public GroovyScript fetchByUuid_Last(String uuid,
		OrderByComparator<GroovyScript> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<GroovyScript> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the groovy scripts before and after the current groovy script in the ordered set where uuid = &#63;.
	 *
	 * @param groovyScriptId the primary key of the current groovy script
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next groovy script
	 * @throws NoSuchGroovyScriptException if a groovy script with the primary key could not be found
	 */
	@Override
	public GroovyScript[] findByUuid_PrevAndNext(long groovyScriptId,
		String uuid, OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException {
		GroovyScript groovyScript = findByPrimaryKey(groovyScriptId);

		Session session = null;

		try {
			session = openSession();

			GroovyScript[] array = new GroovyScriptImpl[3];

			array[0] = getByUuid_PrevAndNext(session, groovyScript, uuid,
					orderByComparator, true);

			array[1] = groovyScript;

			array[2] = getByUuid_PrevAndNext(session, groovyScript, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GroovyScript getByUuid_PrevAndNext(Session session,
		GroovyScript groovyScript, String uuid,
		OrderByComparator<GroovyScript> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GROOVYSCRIPT_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GroovyScriptModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(groovyScript);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GroovyScript> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the groovy scripts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (GroovyScript groovyScript : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(groovyScript);
		}
	}

	/**
	 * Returns the number of groovy scripts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching groovy scripts
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GROOVYSCRIPT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "groovyScript.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "groovyScript.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(groovyScript.uuid IS NULL OR groovyScript.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
			GroovyScriptModelImpl.FINDER_CACHE_ENABLED, GroovyScriptImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
			GroovyScriptModelImpl.FINDER_CACHE_ENABLED, GroovyScriptImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			GroovyScriptModelImpl.UUID_COLUMN_BITMASK |
			GroovyScriptModelImpl.COMPANYID_COLUMN_BITMASK |
			GroovyScriptModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
			GroovyScriptModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the groovy scripts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching groovy scripts
	 */
	@Override
	public List<GroovyScript> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the groovy scripts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GroovyScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of groovy scripts
	 * @param end the upper bound of the range of groovy scripts (not inclusive)
	 * @return the range of matching groovy scripts
	 */
	@Override
	public List<GroovyScript> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the groovy scripts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GroovyScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of groovy scripts
	 * @param end the upper bound of the range of groovy scripts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching groovy scripts
	 */
	@Override
	public List<GroovyScript> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<GroovyScript> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the groovy scripts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GroovyScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of groovy scripts
	 * @param end the upper bound of the range of groovy scripts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching groovy scripts
	 */
	@Override
	public List<GroovyScript> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<GroovyScript> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<GroovyScript> list = null;

		if (retrieveFromCache) {
			list = (List<GroovyScript>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroovyScript groovyScript : list) {
					if (!Objects.equals(uuid, groovyScript.getUuid()) ||
							(companyId != groovyScript.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_GROOVYSCRIPT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GroovyScriptModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<GroovyScript>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GroovyScript>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first groovy script in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching groovy script
	 * @throws NoSuchGroovyScriptException if a matching groovy script could not be found
	 */
	@Override
	public GroovyScript findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException {
		GroovyScript groovyScript = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (groovyScript != null) {
			return groovyScript;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGroovyScriptException(msg.toString());
	}

	/**
	 * Returns the first groovy script in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching groovy script, or <code>null</code> if a matching groovy script could not be found
	 */
	@Override
	public GroovyScript fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<GroovyScript> orderByComparator) {
		List<GroovyScript> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last groovy script in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching groovy script
	 * @throws NoSuchGroovyScriptException if a matching groovy script could not be found
	 */
	@Override
	public GroovyScript findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException {
		GroovyScript groovyScript = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (groovyScript != null) {
			return groovyScript;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGroovyScriptException(msg.toString());
	}

	/**
	 * Returns the last groovy script in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching groovy script, or <code>null</code> if a matching groovy script could not be found
	 */
	@Override
	public GroovyScript fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<GroovyScript> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<GroovyScript> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the groovy scripts before and after the current groovy script in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param groovyScriptId the primary key of the current groovy script
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next groovy script
	 * @throws NoSuchGroovyScriptException if a groovy script with the primary key could not be found
	 */
	@Override
	public GroovyScript[] findByUuid_C_PrevAndNext(long groovyScriptId,
		String uuid, long companyId,
		OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException {
		GroovyScript groovyScript = findByPrimaryKey(groovyScriptId);

		Session session = null;

		try {
			session = openSession();

			GroovyScript[] array = new GroovyScriptImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, groovyScript, uuid,
					companyId, orderByComparator, true);

			array[1] = groovyScript;

			array[2] = getByUuid_C_PrevAndNext(session, groovyScript, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GroovyScript getByUuid_C_PrevAndNext(Session session,
		GroovyScript groovyScript, String uuid, long companyId,
		OrderByComparator<GroovyScript> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_GROOVYSCRIPT_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GroovyScriptModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(groovyScript);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GroovyScript> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the groovy scripts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (GroovyScript groovyScript : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(groovyScript);
		}
	}

	/**
	 * Returns the number of groovy scripts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching groovy scripts
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GROOVYSCRIPT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "groovyScript.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "groovyScript.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(groovyScript.uuid IS NULL OR groovyScript.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "groovyScript.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SCRIPTID = new FinderPath(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
			GroovyScriptModelImpl.FINDER_CACHE_ENABLED, GroovyScriptImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByscriptId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCRIPTID =
		new FinderPath(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
			GroovyScriptModelImpl.FINDER_CACHE_ENABLED, GroovyScriptImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByscriptId",
			new String[] { Long.class.getName() },
			GroovyScriptModelImpl.SCRIPTID_COLUMN_BITMASK |
			GroovyScriptModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SCRIPTID = new FinderPath(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
			GroovyScriptModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByscriptId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the groovy scripts where scriptId = &#63;.
	 *
	 * @param scriptId the script ID
	 * @return the matching groovy scripts
	 */
	@Override
	public List<GroovyScript> findByscriptId(long scriptId) {
		return findByscriptId(scriptId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the groovy scripts where scriptId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GroovyScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scriptId the script ID
	 * @param start the lower bound of the range of groovy scripts
	 * @param end the upper bound of the range of groovy scripts (not inclusive)
	 * @return the range of matching groovy scripts
	 */
	@Override
	public List<GroovyScript> findByscriptId(long scriptId, int start, int end) {
		return findByscriptId(scriptId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the groovy scripts where scriptId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GroovyScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scriptId the script ID
	 * @param start the lower bound of the range of groovy scripts
	 * @param end the upper bound of the range of groovy scripts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching groovy scripts
	 */
	@Override
	public List<GroovyScript> findByscriptId(long scriptId, int start, int end,
		OrderByComparator<GroovyScript> orderByComparator) {
		return findByscriptId(scriptId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the groovy scripts where scriptId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GroovyScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scriptId the script ID
	 * @param start the lower bound of the range of groovy scripts
	 * @param end the upper bound of the range of groovy scripts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching groovy scripts
	 */
	@Override
	public List<GroovyScript> findByscriptId(long scriptId, int start, int end,
		OrderByComparator<GroovyScript> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCRIPTID;
			finderArgs = new Object[] { scriptId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SCRIPTID;
			finderArgs = new Object[] { scriptId, start, end, orderByComparator };
		}

		List<GroovyScript> list = null;

		if (retrieveFromCache) {
			list = (List<GroovyScript>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroovyScript groovyScript : list) {
					if ((scriptId != groovyScript.getScriptId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_GROOVYSCRIPT_WHERE);

			query.append(_FINDER_COLUMN_SCRIPTID_SCRIPTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GroovyScriptModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(scriptId);

				if (!pagination) {
					list = (List<GroovyScript>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GroovyScript>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first groovy script in the ordered set where scriptId = &#63;.
	 *
	 * @param scriptId the script ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching groovy script
	 * @throws NoSuchGroovyScriptException if a matching groovy script could not be found
	 */
	@Override
	public GroovyScript findByscriptId_First(long scriptId,
		OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException {
		GroovyScript groovyScript = fetchByscriptId_First(scriptId,
				orderByComparator);

		if (groovyScript != null) {
			return groovyScript;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scriptId=");
		msg.append(scriptId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGroovyScriptException(msg.toString());
	}

	/**
	 * Returns the first groovy script in the ordered set where scriptId = &#63;.
	 *
	 * @param scriptId the script ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching groovy script, or <code>null</code> if a matching groovy script could not be found
	 */
	@Override
	public GroovyScript fetchByscriptId_First(long scriptId,
		OrderByComparator<GroovyScript> orderByComparator) {
		List<GroovyScript> list = findByscriptId(scriptId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last groovy script in the ordered set where scriptId = &#63;.
	 *
	 * @param scriptId the script ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching groovy script
	 * @throws NoSuchGroovyScriptException if a matching groovy script could not be found
	 */
	@Override
	public GroovyScript findByscriptId_Last(long scriptId,
		OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException {
		GroovyScript groovyScript = fetchByscriptId_Last(scriptId,
				orderByComparator);

		if (groovyScript != null) {
			return groovyScript;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scriptId=");
		msg.append(scriptId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGroovyScriptException(msg.toString());
	}

	/**
	 * Returns the last groovy script in the ordered set where scriptId = &#63;.
	 *
	 * @param scriptId the script ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching groovy script, or <code>null</code> if a matching groovy script could not be found
	 */
	@Override
	public GroovyScript fetchByscriptId_Last(long scriptId,
		OrderByComparator<GroovyScript> orderByComparator) {
		int count = countByscriptId(scriptId);

		if (count == 0) {
			return null;
		}

		List<GroovyScript> list = findByscriptId(scriptId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the groovy scripts before and after the current groovy script in the ordered set where scriptId = &#63;.
	 *
	 * @param groovyScriptId the primary key of the current groovy script
	 * @param scriptId the script ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next groovy script
	 * @throws NoSuchGroovyScriptException if a groovy script with the primary key could not be found
	 */
	@Override
	public GroovyScript[] findByscriptId_PrevAndNext(long groovyScriptId,
		long scriptId, OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException {
		GroovyScript groovyScript = findByPrimaryKey(groovyScriptId);

		Session session = null;

		try {
			session = openSession();

			GroovyScript[] array = new GroovyScriptImpl[3];

			array[0] = getByscriptId_PrevAndNext(session, groovyScript,
					scriptId, orderByComparator, true);

			array[1] = groovyScript;

			array[2] = getByscriptId_PrevAndNext(session, groovyScript,
					scriptId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GroovyScript getByscriptId_PrevAndNext(Session session,
		GroovyScript groovyScript, long scriptId,
		OrderByComparator<GroovyScript> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GROOVYSCRIPT_WHERE);

		query.append(_FINDER_COLUMN_SCRIPTID_SCRIPTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GroovyScriptModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(scriptId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(groovyScript);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GroovyScript> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the groovy scripts where scriptId = &#63; from the database.
	 *
	 * @param scriptId the script ID
	 */
	@Override
	public void removeByscriptId(long scriptId) {
		for (GroovyScript groovyScript : findByscriptId(scriptId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(groovyScript);
		}
	}

	/**
	 * Returns the number of groovy scripts where scriptId = &#63;.
	 *
	 * @param scriptId the script ID
	 * @return the number of matching groovy scripts
	 */
	@Override
	public int countByscriptId(long scriptId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SCRIPTID;

		Object[] finderArgs = new Object[] { scriptId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GROOVYSCRIPT_WHERE);

			query.append(_FINDER_COLUMN_SCRIPTID_SCRIPTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(scriptId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SCRIPTID_SCRIPTID_2 = "groovyScript.scriptId = ?";

	public GroovyScriptPersistenceImpl() {
		setModelClass(GroovyScript.class);
	}

	/**
	 * Caches the groovy script in the entity cache if it is enabled.
	 *
	 * @param groovyScript the groovy script
	 */
	@Override
	public void cacheResult(GroovyScript groovyScript) {
		entityCache.putResult(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
			GroovyScriptImpl.class, groovyScript.getPrimaryKey(), groovyScript);

		groovyScript.resetOriginalValues();
	}

	/**
	 * Caches the groovy scripts in the entity cache if it is enabled.
	 *
	 * @param groovyScripts the groovy scripts
	 */
	@Override
	public void cacheResult(List<GroovyScript> groovyScripts) {
		for (GroovyScript groovyScript : groovyScripts) {
			if (entityCache.getResult(
						GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
						GroovyScriptImpl.class, groovyScript.getPrimaryKey()) == null) {
				cacheResult(groovyScript);
			}
			else {
				groovyScript.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all groovy scripts.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GroovyScriptImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the groovy script.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GroovyScript groovyScript) {
		entityCache.removeResult(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
			GroovyScriptImpl.class, groovyScript.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GroovyScript> groovyScripts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GroovyScript groovyScript : groovyScripts) {
			entityCache.removeResult(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
				GroovyScriptImpl.class, groovyScript.getPrimaryKey());
		}
	}

	/**
	 * Creates a new groovy script with the primary key. Does not add the groovy script to the database.
	 *
	 * @param groovyScriptId the primary key for the new groovy script
	 * @return the new groovy script
	 */
	@Override
	public GroovyScript create(long groovyScriptId) {
		GroovyScript groovyScript = new GroovyScriptImpl();

		groovyScript.setNew(true);
		groovyScript.setPrimaryKey(groovyScriptId);

		String uuid = PortalUUIDUtil.generate();

		groovyScript.setUuid(uuid);

		groovyScript.setCompanyId(companyProvider.getCompanyId());

		return groovyScript;
	}

	/**
	 * Removes the groovy script with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groovyScriptId the primary key of the groovy script
	 * @return the groovy script that was removed
	 * @throws NoSuchGroovyScriptException if a groovy script with the primary key could not be found
	 */
	@Override
	public GroovyScript remove(long groovyScriptId)
		throws NoSuchGroovyScriptException {
		return remove((Serializable)groovyScriptId);
	}

	/**
	 * Removes the groovy script with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the groovy script
	 * @return the groovy script that was removed
	 * @throws NoSuchGroovyScriptException if a groovy script with the primary key could not be found
	 */
	@Override
	public GroovyScript remove(Serializable primaryKey)
		throws NoSuchGroovyScriptException {
		Session session = null;

		try {
			session = openSession();

			GroovyScript groovyScript = (GroovyScript)session.get(GroovyScriptImpl.class,
					primaryKey);

			if (groovyScript == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGroovyScriptException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(groovyScript);
		}
		catch (NoSuchGroovyScriptException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected GroovyScript removeImpl(GroovyScript groovyScript) {
		groovyScript = toUnwrappedModel(groovyScript);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(groovyScript)) {
				groovyScript = (GroovyScript)session.get(GroovyScriptImpl.class,
						groovyScript.getPrimaryKeyObj());
			}

			if (groovyScript != null) {
				session.delete(groovyScript);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (groovyScript != null) {
			clearCache(groovyScript);
		}

		return groovyScript;
	}

	@Override
	public GroovyScript updateImpl(GroovyScript groovyScript) {
		groovyScript = toUnwrappedModel(groovyScript);

		boolean isNew = groovyScript.isNew();

		GroovyScriptModelImpl groovyScriptModelImpl = (GroovyScriptModelImpl)groovyScript;

		if (Validator.isNull(groovyScript.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			groovyScript.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (groovyScript.getCreateDate() == null)) {
			if (serviceContext == null) {
				groovyScript.setCreateDate(now);
			}
			else {
				groovyScript.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!groovyScriptModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				groovyScript.setModifiedDate(now);
			}
			else {
				groovyScript.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (groovyScript.isNew()) {
				session.save(groovyScript);

				groovyScript.setNew(false);
			}
			else {
				groovyScript = (GroovyScript)session.merge(groovyScript);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GroovyScriptModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((groovyScriptModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						groovyScriptModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { groovyScriptModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((groovyScriptModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						groovyScriptModelImpl.getOriginalUuid(),
						groovyScriptModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						groovyScriptModelImpl.getUuid(),
						groovyScriptModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((groovyScriptModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCRIPTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						groovyScriptModelImpl.getOriginalScriptId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SCRIPTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCRIPTID,
					args);

				args = new Object[] { groovyScriptModelImpl.getScriptId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SCRIPTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCRIPTID,
					args);
			}
		}

		entityCache.putResult(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
			GroovyScriptImpl.class, groovyScript.getPrimaryKey(), groovyScript,
			false);

		groovyScript.resetOriginalValues();

		return groovyScript;
	}

	protected GroovyScript toUnwrappedModel(GroovyScript groovyScript) {
		if (groovyScript instanceof GroovyScriptImpl) {
			return groovyScript;
		}

		GroovyScriptImpl groovyScriptImpl = new GroovyScriptImpl();

		groovyScriptImpl.setNew(groovyScript.isNew());
		groovyScriptImpl.setPrimaryKey(groovyScript.getPrimaryKey());

		groovyScriptImpl.setUuid(groovyScript.getUuid());
		groovyScriptImpl.setGroovyScriptId(groovyScript.getGroovyScriptId());
		groovyScriptImpl.setScriptId(groovyScript.getScriptId());
		groovyScriptImpl.setCompanyId(groovyScript.getCompanyId());
		groovyScriptImpl.setUserId(groovyScript.getUserId());
		groovyScriptImpl.setCreateDate(groovyScript.getCreateDate());
		groovyScriptImpl.setModifiedDate(groovyScript.getModifiedDate());
		groovyScriptImpl.setTitle(groovyScript.getTitle());
		groovyScriptImpl.setDescription(groovyScript.getDescription());
		groovyScriptImpl.setVersion(groovyScript.getVersion());
		groovyScriptImpl.setContent(groovyScript.getContent());

		return groovyScriptImpl;
	}

	/**
	 * Returns the groovy script with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the groovy script
	 * @return the groovy script
	 * @throws NoSuchGroovyScriptException if a groovy script with the primary key could not be found
	 */
	@Override
	public GroovyScript findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGroovyScriptException {
		GroovyScript groovyScript = fetchByPrimaryKey(primaryKey);

		if (groovyScript == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGroovyScriptException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return groovyScript;
	}

	/**
	 * Returns the groovy script with the primary key or throws a {@link NoSuchGroovyScriptException} if it could not be found.
	 *
	 * @param groovyScriptId the primary key of the groovy script
	 * @return the groovy script
	 * @throws NoSuchGroovyScriptException if a groovy script with the primary key could not be found
	 */
	@Override
	public GroovyScript findByPrimaryKey(long groovyScriptId)
		throws NoSuchGroovyScriptException {
		return findByPrimaryKey((Serializable)groovyScriptId);
	}

	/**
	 * Returns the groovy script with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the groovy script
	 * @return the groovy script, or <code>null</code> if a groovy script with the primary key could not be found
	 */
	@Override
	public GroovyScript fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
				GroovyScriptImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		GroovyScript groovyScript = (GroovyScript)serializable;

		if (groovyScript == null) {
			Session session = null;

			try {
				session = openSession();

				groovyScript = (GroovyScript)session.get(GroovyScriptImpl.class,
						primaryKey);

				if (groovyScript != null) {
					cacheResult(groovyScript);
				}
				else {
					entityCache.putResult(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
						GroovyScriptImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
					GroovyScriptImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return groovyScript;
	}

	/**
	 * Returns the groovy script with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groovyScriptId the primary key of the groovy script
	 * @return the groovy script, or <code>null</code> if a groovy script with the primary key could not be found
	 */
	@Override
	public GroovyScript fetchByPrimaryKey(long groovyScriptId) {
		return fetchByPrimaryKey((Serializable)groovyScriptId);
	}

	@Override
	public Map<Serializable, GroovyScript> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, GroovyScript> map = new HashMap<Serializable, GroovyScript>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			GroovyScript groovyScript = fetchByPrimaryKey(primaryKey);

			if (groovyScript != null) {
				map.put(primaryKey, groovyScript);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
					GroovyScriptImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (GroovyScript)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_GROOVYSCRIPT_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (GroovyScript groovyScript : (List<GroovyScript>)q.list()) {
				map.put(groovyScript.getPrimaryKeyObj(), groovyScript);

				cacheResult(groovyScript);

				uncachedPrimaryKeys.remove(groovyScript.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(GroovyScriptModelImpl.ENTITY_CACHE_ENABLED,
					GroovyScriptImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the groovy scripts.
	 *
	 * @return the groovy scripts
	 */
	@Override
	public List<GroovyScript> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the groovy scripts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GroovyScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of groovy scripts
	 * @param end the upper bound of the range of groovy scripts (not inclusive)
	 * @return the range of groovy scripts
	 */
	@Override
	public List<GroovyScript> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the groovy scripts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GroovyScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of groovy scripts
	 * @param end the upper bound of the range of groovy scripts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of groovy scripts
	 */
	@Override
	public List<GroovyScript> findAll(int start, int end,
		OrderByComparator<GroovyScript> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the groovy scripts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GroovyScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of groovy scripts
	 * @param end the upper bound of the range of groovy scripts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of groovy scripts
	 */
	@Override
	public List<GroovyScript> findAll(int start, int end,
		OrderByComparator<GroovyScript> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<GroovyScript> list = null;

		if (retrieveFromCache) {
			list = (List<GroovyScript>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GROOVYSCRIPT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GROOVYSCRIPT;

				if (pagination) {
					sql = sql.concat(GroovyScriptModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GroovyScript>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GroovyScript>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the groovy scripts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GroovyScript groovyScript : findAll()) {
			remove(groovyScript);
		}
	}

	/**
	 * Returns the number of groovy scripts.
	 *
	 * @return the number of groovy scripts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GROOVYSCRIPT);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GroovyScriptModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the groovy script persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(GroovyScriptImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_GROOVYSCRIPT = "SELECT groovyScript FROM GroovyScript groovyScript";
	private static final String _SQL_SELECT_GROOVYSCRIPT_WHERE_PKS_IN = "SELECT groovyScript FROM GroovyScript groovyScript WHERE groovyScriptId IN (";
	private static final String _SQL_SELECT_GROOVYSCRIPT_WHERE = "SELECT groovyScript FROM GroovyScript groovyScript WHERE ";
	private static final String _SQL_COUNT_GROOVYSCRIPT = "SELECT COUNT(groovyScript) FROM GroovyScript groovyScript";
	private static final String _SQL_COUNT_GROOVYSCRIPT_WHERE = "SELECT COUNT(groovyScript) FROM GroovyScript groovyScript WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "groovyScript.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GroovyScript exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GroovyScript exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(GroovyScriptPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}