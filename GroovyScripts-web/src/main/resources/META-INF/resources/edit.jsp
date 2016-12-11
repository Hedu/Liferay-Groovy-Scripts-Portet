<%@page import="com.hedu.groovy.scripts.portlet.model.GroovyScript"%>
<%@ include file="/init.jsp" %>
<%@ page import="com.hedu.groovy.scripts.portlet.service.GroovyScriptLocalServiceUtil"  %>

<% GroovyScript script = (GroovyScript)request.getAttribute("script"); %>

<liferay-portlet:actionURL
 name="<%=GroovyscriptsWebpanelappPortletKeys.SAVE_GS_ACTION_COMMAND %>" var="saveURL"/>

<aui:form  method="POST" action="${saveURL}">
	<c:if test="<%= script != null %>">
		<aui:input name="scriptId" type="hidden" value="${script.scriptId }"/>
	</c:if>
	<aui:input name="title" value='<%= (script!= null)?script.getTitle():"" %>' />
	<aui:input name="description" value='<%= (script!= null)?script.getDescription():"" %>' />
	<aui:input name="content" value='<%= (script!= null)?script.getContent():"" %>' />
	
	<aui:button name="submit" value="save" type="submit" />
</aui:form>