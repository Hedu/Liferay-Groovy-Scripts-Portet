package com.hedu.groovy.scripts.portlet.actions;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.hedu.groovy.scripts.portlet.constants.GroovyscriptsWebpanelappPortletKeys;
import com.hedu.groovy.scripts.portlet.model.GroovyScript;
import com.hedu.groovy.scripts.portlet.service.GroovyScriptLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
	immediate = true,
	property = {
    	"javax.portlet.name=" + GroovyscriptsWebpanelappPortletKeys.GroovyscriptsWebpanelapp,
    	"mvc.command.name=" + GroovyscriptsWebpanelappPortletKeys.EDIT_GS_RENDER_COMMAND
	},
	service = MVCRenderCommand.class
)
public class EditGroovyScript implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		
		long scriptId = ParamUtil.get(renderRequest, "scriptId", 0L);
		if (scriptId != 0L) {
			GroovyScript lastest = GroovyScriptLocalServiceUtil.getLatest(scriptId);
			renderRequest.setAttribute("script", lastest);
		}
		return "/edit.jsp";
	}

}
