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
		logger.trace("constructing chart object");
		try {

			currencyCharts.put("USD/GBP",
					getParity(getDocument("USDJPY"), findParticularCssPath(1)));

			currencyCharts.put("EUR/USD",
					getParity(getDocument("EURJPY"), findParticularCssPath(1)));

			currencyCharts.put("EUR/GBP",
					getParity(getDocument("EURJPY"), findParticularCssPath(2)));

			currencyCharts.put("TL/GBP",
					getParity(getDocument("TRYJPY"), findParticularCssPath(2)));

			currencyCharts.put("TL/USD",
					getParity(getDocument("TRYJPY"), findParticularCssPath(1)));

			currencyCharts.put("TL/EUR",
					getParity(getDocument("TRYJPY"), findParticularCssPath(3)));

		} catch (Exception e) {
			logger.error("error occured while constructing chart object", e);
		}

	}

	public HashMap<String, Double> getCurrencyCharts() {
		return currencyCharts;
	}

	public double getParity(Document doc, String cssPath) {
		/*
		 * Connects document to find related parity. Returns the parity that we
		 * search as double.
		 */
		return convertCurrencyDataToDouble(doc.select(cssPath).text());

	}

	/**
	 * At google finance parities use this kind of css path.This methos is
	 * required for avoiding repetition.
	 * 
	 * @param index
	 *            the only volatile in css paths
	 * @return the complete path to data
	 */
	public String findParticularCssPath(int index) {
		String cssPath = "#gf-viewc > div > div > div.g-section.g-tpl-right-1 > div:nth-child(2) > div:nth-child(2) > div.sfe-section > table > tbody > tr:nth-child("
				+ index + ") > td:nth-child(2)";
		return cssPath;
	}

	/**
	 * @param q
	 *            It provides related section of <a
	 *            href='https://www.google.com/finance?q='>google finance</a>
	 * @return the document that contains parities
	 */
	public Document getDocument(String q) {

		String site = "https://www.google.com/finance?q=" + q;
		logger.debug("Getting document from site: " + site);
		Document document = null;
		try {
			document = Jsoup.connect(site).get();
		} catch (IOException e) {

			logger.error(
					"Error occured while getting document from this site: "
							+ site, e);
		}
		logger.trace("Got document from site: " + site);
		return document;
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

	private boolean hasCurrencyPair(String currency1, String currency2) {

		/* Checks if given currency parity exist in charts */

		if (currencyCharts.containsKey(concatParity(currency1, currency2))) {
			return true;
		} else {
			return false;
		}

	}

	public double searchCurrencyCharts(String currency1, String currency2)
			throws CurrencyPairDoesntFoundException {

		logger.info("Searching parity from charts. Currency1: " + currency1
				+ "Currency2: " + currency2);
		/*
		 * This method looks for concatenated symbols of two currencies at hash
		 * map.
		 */

		double parity;
		if (currency1.equals(currency2)) {
			parity = 1.0;
		}

		if (hasCurrencyPair(currency1, currency2)) {
			parity = currencyCharts.get(concatParity(currency1, currency2));
		} else if (hasCurrencyPair(currency2, currency1)) {
			parity = (1 / currencyCharts
					.get(concatParity(currency2, currency1)));
		} else {
			throw new CurrencyPairDoesntFoundException();
		}
		logger.debug("Found parity for curencies. Parity: " + parity
				+ " Currency1: " + currency1 + " Currency2: " + currency2);
		return parity;
	}

	public String concatParity(String currency1, String currency2) {

		/* Concatenates two different currencies' string symbol. */
		String pair = currency1;
		pair = pair.concat("/").concat(currency2);
		return pair;
	}
}
