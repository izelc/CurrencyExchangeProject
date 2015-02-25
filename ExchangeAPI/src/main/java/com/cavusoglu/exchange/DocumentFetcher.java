package com.cavusoglu.exchange;

import java.io.IOException;



import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DocumentFetcher {
	
	private Logger logger = Logger.getLogger(getClass());

	public Document getDocument(String q) {
		String site = "https://www.google.com/finance?q=" + q;
		//logger.debug("Getting document from site: " + site);
		Document document = null;
		try {
			document = Jsoup.connect(site).get();
		} catch (IOException e) {

			logger.error(
					"Error occured while getting document from this site: "
							+ site, e);
		}
		return document;
	}
}
