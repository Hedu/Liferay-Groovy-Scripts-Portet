package com.hedu.groovy.scripts.portlet.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hedu.groovy.scripts.portlet.model.GroovyScript;
import com.hedu.groovy.scripts.portlet.service.GroovyScriptLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.search.RepositorySearchQueryBuilderUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexSearcherHelperUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class SearchUtil {

	private static Log _log = LogFactoryUtil.getLog(SearchUtil.class.getName());

	public static List<GroovyScript> getLatest(HttpServletRequest httpRequest, int start, int end) {
		
		List<GroovyScript> scripts = new ArrayList<>();

		SearchContext searchContext = prepareSearchContext(
				httpRequest, start, end, 
				new Sort(Field.MODIFIED_DATE, Sort.LONG_TYPE, true));

		BooleanQuery fullQuery = prepareListQuery(searchContext);
		try {
			Hits hits = IndexSearcherHelperUtil.search(searchContext, fullQuery);
			
			Document[] docs = hits.getDocs();
			
			for (Document doc: docs) {
				long groovyScriptId = GetterUtil.getLong(doc.get("groovyScriptId"), 0L);
				
				if (groovyScriptId != 0L) {
					try {
						GroovyScript groovyScript = GroovyScriptLocalServiceUtil.getGroovyScript(groovyScriptId);
						scripts.add(groovyScript);
						if (_log.isDebugEnabled()) {
							_log.debug("Script: " + groovyScript);
						}
					}
					catch (PortalException pe) {
						_log.error("No Groovy Script exists with groovyScriptId " + groovyScriptId, pe);
					}
				}
			}
			return scripts;
		}
		catch (SearchException se) {
			_log.error("Problem searching for scripts", se);
		}
		return null;
	}

	public static int getGroovyScriptsCount(HttpServletRequest httpRequest) {
		
		SearchContext searchContext = prepareSearchContext(httpRequest);
		BooleanQuery fullQuery = prepareListQuery(searchContext);
		try {
			int count = (int)IndexSearcherHelperUtil.searchCount(searchContext, fullQuery);
			if (_log.isDebugEnabled()) {
				_log.debug("Number of scripts: " + count);
			}
			return count;
		}
		catch (SearchException se) {
			_log.error("Problem searching for scripts", se);
		}
		return 0;
	}

	private static BooleanQuery prepareListQuery(SearchContext searchContext) {

		BooleanQuery fullQuery = null;
		try {
			fullQuery = RepositorySearchQueryBuilderUtil.getFullQuery(searchContext);
			BooleanQuery searchQuery = RepositorySearchQueryBuilderUtil.getFullQuery(searchContext);

			searchQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, GroovyScript.class.getName());
			searchQuery.addRequiredTerm("latest", "true");

			fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
		}
		catch (ParseException pe) {
			_log.error("Problem creating the query", pe);
		} catch (SearchException se) {
			_log.error("Problem creating the query", se);
		}
		return fullQuery;
	}

	private static SearchContext prepareSearchContext(HttpServletRequest httpRequest, int start, int end, Sort sort) {
		SearchContext searchContext = prepareSearchContext(httpRequest);
		searchContext.setStart(start);
		searchContext.setEnd(end);
		if (sort != null) {
			searchContext.setSorts(sort);
		}
		return searchContext;
	}

	private static SearchContext prepareSearchContext(HttpServletRequest httpRequest) {
		SearchContext searchContext =
				SearchContextFactory.getInstance(httpRequest);
		String keywords = ParamUtil.get(httpRequest, "keywords", "");
		if (!"".equals(keywords)) {
			searchContext.setKeywords(keywords);
		}
		return searchContext;
	}
}
