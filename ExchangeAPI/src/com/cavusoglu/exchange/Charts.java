package com.cavusoglu.exchange;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Izel Cavusoglu This class defines parities and values of parities are
 *         taken from web dynamically.
 *
 */
public class Charts {
	

	private static final Logger logger = Logger.getLogger(Charts.class);
	private HashMap<String, Double> currencyCharts = new HashMap<String, Double>();
	private static Charts chart = null;
	private ScheduledExecutorService executor = Executors
			.newScheduledThreadPool(1);

	private Charts() {
	System.err.println("Charts constructor is working");
	logger.trace("getInstance");
		executor.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				fillHasHmap();
			}
		}, 0, 2, TimeUnit.MINUTES);
	}

	public static Charts getInstance() {
		logger.trace("getInstance");
		System.err.println("getInstance() is working");

		if (chart == null) {
			chart = new Charts();
			
		}
		return chart;
	}

	public void fillHasHmap() {
		logger.trace("constructing chart object");
		System.err.println("fillHashMap() is working");
		try {
			PropertyConfigurator.configure("log4j.properties");

			getCurrencyCharts().put("USD/GBP",
					new GoogleCurrencyFetcher().getParity("USDGBP"));

			getCurrencyCharts().put("EUR/USD",
					new GoogleCurrencyFetcher().getParity("EURUSD"));

			getCurrencyCharts().put("EUR/GBP",
					new GoogleCurrencyFetcher().getParity("EURGBP"));

			getCurrencyCharts().put("TL/GBP",
					new GoogleCurrencyFetcher().getParity("TRYGBP"));

			getCurrencyCharts().put("TL/USD",
					new GoogleCurrencyFetcher().getParity("TRYUSD"));

			getCurrencyCharts().put("TL/EUR",
					new GoogleCurrencyFetcher().getParity("TRYEUR"));

		} catch (Exception e) {
		 logger.error("error occured while constructing hashMap", e);
		 System.err.println("Error occured while fillHashMap() is working");
		}

	}

	public HashMap<String, Double> getCurrencyCharts() {
		return currencyCharts;
	}

	public void setCurrencyCharts(HashMap<String, Double> currencyCharts) {
		this.currencyCharts = currencyCharts;
	}

}