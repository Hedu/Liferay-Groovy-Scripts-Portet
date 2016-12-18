<%@ include file="/init.jsp" %>
<%@ page import="com.hedu.groovy.scripts.portlet.service.GroovyScriptLocalServiceUtil"  %>
<%@ page import="com.hedu.groovy.scripts.portlet.search.SearchUtil"  %>
<p>
	<b><liferay-ui:message key="groovyscripts_web_GroovyscriptsWebmvcportlet.caption"/></b>
</p>

<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="mvcPath" value="/view.jsp" />
</liferay-portlet:renderURL>

<liferay-ui:search-container delta="2" headerNames="title, description, version" emptyResultsMessage="no-scripts-saved" iteratorURL="<%=iteratorURL%>" total="<%=SearchUtil.getGroovyScriptsCount(request) %>">
    <liferay-ui:search-container-results  results="<%= SearchUtil.getLatest(request, searchContainer.getStart(), searchContainer.getEnd()) %>" />
    <liferay-ui:search-container-row className="com.hedu.groovy.scripts.portlet.model.GroovyScript" keyProperty="groovyScriptId" modelVar="script">
        <liferay-ui:search-container-column-text name="Title" value="${script.title}" />
        <liferay-ui:search-container-column-text name="Description" value="${script.description}" />
        <liferay-ui:search-container-column-text name="Version" value="${script.version}" />
        <%-- <liferay-ui:search-container-column-jsp path="/WEB-INF/jsp/scriptActions.jsp" align="right" /> --%>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>

<liferay-portlet:renderURL varImpl="editEntryURL">
    <portlet:param name="mvcRenderCommandName" value="<%=GroovyscriptsWebpanelappPortletKeys.EDIT_GS_RENDER_COMMAND %>" />
    <%-- portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" /--%>
</liferay-portlet:renderURL>

<a href="<%=editEntryURL.toString() %>">add</a>