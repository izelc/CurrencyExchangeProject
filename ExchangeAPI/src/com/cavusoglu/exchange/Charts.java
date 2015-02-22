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
	 * At google finance parities use this kind of css path.This method is
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

	
	
}
