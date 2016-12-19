<%@ include file="/init.jsp" %>
<%@ page import="com.hedu.groovy.scripts.portlet.service.GroovyScriptLocalServiceUtil"  %>
<%@ page import="com.hedu.groovy.scripts.portlet.search.SearchUtil"  %>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</liferay-portlet:renderURL>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav-bar-search>
		<aui:form action="<%= searchURL.toString() %>" method="post" name="fm1">
			<liferay-ui:input-search markupView="lexicon" />
		</aui:form>
	</aui:nav-bar-search>
</aui:nav-bar>

<liferay-ui:search-container delta="10" headerNames="title, description, version" emptyResultsMessage="no-scripts-saved" iteratorURL="<%=searchURL%>" total="<%=SearchUtil.getGroovyScriptsCount(request) %>">
	<liferay-ui:search-container-results  results="<%= SearchUtil.getLatest(request, searchContainer.getStart(), searchContainer.getEnd()) %>" />
	<liferay-ui:search-container-row className="com.hedu.groovy.scripts.portlet.model.GroovyScript" keyProperty="groovyScriptId" modelVar="script">
		<liferay-ui:search-container-column-text name="Title" value="${script.title}" />
		<liferay-ui:search-container-column-text name="Description" value="${script.description}" />
		<liferay-ui:search-container-column-text name="Version" value="${script.version}" />
		<%-- <liferay-ui:search-container-column-jsp path="/WEB-INF/jsp/scriptActions.jsp" align="right" /> --%>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<liferay-util:include page="/add_button.jsp" servletContext="<%= application %>" />