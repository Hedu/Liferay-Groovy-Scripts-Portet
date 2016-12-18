<%@ include file="/init.jsp" %>

<%
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("mvcPath", "/view.jsp");
String portletURLString = portletURL.toString();
%>

<liferay-portlet:renderURL varImpl="editEntryURL">
    <portlet:param name="mvcRenderCommandName" value="<%=GroovyscriptsWebpanelappPortletKeys.EDIT_GS_RENDER_COMMAND %>" />
    <portlet:param name="redirect" value="<%=portletURLString %>"/>
    <%-- portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" /--%>
</liferay-portlet:renderURL>

<liferay-frontend:add-menu>
    <liferay-frontend:add-menu-item title='add' url="<%= editEntryURL.toString() %>" />
</liferay-frontend:add-menu>