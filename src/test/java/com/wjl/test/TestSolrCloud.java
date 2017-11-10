package com.wjl.test;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;


public class TestSolrCloud {
	

//	@Test
//	public void testAdd() throws SolrServerException, IOException {
//		String zkHost = "192.168.203.129:2181,192.168.203.129:2182,192.168.203.129:2183";
//		CloudSolrServer cloudSolrServer = new CloudSolrServer(zkHost );
//		cloudSolrServer.setDefaultCollection("collection2");
//		SolrInputDocument document = new SolrInputDocument();
//		document.addField("item_title", "test");
//		document.addField("id", "test");
//		cloudSolrServer.add(document);
//		cloudSolrServer.commit();
//	}
//	
//	@Test
//	public void testDelete() throws SolrServerException, IOException{
//		String zkHost = "192.168.203.129:2181,192.168.203.129:2182,192.168.203.129:2183";
//		CloudSolrServer cloudSolrServer = new CloudSolrServer(zkHost );
//		cloudSolrServer.setDefaultCollection("collection2");
//		cloudSolrServer.deleteById("test");
//		cloudSolrServer.commit();
//		
//	}

}
