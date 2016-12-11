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

package com.hedu.groovy.scripts.portlet.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.hedu.groovy.scripts.portlet.model.GroovyScript;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the groovy script service. This utility wraps {@link com.hedu.groovy.scripts.portlet.service.persistence.impl.GroovyScriptPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroovyScriptPersistence
 * @see com.hedu.groovy.scripts.portlet.service.persistence.impl.GroovyScriptPersistenceImpl
 * @generated
 */
@ProviderType
public class GroovyScriptUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(GroovyScript groovyScript) {
		getPersistence().clearCache(groovyScript);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GroovyScript> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GroovyScript> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GroovyScript> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GroovyScript> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GroovyScript update(GroovyScript groovyScript) {
		return getPersistence().update(groovyScript);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GroovyScript update(GroovyScript groovyScript,
		ServiceContext serviceContext) {
		return getPersistence().update(groovyScript, serviceContext);
	}

	/**
	* Returns all the groovy scripts where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching groovy scripts
	*/
	public static List<GroovyScript> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<GroovyScript> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<GroovyScript> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<GroovyScript> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<GroovyScript> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<GroovyScript> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first groovy script in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching groovy script
	* @throws NoSuchGroovyScriptException if a matching groovy script could not be found
	*/
	public static GroovyScript findByUuid_First(java.lang.String uuid,
		OrderByComparator<GroovyScript> orderByComparator)
		throws com.hedu.groovy.scripts.portlet.exception.NoSuchGroovyScriptException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first groovy script in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching groovy script, or <code>null</code> if a matching groovy script could not be found
	*/
	public static GroovyScript fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<GroovyScript> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last groovy script in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching groovy script
	* @throws NoSuchGroovyScriptException if a matching groovy script could not be found
	*/
	public static GroovyScript findByUuid_Last(java.lang.String uuid,
		OrderByComparator<GroovyScript> orderByComparator)
		throws com.hedu.groovy.scripts.portlet.exception.NoSuchGroovyScriptException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last groovy script in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching groovy script, or <code>null</code> if a matching groovy script could not be found
	*/
	public static GroovyScript fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<GroovyScript> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static GroovyScript[] findByUuid_PrevAndNext(long groovyScriptId,
		java.lang.String uuid, OrderByComparator<GroovyScript> orderByComparator)
		throws com.hedu.groovy.scripts.portlet.exception.NoSuchGroovyScriptException {
		return getPersistence()
				   .findByUuid_PrevAndNext(groovyScriptId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the groovy scripts where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of groovy scripts where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching groovy scripts
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the groovy scripts where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching groovy scripts
	*/
	public static List<GroovyScript> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<GroovyScript> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<GroovyScript> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<GroovyScript> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
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
	public static List<GroovyScript> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<GroovyScript> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
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
	public static GroovyScript findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<GroovyScript> orderByComparator)
		throws com.hedu.groovy.scripts.portlet.exception.NoSuchGroovyScriptException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first groovy script in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching groovy script, or <code>null</code> if a matching groovy script could not be found
	*/
	public static GroovyScript fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<GroovyScript> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
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
	public static GroovyScript findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<GroovyScript> orderByComparator)
		throws com.hedu.groovy.scripts.portlet.exception.NoSuchGroovyScriptException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last groovy script in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching groovy script, or <code>null</code> if a matching groovy script could not be found
	*/
	public static GroovyScript fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<GroovyScript> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
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
	public static GroovyScript[] findByUuid_C_PrevAndNext(long groovyScriptId,
		java.lang.String uuid, long companyId,
		OrderByComparator<GroovyScript> orderByComparator)
		throws com.hedu.groovy.scripts.portlet.exception.NoSuchGroovyScriptException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(groovyScriptId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the groovy scripts where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of groovy scripts where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching groovy scripts
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the groovy scripts where scriptId = &#63;.
	*
	* @param scriptId the script ID
	* @return the matching groovy scripts
	*/
	public static List<GroovyScript> findByscriptId(long scriptId) {
		return getPersistence().findByscriptId(scriptId);
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
	public static List<GroovyScript> findByscriptId(long scriptId, int start,
		int end) {
		return getPersistence().findByscriptId(scriptId, start, end);
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
	public static List<GroovyScript> findByscriptId(long scriptId, int start,
		int end, OrderByComparator<GroovyScript> orderByComparator) {
		return getPersistence()
				   .findByscriptId(scriptId, start, end, orderByComparator);
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
	public static List<GroovyScript> findByscriptId(long scriptId, int start,
		int end, OrderByComparator<GroovyScript> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByscriptId(scriptId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first groovy script in the ordered set where scriptId = &#63;.
	*
	* @param scriptId the script ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching groovy script
	* @throws NoSuchGroovyScriptException if a matching groovy script could not be found
	*/
	public static GroovyScript findByscriptId_First(long scriptId,
		OrderByComparator<GroovyScript> orderByComparator)
		throws com.hedu.groovy.scripts.portlet.exception.NoSuchGroovyScriptException {
		return getPersistence().findByscriptId_First(scriptId, orderByComparator);
	}

	/**
	* Returns the first groovy script in the ordered set where scriptId = &#63;.
	*
	* @param scriptId the script ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching groovy script, or <code>null</code> if a matching groovy script could not be found
	*/
	public static GroovyScript fetchByscriptId_First(long scriptId,
		OrderByComparator<GroovyScript> orderByComparator) {
		return getPersistence()
				   .fetchByscriptId_First(scriptId, orderByComparator);
	}

	/**
	* Returns the last groovy script in the ordered set where scriptId = &#63;.
	*
	* @param scriptId the script ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching groovy script
	* @throws NoSuchGroovyScriptException if a matching groovy script could not be found
	*/
	public static GroovyScript findByscriptId_Last(long scriptId,
		OrderByComparator<GroovyScript> orderByComparator)
		throws com.hedu.groovy.scripts.portlet.exception.NoSuchGroovyScriptException {
		return getPersistence().findByscriptId_Last(scriptId, orderByComparator);
	}

	/**
	* Returns the last groovy script in the ordered set where scriptId = &#63;.
	*
	* @param scriptId the script ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching groovy script, or <code>null</code> if a matching groovy script could not be found
	*/
	public static GroovyScript fetchByscriptId_Last(long scriptId,
		OrderByComparator<GroovyScript> orderByComparator) {
		return getPersistence().fetchByscriptId_Last(scriptId, orderByComparator);
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
	public static GroovyScript[] findByscriptId_PrevAndNext(
		long groovyScriptId, long scriptId,
		OrderByComparator<GroovyScript> orderByComparator)
		throws com.hedu.groovy.scripts.portlet.exception.NoSuchGroovyScriptException {
		return getPersistence()
				   .findByscriptId_PrevAndNext(groovyScriptId, scriptId,
			orderByComparator);
	}

	/**
	* Removes all the groovy scripts where scriptId = &#63; from the database.
	*
	* @param scriptId the script ID
	*/
	public static void removeByscriptId(long scriptId) {
		getPersistence().removeByscriptId(scriptId);
	}

	/**
	* Returns the number of groovy scripts where scriptId = &#63;.
	*
	* @param scriptId the script ID
	* @return the number of matching groovy scripts
	*/
	public static int countByscriptId(long scriptId) {
		return getPersistence().countByscriptId(scriptId);
	}

	/**
	* Caches the groovy script in the entity cache if it is enabled.
	*
	* @param groovyScript the groovy script
	*/
	public static void cacheResult(GroovyScript groovyScript) {
		getPersistence().cacheResult(groovyScript);
	}

	/**
	* Caches the groovy scripts in the entity cache if it is enabled.
	*
	* @param groovyScripts the groovy scripts
	*/
	public static void cacheResult(List<GroovyScript> groovyScripts) {
		getPersistence().cacheResult(groovyScripts);
	}

	/**
	* Creates a new groovy script with the primary key. Does not add the groovy script to the database.
	*
	* @param groovyScriptId the primary key for the new groovy script
	* @return the new groovy script
	*/
	public static GroovyScript create(long groovyScriptId) {
		return getPersistence().create(groovyScriptId);
	}

	/**
	* Removes the groovy script with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groovyScriptId the primary key of the groovy script
	* @return the groovy script that was removed
	* @throws NoSuchGroovyScriptException if a groovy script with the primary key could not be found
	*/
	public static GroovyScript remove(long groovyScriptId)
		throws com.hedu.groovy.scripts.portlet.exception.NoSuchGroovyScriptException {
		return getPersistence().remove(groovyScriptId);
	}

	public static GroovyScript updateImpl(GroovyScript groovyScript) {
		return getPersistence().updateImpl(groovyScript);
	}

	/**
	* Returns the groovy script with the primary key or throws a {@link NoSuchGroovyScriptException} if it could not be found.
	*
	* @param groovyScriptId the primary key of the groovy script
	* @return the groovy script
	* @throws NoSuchGroovyScriptException if a groovy script with the primary key could not be found
	*/
	public static GroovyScript findByPrimaryKey(long groovyScriptId)
		throws com.hedu.groovy.scripts.portlet.exception.NoSuchGroovyScriptException {
		return getPersistence().findByPrimaryKey(groovyScriptId);
	}

	/**
	* Returns the groovy script with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param groovyScriptId the primary key of the groovy script
	* @return the groovy script, or <code>null</code> if a groovy script with the primary key could not be found
	*/
	public static GroovyScript fetchByPrimaryKey(long groovyScriptId) {
		return getPersistence().fetchByPrimaryKey(groovyScriptId);
	}

	public static java.util.Map<java.io.Serializable, GroovyScript> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the groovy scripts.
	*
	* @return the groovy scripts
	*/
	public static List<GroovyScript> findAll() {
		return getPersistence().findAll();
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
	public static List<GroovyScript> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<GroovyScript> findAll(int start, int end,
		OrderByComparator<GroovyScript> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<GroovyScript> findAll(int start, int end,
		OrderByComparator<GroovyScript> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the groovy scripts from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of groovy scripts.
	*
	* @return the number of groovy scripts
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static GroovyScriptPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GroovyScriptPersistence, GroovyScriptPersistence> _serviceTracker =
		ServiceTrackerFactory.open(GroovyScriptPersistence.class);
}