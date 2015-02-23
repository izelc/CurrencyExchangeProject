package com.cavusoglu.exchange;

import java.io.IOException;
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

	private Logger logger = Logger.getLogger(getClass());
	private HashMap<String, Double> currencyCharts = new HashMap<String, Double>();

	public Charts() {
		PropertyConfigurator.configure("log4j.properties");
	//	logger.trace("constructing chart object");
		try {

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
			logger.error("error occured while constructing chart object", e);
		}

	}

	public HashMap<String, Double> getCurrencyCharts() {
		return currencyCharts;
	}

}