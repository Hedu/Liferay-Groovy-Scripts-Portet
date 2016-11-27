create table GROOVY_SCRIPTS_GroovyScript (
	uuid_ VARCHAR(75) null,
	groovyScriptId LONG not null primary key,
	scriptId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	Description VARCHAR(75) null,
	version DOUBLE,
	content VARCHAR(75) null
);