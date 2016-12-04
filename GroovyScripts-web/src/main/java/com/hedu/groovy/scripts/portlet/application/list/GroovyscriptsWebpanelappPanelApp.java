package com.hedu.groovy.scripts.portlet.application.list;

import com.hedu.groovy.scripts.portlet.constants.GroovyscriptsWebpanelappPortletKeys;
import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		/*"panel.category.key=" + GroovyscriptsWebpanelappPanelCategoryKeys.CONTROL_PANEL_CATEGORY*/
		"panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL_APPS
	},
	service = PanelApp.class
)
public class GroovyscriptsWebpanelappPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return GroovyscriptsWebpanelappPortletKeys.GroovyscriptsWebpanelapp;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + GroovyscriptsWebpanelappPortletKeys.GroovyscriptsWebpanelapp + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}