package com.cavusoglu.exchange;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.util.ssl.SslContextFactory;

import com.google.gson.JsonObject;

/**
 * This class is used for holding all the functionality of the money exchanging
 * transaction
 * 
 * @version 2015
 * @author Izel Cavusoglu
 */

public class MoneyExchange {

	private static final String RESTFUL_API_URL = "http://localhost:8080/ExchangeAPI/ChartsServlet";

	// private Charts currencyCharts;

	public MoneyExchange() { /* Creator pattern is used. */
		// currencyCharts = new Charts();
	}

	public double convert(String currency1, String currency2, double amount)
			throws Exception {

		/*
		 * Calculates equivalent given amount of currency1 with respect to
		 * currency2
		 */

		if (amount < 0) {
			throw new NegativeAmountException();
		}
		if (currency1.equals(currency2)) {
			return amount;
		}

		return amount * Double.parseDouble(getParity(currency1, currency2));
	}

	/**
	 * Gets parity for given currencies from API.
	 * 
	 * @param currency1
	 *            from Currency.
	 * @param currency2
	 *            to Currency.
	 * @return parity as {@link String}
	 * @throws Exception
	 */
	String getParity(String currency1, String currency2) throws Exception {
		HttpClient client = new HttpClient(new SslContextFactory(true));
		client.start();
		String apiResult = client
				.POST(RESTFUL_API_URL)
				.content(
						new StringContentProvider(createJsonObjectForAPI(
								currency1, currency2))).send()
				.getContentAsString();
		client.stop();
		return apiResult;

	}

	/**
	 * Creates {@link JsonObject} for API.
	 * 
	 * @param currency1
	 *            Currency which will be converted from.
	 * @param currency2
	 *            Currency which will be converted to.
	 * @return json object as string
	 */
	private String createJsonObjectForAPI(String currency1, String currency2) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("fromCurrency", currency1);
		jsonObject.addProperty("toCurrency", currency2);
		return jsonObject.toString();
	}

}
