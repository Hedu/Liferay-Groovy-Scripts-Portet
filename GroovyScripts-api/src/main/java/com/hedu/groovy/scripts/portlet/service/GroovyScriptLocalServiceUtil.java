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

package com.hedu.groovy.scripts.portlet.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for GroovyScript. This utility wraps
 * {@link com.hedu.groovy.scripts.portlet.service.impl.GroovyScriptLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see GroovyScriptLocalService
 * @see com.hedu.groovy.scripts.portlet.service.base.GroovyScriptLocalServiceBaseImpl
 * @see com.hedu.groovy.scripts.portlet.service.impl.GroovyScriptLocalServiceImpl
 * @generated
 */
@ProviderType
public class GroovyScriptLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.hedu.groovy.scripts.portlet.service.impl.GroovyScriptLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the groovy script to the database. Also notifies the appropriate model listeners.
	*
	* @param groovyScript the groovy script
	* @return the groovy script that was added
	*/
	public static com.hedu.groovy.scripts.portlet.model.GroovyScript addGroovyScript(
		com.hedu.groovy.scripts.portlet.model.GroovyScript groovyScript) {
		return getService().addGroovyScript(groovyScript);
	}

	/**
	* Creates a new groovy script with the primary key. Does not add the groovy script to the database.
	*
	* @param groovyScriptId the primary key for the new groovy script
	* @return the new groovy script
	*/
	public static com.hedu.groovy.scripts.portlet.model.GroovyScript createGroovyScript(
		long groovyScriptId) {
		return getService().createGroovyScript(groovyScriptId);
	}

	/**
	* Deletes the groovy script from the database. Also notifies the appropriate model listeners.
	*
	* @param groovyScript the groovy script
	* @return the groovy script that was removed
	*/
	public static com.hedu.groovy.scripts.portlet.model.GroovyScript deleteGroovyScript(
		com.hedu.groovy.scripts.portlet.model.GroovyScript groovyScript) {
		return getService().deleteGroovyScript(groovyScript);
	}

	/**
	* Deletes the groovy script with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groovyScriptId the primary key of the groovy script
	* @return the groovy script that was removed
	* @throws PortalException if a groovy script with the primary key could not be found
	*/
	public static com.hedu.groovy.scripts.portlet.model.GroovyScript deleteGroovyScript(
		long groovyScriptId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteGroovyScript(groovyScriptId);
	}

	public static com.hedu.groovy.scripts.portlet.model.GroovyScript fetchGroovyScript(
		long groovyScriptId) {
		return getService().fetchGroovyScript(groovyScriptId);
	}

	/**
	* Returns the groovy script with the matching UUID and company.
	*
	* @param uuid the groovy script's UUID
	* @param companyId the primary key of the company
	* @return the matching groovy script, or <code>null</code> if a matching groovy script could not be found
	*/
	public static com.hedu.groovy.scripts.portlet.model.GroovyScript fetchGroovyScriptByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().fetchGroovyScriptByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the groovy script with the primary key.
	*
	* @param groovyScriptId the primary key of the groovy script
	* @return the groovy script
	* @throws PortalException if a groovy script with the primary key could not be found
	*/
	public static com.hedu.groovy.scripts.portlet.model.GroovyScript getGroovyScript(
		long groovyScriptId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getGroovyScript(groovyScriptId);
	}

	/**
	* Returns the groovy script with the matching UUID and company.
	*
	* @param uuid the groovy script's UUID
	* @param companyId the primary key of the company
	* @return the matching groovy script
	* @throws PortalException if a matching groovy script could not be found
	*/
	public static com.hedu.groovy.scripts.portlet.model.GroovyScript getGroovyScriptByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getGroovyScriptByUuidAndCompanyId(uuid, companyId);
	}

	public static com.hedu.groovy.scripts.portlet.model.GroovyScript getLatest(
		long scriptId) {
		return getService().getLatest(scriptId);
	}

	/**
	* Updates the groovy script in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param groovyScript the groovy script
	* @return the groovy script that was updated
	*/
	public static com.hedu.groovy.scripts.portlet.model.GroovyScript updateGroovyScript(
		com.hedu.groovy.scripts.portlet.model.GroovyScript groovyScript) {
		return getService().updateGroovyScript(groovyScript);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of groovy scripts.
	*
	* @return the number of groovy scripts
	*/
	public static int getGroovyScriptsCount() {
		return getService().getGroovyScriptsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.hedu.groovy.scripts.portlet.model.impl.GroovyScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.hedu.groovy.scripts.portlet.model.impl.GroovyScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the groovy scripts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.hedu.groovy.scripts.portlet.model.impl.GroovyScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of groovy scripts
	* @param end the upper bound of the range of groovy scripts (not inclusive)
	* @return the range of groovy scripts
	*/
	public static java.util.List<com.hedu.groovy.scripts.portlet.model.GroovyScript> getGroovyScripts(
		int start, int end) {
		return getService().getGroovyScripts(start, end);
	}

	public static java.util.List<com.hedu.groovy.scripts.portlet.model.GroovyScript> getLatest(
		int begin, int end) {
		return getService().getLatest(begin, end);
	}

	public static java.util.List<com.hedu.groovy.scripts.portlet.model.GroovyScript> getScriptsByScriptId(
		long scriptId) {
		return getService().getScriptsByScriptId(scriptId);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static GroovyScriptLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GroovyScriptLocalService, GroovyScriptLocalService> _serviceTracker =
		ServiceTrackerFactory.open(GroovyScriptLocalService.class);
}