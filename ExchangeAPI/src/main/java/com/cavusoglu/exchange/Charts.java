package com.cavusoglu.exchange;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/**
 * @author Izel Cavusoglu This class defines parities and values of parities are
 *         taken from web dynamically.
 */
public class Charts {
	private static final Logger logger = Logger.getLogger(Charts.class);
	private HashMap<String, Double> currencyCharts = new HashMap<String, Double>();
	private static Charts chart = null;
	private ScheduledExecutorService executor = Executors
			.newScheduledThreadPool(1);

	private Charts() {
		fillHasHmap(new GoogleCurrencyFetcher());
		logger.trace("Charts constructor is working");
		executor.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				fillHasHmap(new GoogleCurrencyFetcher());
			}
		}, 0, 2, TimeUnit.MINUTES);
	}

	/**
	 * @return returns the only object of charts
	 */
	public static Charts getInstance() {
		logger.trace("getInstance is working");
		if (chart == null) {
			chart = new Charts();
		}
		return chart;
	}

	/**
	 * it fills hashmap with datas taken from google finance.
	 */
	public void fillHasHmap(GoogleCurrencyFetcher gf) {
		logger.trace("fillHashMap() is working");
		try {
			getCurrencyCharts().put("USD/GBP",
					gf.getParity("USDGBP"));

			getCurrencyCharts().put("EUR/USD",
					gf.getParity("EURUSD"));

			getCurrencyCharts().put("EUR/GBP",
					gf.getParity("EURGBP"));

			getCurrencyCharts().put("TL/GBP",
					gf.getParity("TRYGBP"));

			getCurrencyCharts().put("TL/USD",
					gf.getParity("TRYUSD"));

			getCurrencyCharts().put("TL/EUR",
					gf.getParity("TRYEUR"));

		} catch (Exception e) {
			logger.error("error occured while constructing hashMap", e);
		}

	}

	public HashMap<String, Double> getCurrencyCharts() {
		return currencyCharts;
	}

	public void setCurrencyCharts(HashMap<String, Double> currencyCharts) {
		this.currencyCharts = currencyCharts;
	}

}