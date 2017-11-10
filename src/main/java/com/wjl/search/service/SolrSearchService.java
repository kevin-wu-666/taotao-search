package com.wjl.search.service;

import org.apache.solr.client.solrj.SolrServerException;

import com.wjl.search.pojo.SolrQueryResult;

public interface SolrSearchService {
	SolrQueryResult search(String queryString, int page, int rows) throws SolrServerException;
}
