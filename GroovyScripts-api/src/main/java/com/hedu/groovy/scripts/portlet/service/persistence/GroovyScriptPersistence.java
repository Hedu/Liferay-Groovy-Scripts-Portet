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

import com.hedu.groovy.scripts.portlet.exception.NoSuchGroovyScriptException;
import com.hedu.groovy.scripts.portlet.model.GroovyScript;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the groovy script service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.hedu.groovy.scripts.portlet.service.persistence.impl.GroovyScriptPersistenceImpl
 * @see GroovyScriptUtil
 * @generated
 */
@ProviderType
public interface GroovyScriptPersistence extends BasePersistence<GroovyScript> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GroovyScriptUtil} to access the groovy script persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the groovy scripts where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching groovy scripts
	*/
	public java.util.List<GroovyScript> findByUuid(java.lang.String uuid);

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
	public java.util.List<GroovyScript> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<GroovyScript> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator);

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
	public java.util.List<GroovyScript> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first groovy script in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching groovy script
	* @throws NoSuchGroovyScriptException if a matching groovy script could not be found
	*/
	public GroovyScript findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException;

	/**
	* Returns the first groovy script in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching groovy script, or <code>null</code> if a matching groovy script could not be found
	*/
	public GroovyScript fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator);

	/**
	* Returns the last groovy script in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching groovy script
	* @throws NoSuchGroovyScriptException if a matching groovy script could not be found
	*/
	public GroovyScript findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException;

	/**
	* Returns the last groovy script in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching groovy script, or <code>null</code> if a matching groovy script could not be found
	*/
	public GroovyScript fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator);

	/**
	* Returns the groovy scripts before and after the current groovy script in the ordered set where uuid = &#63;.
	*
	* @param groovyScriptId the primary key of the current groovy script
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next groovy script
	* @throws NoSuchGroovyScriptException if a groovy script with the primary key could not be found
	*/
	public GroovyScript[] findByUuid_PrevAndNext(long groovyScriptId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException;

	/**
	* Removes all the groovy scripts where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of groovy scripts where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching groovy scripts
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the groovy scripts where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching groovy scripts
	*/
	public java.util.List<GroovyScript> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<GroovyScript> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<GroovyScript> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator);

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
	public java.util.List<GroovyScript> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first groovy script in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching groovy script
	* @throws NoSuchGroovyScriptException if a matching groovy script could not be found
	*/
	public GroovyScript findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException;

	/**
	* Returns the first groovy script in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching groovy script, or <code>null</code> if a matching groovy script could not be found
	*/
	public GroovyScript fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator);

	/**
	* Returns the last groovy script in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching groovy script
	* @throws NoSuchGroovyScriptException if a matching groovy script could not be found
	*/
	public GroovyScript findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException;

	/**
	* Returns the last groovy script in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching groovy script, or <code>null</code> if a matching groovy script could not be found
	*/
	public GroovyScript fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator);

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
	public GroovyScript[] findByUuid_C_PrevAndNext(long groovyScriptId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException;

	/**
	* Removes all the groovy scripts where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of groovy scripts where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching groovy scripts
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the groovy scripts where scriptId = &#63;.
	*
	* @param scriptId the script ID
	* @return the matching groovy scripts
	*/
	public java.util.List<GroovyScript> findByscriptId(long scriptId);

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
	public java.util.List<GroovyScript> findByscriptId(long scriptId,
		int start, int end);

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
	public java.util.List<GroovyScript> findByscriptId(long scriptId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator);

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
	public java.util.List<GroovyScript> findByscriptId(long scriptId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first groovy script in the ordered set where scriptId = &#63;.
	*
	* @param scriptId the script ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching groovy script
	* @throws NoSuchGroovyScriptException if a matching groovy script could not be found
	*/
	public GroovyScript findByscriptId_First(long scriptId,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException;

	/**
	* Returns the first groovy script in the ordered set where scriptId = &#63;.
	*
	* @param scriptId the script ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching groovy script, or <code>null</code> if a matching groovy script could not be found
	*/
	public GroovyScript fetchByscriptId_First(long scriptId,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator);

	/**
	* Returns the last groovy script in the ordered set where scriptId = &#63;.
	*
	* @param scriptId the script ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching groovy script
	* @throws NoSuchGroovyScriptException if a matching groovy script could not be found
	*/
	public GroovyScript findByscriptId_Last(long scriptId,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException;

	/**
	* Returns the last groovy script in the ordered set where scriptId = &#63;.
	*
	* @param scriptId the script ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching groovy script, or <code>null</code> if a matching groovy script could not be found
	*/
	public GroovyScript fetchByscriptId_Last(long scriptId,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator);

	/**
	* Returns the groovy scripts before and after the current groovy script in the ordered set where scriptId = &#63;.
	*
	* @param groovyScriptId the primary key of the current groovy script
	* @param scriptId the script ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next groovy script
	* @throws NoSuchGroovyScriptException if a groovy script with the primary key could not be found
	*/
	public GroovyScript[] findByscriptId_PrevAndNext(long groovyScriptId,
		long scriptId,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator)
		throws NoSuchGroovyScriptException;

	/**
	* Removes all the groovy scripts where scriptId = &#63; from the database.
	*
	* @param scriptId the script ID
	*/
	public void removeByscriptId(long scriptId);

	/**
	* Returns the number of groovy scripts where scriptId = &#63;.
	*
	* @param scriptId the script ID
	* @return the number of matching groovy scripts
	*/
	public int countByscriptId(long scriptId);

	/**
	* Caches the groovy script in the entity cache if it is enabled.
	*
	* @param groovyScript the groovy script
	*/
	public void cacheResult(GroovyScript groovyScript);

	/**
	* Caches the groovy scripts in the entity cache if it is enabled.
	*
	* @param groovyScripts the groovy scripts
	*/
	public void cacheResult(java.util.List<GroovyScript> groovyScripts);

	/**
	* Creates a new groovy script with the primary key. Does not add the groovy script to the database.
	*
	* @param groovyScriptId the primary key for the new groovy script
	* @return the new groovy script
	*/
	public GroovyScript create(long groovyScriptId);

	/**
	* Removes the groovy script with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groovyScriptId the primary key of the groovy script
	* @return the groovy script that was removed
	* @throws NoSuchGroovyScriptException if a groovy script with the primary key could not be found
	*/
	public GroovyScript remove(long groovyScriptId)
		throws NoSuchGroovyScriptException;

	public GroovyScript updateImpl(GroovyScript groovyScript);

	/**
	* Returns the groovy script with the primary key or throws a {@link NoSuchGroovyScriptException} if it could not be found.
	*
	* @param groovyScriptId the primary key of the groovy script
	* @return the groovy script
	* @throws NoSuchGroovyScriptException if a groovy script with the primary key could not be found
	*/
	public GroovyScript findByPrimaryKey(long groovyScriptId)
		throws NoSuchGroovyScriptException;

	/**
	* Returns the groovy script with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param groovyScriptId the primary key of the groovy script
	* @return the groovy script, or <code>null</code> if a groovy script with the primary key could not be found
	*/
	public GroovyScript fetchByPrimaryKey(long groovyScriptId);

	@Override
	public java.util.Map<java.io.Serializable, GroovyScript> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the groovy scripts.
	*
	* @return the groovy scripts
	*/
	public java.util.List<GroovyScript> findAll();

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
	public java.util.List<GroovyScript> findAll(int start, int end);

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
	public java.util.List<GroovyScript> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator);

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
	public java.util.List<GroovyScript> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroovyScript> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the groovy scripts from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of groovy scripts.
	*
	* @return the number of groovy scripts
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}