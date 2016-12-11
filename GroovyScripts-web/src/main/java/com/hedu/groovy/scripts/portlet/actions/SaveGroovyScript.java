package com.hedu.groovy.scripts.portlet.actions;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.hedu.groovy.scripts.portlet.constants.GroovyscriptsWebpanelappPortletKeys;
import com.hedu.groovy.scripts.portlet.model.GroovyScript;
import com.hedu.groovy.scripts.portlet.service.GroovyScriptLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
	immediate = true,
	property = {
    	"javax.portlet.name=" + GroovyscriptsWebpanelappPortletKeys.GroovyscriptsWebpanelapp,
    	"mvc.command.name=" + GroovyscriptsWebpanelappPortletKeys.SAVE_GS_ACTION_COMMAND
	},
	service = MVCActionCommand.class
)
public class SaveGroovyScript extends BaseMVCActionCommand {

	Log _log = LogFactoryUtil.getLog(SaveGroovyScript.class);
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long scriptId = ParamUtil.get(actionRequest, "scriptId", 0L);
		String title = ParamUtil.get(actionRequest, "title", "");
		String description = ParamUtil.get(actionRequest, "description", "");
		String content = ParamUtil.get(actionRequest, "content", "");
		
		if (_log.isDebugEnabled()) {
			_log.debug("Params on SaveGroovyScript:");
			_log.debug("scriptId: " + scriptId);
			_log.debug("title: " + title);
			_log.debug("description: " + description);
			_log.debug("content: " + content);
		}
		
		//Validations
		GroovyScript script = null;
		Date now = new Date();
		long groovyScriptId = CounterLocalServiceUtil.increment(GroovyScript.class.getName());
		if (scriptId != 0L) {
			script = GroovyScriptLocalServiceUtil.getLatest(scriptId);
			script.setGroovyScriptId(groovyScriptId);
			script.setVersion(script.getVersion() + 0.1);
		}
		else {
			script = GroovyScriptLocalServiceUtil.createGroovyScript(groovyScriptId);
			scriptId = CounterLocalServiceUtil.increment(GroovyScript.class.getName());
			script.setScriptId(scriptId);
			script.setVersion(1.0);
			script.setCreateDate(now);
		}
		
		
		script.setTitle(title);
		script.setDescription(description);
		script.setContent(content);
		script.setUserId(themeDisplay.getUserId());
		script.setModifiedDate(now);
		
		GroovyScriptLocalServiceUtil.addGroovyScript(script);
	}

}
