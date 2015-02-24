package com.cavusoglu.exchange;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GoogleCurrencyFetcher {

	private Logger logger = Logger.getLogger(getClass());
	

	

	/**
	 * @param q
	 *            It provides related section of <a
	 *            href='https://www.google.com/finance?q='>google finance</a>
	 * @return the document that contains parities
	 */
	public double getParity(String q) {

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
		//logger.trace("Got document from site: " + site);
		
		
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


