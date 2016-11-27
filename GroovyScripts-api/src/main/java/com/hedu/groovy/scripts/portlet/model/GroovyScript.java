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

package com.hedu.groovy.scripts.portlet.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the GroovyScript service. Represents a row in the &quot;GROOVY_SCRIPTS_GroovyScript&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see GroovyScriptModel
 * @see com.hedu.groovy.scripts.portlet.model.impl.GroovyScriptImpl
 * @see com.hedu.groovy.scripts.portlet.model.impl.GroovyScriptModelImpl
 * @generated
 */
@ImplementationClassName("com.hedu.groovy.scripts.portlet.model.impl.GroovyScriptImpl")
@ProviderType
public interface GroovyScript extends GroovyScriptModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.hedu.groovy.scripts.portlet.model.impl.GroovyScriptImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<GroovyScript, Long> GROOVY_SCRIPT_ID_ACCESSOR = new Accessor<GroovyScript, Long>() {
			@Override
			public Long get(GroovyScript groovyScript) {
				return groovyScript.getGroovyScriptId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<GroovyScript> getTypeClass() {
				return GroovyScript.class;
			}
		};
}