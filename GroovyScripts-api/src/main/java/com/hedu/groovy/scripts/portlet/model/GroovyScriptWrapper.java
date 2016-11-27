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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link GroovyScript}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroovyScript
 * @generated
 */
@ProviderType
public class GroovyScriptWrapper implements GroovyScript,
	ModelWrapper<GroovyScript> {
	public GroovyScriptWrapper(GroovyScript groovyScript) {
		_groovyScript = groovyScript;
	}

	@Override
	public Class<?> getModelClass() {
		return GroovyScript.class;
	}

	@Override
	public String getModelClassName() {
		return GroovyScript.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("groovyScriptId", getGroovyScriptId());
		attributes.put("scriptId", getScriptId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long groovyScriptId = (Long)attributes.get("groovyScriptId");

		if (groovyScriptId != null) {
			setGroovyScriptId(groovyScriptId);
		}

		Long scriptId = (Long)attributes.get("scriptId");

		if (scriptId != null) {
			setScriptId(scriptId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	@Override
	public GroovyScript toEscapedModel() {
		return new GroovyScriptWrapper(_groovyScript.toEscapedModel());
	}

	@Override
	public GroovyScript toUnescapedModel() {
		return new GroovyScriptWrapper(_groovyScript.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _groovyScript.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _groovyScript.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _groovyScript.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _groovyScript.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<GroovyScript> toCacheModel() {
		return _groovyScript.toCacheModel();
	}

	@Override
	public int compareTo(GroovyScript groovyScript) {
		return _groovyScript.compareTo(groovyScript);
	}

	@Override
	public int hashCode() {
		return _groovyScript.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _groovyScript.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new GroovyScriptWrapper((GroovyScript)_groovyScript.clone());
	}

	/**
	* Returns the content of this groovy script.
	*
	* @return the content of this groovy script
	*/
	@Override
	public java.lang.String getContent() {
		return _groovyScript.getContent();
	}

	/**
	* Returns the title of this groovy script.
	*
	* @return the title of this groovy script
	*/
	@Override
	public java.lang.String getTitle() {
		return _groovyScript.getTitle();
	}

	/**
	* Returns the user uuid of this groovy script.
	*
	* @return the user uuid of this groovy script
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _groovyScript.getUserUuid();
	}

	/**
	* Returns the uuid of this groovy script.
	*
	* @return the uuid of this groovy script
	*/
	@Override
	public java.lang.String getUuid() {
		return _groovyScript.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _groovyScript.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _groovyScript.toXmlString();
	}

	/**
	* Returns the create date of this groovy script.
	*
	* @return the create date of this groovy script
	*/
	@Override
	public Date getCreateDate() {
		return _groovyScript.getCreateDate();
	}

	/**
	* Returns the modified date of this groovy script.
	*
	* @return the modified date of this groovy script
	*/
	@Override
	public Date getModifiedDate() {
		return _groovyScript.getModifiedDate();
	}

	/**
	* Returns the groovy script ID of this groovy script.
	*
	* @return the groovy script ID of this groovy script
	*/
	@Override
	public long getGroovyScriptId() {
		return _groovyScript.getGroovyScriptId();
	}

	/**
	* Returns the primary key of this groovy script.
	*
	* @return the primary key of this groovy script
	*/
	@Override
	public long getPrimaryKey() {
		return _groovyScript.getPrimaryKey();
	}

	/**
	* Returns the script ID of this groovy script.
	*
	* @return the script ID of this groovy script
	*/
	@Override
	public long getScriptId() {
		return _groovyScript.getScriptId();
	}

	/**
	* Returns the user ID of this groovy script.
	*
	* @return the user ID of this groovy script
	*/
	@Override
	public long getUserId() {
		return _groovyScript.getUserId();
	}

	@Override
	public void persist() {
		_groovyScript.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_groovyScript.setCachedModel(cachedModel);
	}

	/**
	* Sets the content of this groovy script.
	*
	* @param content the content of this groovy script
	*/
	@Override
	public void setContent(java.lang.String content) {
		_groovyScript.setContent(content);
	}

	/**
	* Sets the create date of this groovy script.
	*
	* @param createDate the create date of this groovy script
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_groovyScript.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_groovyScript.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_groovyScript.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_groovyScript.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the groovy script ID of this groovy script.
	*
	* @param groovyScriptId the groovy script ID of this groovy script
	*/
	@Override
	public void setGroovyScriptId(long groovyScriptId) {
		_groovyScript.setGroovyScriptId(groovyScriptId);
	}

	/**
	* Sets the modified date of this groovy script.
	*
	* @param modifiedDate the modified date of this groovy script
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_groovyScript.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_groovyScript.setNew(n);
	}

	/**
	* Sets the primary key of this groovy script.
	*
	* @param primaryKey the primary key of this groovy script
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_groovyScript.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_groovyScript.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the script ID of this groovy script.
	*
	* @param scriptId the script ID of this groovy script
	*/
	@Override
	public void setScriptId(long scriptId) {
		_groovyScript.setScriptId(scriptId);
	}

	/**
	* Sets the title of this groovy script.
	*
	* @param title the title of this groovy script
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_groovyScript.setTitle(title);
	}

	/**
	* Sets the user ID of this groovy script.
	*
	* @param userId the user ID of this groovy script
	*/
	@Override
	public void setUserId(long userId) {
		_groovyScript.setUserId(userId);
	}

	/**
	* Sets the user uuid of this groovy script.
	*
	* @param userUuid the user uuid of this groovy script
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_groovyScript.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this groovy script.
	*
	* @param uuid the uuid of this groovy script
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_groovyScript.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GroovyScriptWrapper)) {
			return false;
		}

		GroovyScriptWrapper groovyScriptWrapper = (GroovyScriptWrapper)obj;

		if (Objects.equals(_groovyScript, groovyScriptWrapper._groovyScript)) {
			return true;
		}

		return false;
	}

	@Override
	public GroovyScript getWrappedModel() {
		return _groovyScript;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _groovyScript.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _groovyScript.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_groovyScript.resetOriginalValues();
	}

	private final GroovyScript _groovyScript;
}