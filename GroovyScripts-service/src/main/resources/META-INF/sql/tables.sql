create table GS_GroovyScript (
	uuid_ VARCHAR(75) null,
	groovyScriptId LONG not null primary key,
	scriptId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(255) null,
	description VARCHAR(75) null,
	version DOUBLE,
	content STRING null
);