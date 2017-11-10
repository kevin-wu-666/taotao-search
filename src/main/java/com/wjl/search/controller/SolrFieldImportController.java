package com.wjl.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjl.common.pojo.TaotaoResult;
import com.wjl.search.service.SolrFieldService;
/**
 * solr管理面板
 * @author wujiale
 * 2017-10-30 下午10:22:53
 */
@Controller
@RequestMapping("/manager")
public class SolrFieldImportController {
	@Autowired
	private SolrFieldService solrFieldService;
	/**
	 * 导入数据到solr索引库
	 * @return
	 */
	@RequestMapping("/import")
	@ResponseBody
	public TaotaoResult importAll(){
		TaotaoResult taotaoResult = solrFieldService.importSolrField();
		return taotaoResult;
	}
}
