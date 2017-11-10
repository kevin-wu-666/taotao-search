package com.wjl.search.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjl.common.pojo.TaotaoResult;
import com.wjl.common.util.ExceptionUtil;
import com.wjl.search.pojo.SolrQueryResult;
import com.wjl.search.service.SolrSearchService;
/**
 * 为搜索框提供搜索服务的Controller
 * @author wujiale
 * 2017-10-30 下午10:23:44
 */
@Controller
public class SolrSearchController {
	@Autowired
	private SolrSearchService solrSearchService;
	
	@RequestMapping(value="/query", method=RequestMethod.GET)
	@ResponseBody
	public TaotaoResult search(@RequestParam("q")String queryString, 
			@RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="30")Integer rows) {
		//查询条件不能为空
		if (StringUtils.isBlank(queryString)) {
			return TaotaoResult.build(400, "查询条件不能为空");
		}
		SolrQueryResult searchResult = null;
		try {
			queryString = new String(queryString.getBytes("ISO8859-1"), "UTF-8");
			searchResult = solrSearchService.search(queryString, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return TaotaoResult.ok(searchResult);
		
	}

}
