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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.hedu.groovy.scripts.portlet.service.http.GroovyScriptServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.hedu.groovy.scripts.portlet.service.http.GroovyScriptServiceSoap
 * @generated
 */
@ProviderType
public class GroovyScriptSoap implements Serializable {
	public static GroovyScriptSoap toSoapModel(GroovyScript model) {
		GroovyScriptSoap soapModel = new GroovyScriptSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setGroovyScriptId(model.getGroovyScriptId());
		soapModel.setScriptId(model.getScriptId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());

		return soapModel;
	}

	public static GroovyScriptSoap[] toSoapModels(GroovyScript[] models) {
		GroovyScriptSoap[] soapModels = new GroovyScriptSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GroovyScriptSoap[][] toSoapModels(GroovyScript[][] models) {
		GroovyScriptSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GroovyScriptSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GroovyScriptSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GroovyScriptSoap[] toSoapModels(List<GroovyScript> models) {
		List<GroovyScriptSoap> soapModels = new ArrayList<GroovyScriptSoap>(models.size());

		for (GroovyScript model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GroovyScriptSoap[soapModels.size()]);
	}

	public GroovyScriptSoap() {
	}

	public long getPrimaryKey() {
		return _groovyScriptId;
	}

	public void setPrimaryKey(long pk) {
		setGroovyScriptId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getGroovyScriptId() {
		return _groovyScriptId;
	}

	public void setGroovyScriptId(long groovyScriptId) {
		_groovyScriptId = groovyScriptId;
	}

	public long getScriptId() {
		return _scriptId;
	}

	public void setScriptId(long scriptId) {
		_scriptId = scriptId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	private String _uuid;
	private long _groovyScriptId;
	private long _scriptId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _content;
}