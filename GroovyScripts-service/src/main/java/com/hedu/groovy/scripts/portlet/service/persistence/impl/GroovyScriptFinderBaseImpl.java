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

import com.hedu.groovy.scripts.portlet.model.GroovyScript;
import com.hedu.groovy.scripts.portlet.service.persistence.GroovyScriptPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GroovyScriptFinderBaseImpl extends BasePersistenceImpl<GroovyScript> {
	@Override
	public Set<String> getBadColumnNames() {
		return getGroovyScriptPersistence().getBadColumnNames();
	}

	/**
	 * Returns the groovy script persistence.
	 *
	 * @return the groovy script persistence
	 */
	public GroovyScriptPersistence getGroovyScriptPersistence() {
		return groovyScriptPersistence;
	}

	/**
	 * Sets the groovy script persistence.
	 *
	 * @param groovyScriptPersistence the groovy script persistence
	 */
	public void setGroovyScriptPersistence(
		GroovyScriptPersistence groovyScriptPersistence) {
		this.groovyScriptPersistence = groovyScriptPersistence;
	}

	@BeanReference(type = GroovyScriptPersistence.class)
	protected GroovyScriptPersistence groovyScriptPersistence;
}