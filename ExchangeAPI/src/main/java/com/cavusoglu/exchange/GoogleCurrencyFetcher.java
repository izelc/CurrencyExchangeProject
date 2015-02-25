package com.cavusoglu.exchange;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;

public class GoogleCurrencyFetcher {

	private Logger logger = Logger.getLogger(getClass());
	DocumentFetcher documentFetcher;
	
	
	public GoogleCurrencyFetcher() {

	documentFetcher=new DocumentFetcher();
	}
	
	public GoogleCurrencyFetcher(DocumentFetcher documentFetcher){
		
		this.documentFetcher=documentFetcher;
	}

	/**
	 * @param q
	 *            It provides related section of <a
	 *            href='https://www.google.com/finance?q='>google finance</a>
	 *            to return the ratio between currencies
	 * @return The document that contains parities
	 */
	public double getParity(String q) {
		

		Document document = documentFetcher.getDocument(q);
		
		String cssPath="#currency_value > div.sfe-break-bottom-4 > span.pr > span";
		
		logger.trace("Parity is found :" + convertCurrencyDataToDouble(document.select(cssPath).text())+" for "+q);
		
		return convertCurrencyDataToDouble(document.select(cssPath).text());
		
	}


	

	/**
	 * Removes all non numeric characters in data and then converts data to
	 * double.
	 * 
	 * @param str
	 *            {@link String} that contains both numeric and non numeric
	 *            values.
	 * @return String that cleaned from non numeric values and converted to
	 *         double.
	 */
	public double convertCurrencyDataToDouble(String str) {
		/*
		 * removes all non numeric characters in data and then converts data to
		 * double
		 */
		str = str.replaceAll("[^\\d.]", "");
		return Double.parseDouble(str);
	}

	
	
}


