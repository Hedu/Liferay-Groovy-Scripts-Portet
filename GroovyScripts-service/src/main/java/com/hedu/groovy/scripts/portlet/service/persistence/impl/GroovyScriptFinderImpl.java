package com.hedu.groovy.scripts.portlet.service.persistence.impl;

import java.util.List;

import com.hedu.groovy.scripts.portlet.model.GroovyScript;
import com.hedu.groovy.scripts.portlet.service.persistence.GroovyScriptFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;


public class GroovyScriptFinderImpl extends GroovyScriptFinderBaseImpl implements GroovyScriptFinder{

	public List<GroovyScript> findLatest(int begin, int end) {

		    Session session = null;
		    try {
		        session = openSession();

		        String sql = CustomSQLUtil.get(getClass(),
		        		FIND_LATEST);

		        SQLQuery q = session.createSQLQuery(sql);
		        q.setCacheable(true);

		        return (List<GroovyScript>) QueryUtil.list(q, getDialect(), begin, end);
		    }
		    catch (Exception e) {
		        try {
		            throw new SystemException(e);
		        }
		        catch (SystemException se) {
		            se.printStackTrace();
		        }
		    }
		    finally {
		        closeSession(session);
		    }

		    return null;
		}

		public static final String FIND_LATEST =
				GroovyScriptFinder.class.getName() +
		        ".findLatest";
}
