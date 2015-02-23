package com.cavusoglu.exchange;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;

/**
 * @author Izel Cavusoglu This class defines parities and values of parities are
 *         taken from web dynamically.
 *
 */
public class Charts {
	

	//private static Logger logger = Logger.getLogger(getClass());
	private static HashMap<String, Double> currencyCharts = new HashMap<String, Double>();

	private Charts() {}
	
	

	public static HashMap<String, Double> getCurrencyCharts() {
		fillHasHmap();
		return currencyCharts;
	}
	
	public static void fillHasHmap() {
//		logger.trace("constructing chart object");
			try {
				PropertyConfigurator.configure("log4j.properties");

				currencyCharts.put("USD/GBP",
						new GoogleCurrencyFetcher().getParity("USDGBP"));

				currencyCharts.put("EUR/USD",
						new GoogleCurrencyFetcher().getParity("EURUSD"));

				currencyCharts.put("EUR/GBP",
						new GoogleCurrencyFetcher().getParity("EURGBP"));

				currencyCharts.put("TL/GBP",
						new GoogleCurrencyFetcher().getParity("TRYGBP"));

				currencyCharts.put("TL/USD",
						new GoogleCurrencyFetcher().getParity("TRYUSD"));

				currencyCharts.put("TL/EUR",
						new GoogleCurrencyFetcher().getParity("TRYEUR"));

			} catch (Exception e) {
			//	logger.error("error occured while constructing chart object", e);
			}

	}

}