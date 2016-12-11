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

package com.hedu.groovy.scripts.portlet.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.hedu.groovy.scripts.portlet.model.GroovyScript;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GroovyScript in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see GroovyScript
 * @generated
 */
@ProviderType
public class GroovyScriptCacheModel implements CacheModel<GroovyScript>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GroovyScriptCacheModel)) {
			return false;
		}

		GroovyScriptCacheModel groovyScriptCacheModel = (GroovyScriptCacheModel)obj;

		if (groovyScriptId == groovyScriptCacheModel.groovyScriptId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, groovyScriptId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", groovyScriptId=");
		sb.append(groovyScriptId);
		sb.append(", scriptId=");
		sb.append(scriptId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", version=");
		sb.append(version);
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GroovyScript toEntityModel() {
		GroovyScriptImpl groovyScriptImpl = new GroovyScriptImpl();

		if (uuid == null) {
			groovyScriptImpl.setUuid(StringPool.BLANK);
		}
		else {
			groovyScriptImpl.setUuid(uuid);
		}

		groovyScriptImpl.setGroovyScriptId(groovyScriptId);
		groovyScriptImpl.setScriptId(scriptId);
		groovyScriptImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			groovyScriptImpl.setCreateDate(null);
		}
		else {
			groovyScriptImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			groovyScriptImpl.setModifiedDate(null);
		}
		else {
			groovyScriptImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			groovyScriptImpl.setTitle(StringPool.BLANK);
		}
		else {
			groovyScriptImpl.setTitle(title);
		}

		if (description == null) {
			groovyScriptImpl.setDescription(StringPool.BLANK);
		}
		else {
			groovyScriptImpl.setDescription(description);
		}

		groovyScriptImpl.setVersion(version);

		if (content == null) {
			groovyScriptImpl.setContent(StringPool.BLANK);
		}
		else {
			groovyScriptImpl.setContent(content);
		}

		groovyScriptImpl.resetOriginalValues();

		return groovyScriptImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		groovyScriptId = objectInput.readLong();

		scriptId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();

		version = objectInput.readDouble();
		content = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(groovyScriptId);

		objectOutput.writeLong(scriptId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeDouble(version);

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}
	}

	public String uuid;
	public long groovyScriptId;
	public long scriptId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public double version;
	public String content;
}