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

package com.hedu.groovy.scripts.portlet.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.hedu.groovy.scripts.portlet.service.base.GroovyScriptServiceBaseImpl;

/**
 * The implementation of the groovy script remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.hedu.groovy.scripts.portlet.service.GroovyScriptService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroovyScriptServiceBaseImpl
 * @see com.hedu.groovy.scripts.portlet.service.GroovyScriptServiceUtil
 */
@ProviderType
public class GroovyScriptServiceImpl extends GroovyScriptServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.hedu.groovy.scripts.portlet.service.GroovyScriptServiceUtil} to access the groovy script remote service.
	 */
}