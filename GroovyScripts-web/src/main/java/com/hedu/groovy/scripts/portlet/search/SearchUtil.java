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
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.GetterUtil;

public class SearchUtil {

	private static Log _log = LogFactoryUtil.getLog(SearchUtil.class.getName());

	public static List<GroovyScript> getLatest(HttpServletRequest httpRequest, int start, int end) {
		
		List<GroovyScript> scripts = new ArrayList<>();
		SearchContext searchContext =
				SearchContextFactory.getInstance(httpRequest); 

		searchContext.setStart(start);
		searchContext.setEnd(end);
		searchContext.setSorts(new Sort(Field.MODIFIED_DATE, true));

		Indexer<?> indexer = IndexerRegistryUtil.getIndexer(GroovyScript.class);

		try {
			BooleanQuery fullQuery = RepositorySearchQueryBuilderUtil.getFullQuery(searchContext);
			BooleanQuery searchQuery = RepositorySearchQueryBuilderUtil.getFullQuery(searchContext);
		
			searchQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, GroovyScript.class.getName()); 
			searchQuery.addRequiredTerm("latest", "true");
			fullQuery.add(searchQuery, BooleanClauseOccur.MUST); 
		 
			Hits hits = IndexSearcherHelperUtil.search(searchContext, fullQuery);
			
			Document[] docs = hits.getDocs();
			
			for (Document doc: docs) {
				long groovyScriptId = GetterUtil.getLong(doc.get("groovyScriptId"), 0L);
				
				if (groovyScriptId != 0L) {
					try {
						GroovyScript groovyScript = GroovyScriptLocalServiceUtil.getGroovyScript(groovyScriptId);
						scripts.add(groovyScript);
					}
					catch (PortalException pe) {
						if (_log.isInfoEnabled()) {
							_log.info("No Groovy Script exists with groovyScriptId " + groovyScriptId, pe);
						}
					}
					
				}
			}
			return scripts;
		}
		catch (SearchException se) {
		    _log.error("Error searching on indexes: ", se);
		} catch (ParseException e) {
			_log.error("Error creating query: ", e);
		}
		return null;
		
	}
}
