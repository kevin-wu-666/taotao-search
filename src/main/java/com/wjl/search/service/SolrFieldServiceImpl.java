package com.wjl.search.service;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wjl.common.pojo.TaotaoResult;
import com.wjl.common.util.ExceptionUtil;
import com.wjl.search.mapper.SolrFieldMapper;
import com.wjl.search.pojo.SolrField;
/**
 * 导入数据到solr索引库
 * @author wujiale
 * 2017-10-30 下午10:25:39
 */
@Service
public class SolrFieldServiceImpl implements SolrFieldService{
	@Autowired
	private SolrFieldMapper solrFieldMapper;
	
	@Autowired
	private SolrServer solrServer;

	@Override
	public TaotaoResult importSolrField() {
		try {
			List<SolrField> list = solrFieldMapper.getFieldList();
			for (SolrField item : list) {
				SolrInputDocument document = new SolrInputDocument();
				document.setField("id", item.getId());
				document.setField("item_title", item.getTitle());
				document.setField("item_sell_point", item.getSell_point());
				document.setField("item_price", item.getPrice());
				document.setField("item_image", item.getImage());
				document.setField("item_category_name", item.getCategory_name());
				document.setField("item_desc", item.getItem_desc());
				//写入索引库
				solrServer.add(document);
			}
			//提交修改
			solrServer.commit();
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return TaotaoResult.ok();
	}

}
