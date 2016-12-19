package com.hedu.groovy.scripts.portlet.search;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;

import com.hedu.groovy.scripts.portlet.model.GroovyScript;
import com.hedu.groovy.scripts.portlet.service.GroovyScriptLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelperUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

@Component(immediate = true, service = Indexer.class)
public class GroovyScriptIndexer extends BaseIndexer<GroovyScript> {
	
	public static final String CLASS_NAME = GroovyScript.class.getName();
	private static final Log _log = LogFactoryUtil.getLog(GroovyScriptIndexer.class);

	public static long getGroovyScriptId(Document document) {
		return GetterUtil.getLong(document.get("groovyScriptId"));
	}

	public GroovyScriptIndexer() {
		setDefaultSelectedFieldNames(
			Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.ENTRY_CLASS_NAME,
			Field.ENTRY_CLASS_PK, Field.GROUP_ID, Field.MODIFIED_DATE,
			Field.SCOPE_GROUP_ID, Field.UID, Field.USER_ID);
		setPermissionAware(true);
		setStagingAware(false);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public BooleanQuery getFullQuery(SearchContext searchContext)
		throws SearchException {

		try {
			searchContext.setSearchEngineId(getSearchEngineId());

			resetFullQuery(searchContext);

			searchContext.setEntryClassNames(new String[] {GroovyScript.class.getName()});

			BooleanFilter fullQueryBooleanFilter = new BooleanFilter();

			//addSearchAssetCategoryIds(fullQueryBooleanFilter, searchContext);
			//addSearchAssetTagNames(fullQueryBooleanFilter, searchContext);
			addSearchEntryClassNames(fullQueryBooleanFilter, searchContext);
			//addSearchFolderId(fullQueryBooleanFilter, searchContext);
			//addSearchGroupId(fullQueryBooleanFilter, searchContext);
			//addSearchLayout(fullQueryBooleanFilter, searchContext);
			//addSearchUserId(fullQueryBooleanFilter, searchContext);

			BooleanQuery fullQuery = createFullQuery(
				fullQueryBooleanFilter, searchContext);

			fullQuery.setQueryConfig(searchContext.getQueryConfig());

			return fullQuery;
		}
		catch (SearchException se) {
			throw se;
		}
		catch (Exception e) {
			throw new SearchException(e);
		}
	}

	@Override
	protected void doDelete(GroovyScript groovyScript) throws Exception {
		deleteDocument(groovyScript.getCompanyId(), groovyScript.getGroovyScriptId());
		
		GroovyScript latestScript = 
				GroovyScriptLocalServiceUtil.getLatest(groovyScript.getScriptId());
		
		if (latestScript != null) {
			doReindex(latestScript);
		}
		if (_log.isDebugEnabled()) {
			_log.debug("Deleted script: " + groovyScript.getGroovyScriptId());
		}
	}

	@Override
	protected Document doGetDocument(GroovyScript groovyScript) throws Exception {
		Document document = getBaseModelDocument(CLASS_NAME, groovyScript);
		
		document.addKeyword(Field.COMPANY_ID, groovyScript.getCompanyId());
		document.addKeyword(Field.USER_ID, groovyScript.getUserId());
		document.addKeyword("groovyScriptId", groovyScript.getGroovyScriptId());
		document.addKeyword("scriptId", groovyScript.getScriptId());

		document.addText("title", groovyScript.getTitle());
		document.addText("description", groovyScript.getDescription());
		document.addText("content", groovyScript.getContent());
		document.addNumber("version", groovyScript.getVersion());
		
		document.addDate(Field.CREATE_DATE, groovyScript.getCreateDate());
		document.addDate(Field.MODIFIED_DATE, groovyScript.getModifiedDate());
		
		GroovyScript latestScript = 
				GroovyScriptLocalServiceUtil.getLatest(groovyScript.getScriptId());
		
		if (latestScript != null && latestScript.getGroovyScriptId() == groovyScript.getGroovyScriptId()) {
			document.addText("latest", "true");
		}
		else {
			document.addText("latest", "false");
		}
		
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {
		
			String title = document.get("title");
			String content = document.get("description");
			
			return new Summary(title, content);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		GroovyScript groovyScript = GroovyScriptLocalServiceUtil.getGroovyScript(classPK);
		
		doReindex(groovyScript);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		
		reindexGroovyScripts(companyId);
	}

	@Override
	protected void doReindex(GroovyScript groovyScript) throws Exception {
		List<GroovyScript> scripts = GroovyScriptLocalServiceUtil.getScriptsByScriptId(groovyScript.getScriptId());
		
		for (GroovyScript script : scripts) {
			Document document = getDocument(script);
		
			IndexWriterHelperUtil.updateDocument(
				getSearchEngineId(), groovyScript.getCompanyId(), document,
				isCommitImmediately());
		}
		if (_log.isDebugEnabled()) {
			_log.debug("Reindexed script: " + groovyScript);
		}
		
	}

	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
			SearchContext searchContext)
		throws Exception {}

	@Override
	protected Map<String, Query> addSearchKeywords(
			BooleanQuery searchQuery, SearchContext searchContext)
		throws Exception {

		Map<String, Query> searchKeyWords = super.addSearchKeywords(searchQuery, searchContext);

		if (searchKeyWords.isEmpty()) {
			return searchKeyWords;
		}
		String keywords = searchContext.getKeywords();

		String[] fields = {"title", "content", "description"};
		return searchQuery.addTerms(
				fields, keywords, searchContext.isLike());
	}

	protected void reindexGroovyScripts(long companyId) throws PortalException {
		final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
				GroovyScriptLocalServiceUtil.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<GroovyScript>() {

				@Override
				public void performAction(GroovyScript groovyScript) {
					try {
						Document document = getDocument(groovyScript);

						indexableActionableDynamicQuery.addDocuments(
							document);
					}
					catch (PortalException pe) {
						if (_log.isWarnEnabled()) {
							_log.warn(
								"Unable to index groovyScript " + groovyScript.getGroovyScriptId(),
								pe);
						}
					}
				}

			});
		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());

		indexableActionableDynamicQuery.performActions();
	}

}
