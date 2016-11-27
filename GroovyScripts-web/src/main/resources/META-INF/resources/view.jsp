<%@ include file="/init.jsp" %>
<%@ page import="com.hedu.groovy.scripts.portlet.service.GroovyScriptLocalServiceUtil"  %>
<p>
	<b><liferay-ui:message key="groovyscripts_web_GroovyscriptsWebmvcportlet.caption"/></b>
</p>

<liferay-ui:search-container delta="20" emptyResultsMessage="no-scripts-saved" >
</liferay-ui:search-container>

<portlet:renderURL var="iteratorURL">
</portlet:renderURL>

<liferay-ui:search-container delta="2" emptyResultsMessage="no-scripts-saved" iteratorURL="<%=iteratorURL%>">
11    <liferay-ui:search-container-results  results="<%= GroovyScriptLocalServiceUtil.getGroovyScripts(searchContainer.getStart(), searchContainer.getEnd()) %>" />
12    <liferay-ui:search-container-row className="com.hedu.groovy.scripts.portlet.model.GroovyScript" keyProperty="groovyScriptId" modelVar="script">
13        <liferay-ui:search-container-column-text name="Title" value="${script.title}" />
14        <liferay-ui:search-container-column-text name="Version" value="${script.version}" />
16        <%-- <liferay-ui:search-container-column-jsp path="/WEB-INF/jsp/scriptActions.jsp" align="right" /> --%>
17    </liferay-ui:search-container-row>
18    <liferay-ui:search-iterator />
19</liferay-ui:search-container>