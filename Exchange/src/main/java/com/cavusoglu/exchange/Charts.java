package com.cavusoglu.exchange;

import java.io.IOException;
import java.util.HashMap;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;

/**
 * @author Izel Cavusoglu This class defines parities and values of parities are
 *         taken from web dynamically.
 *
 */
public class Charts {

	private HashMap<String, Double> currencyCharts = new HashMap<String, Double>();

	public Charts() {

		try {

			currencyCharts.put(
					"USD/GBP",
					connectToData(connectToSite("USDJPY"),
							findParticularCssPath(1)));

			currencyCharts.put(
					"EUR/USD",
					connectToData(connectToSite("EURJPY"),
							findParticularCssPath(1)));

			currencyCharts.put(
					"EUR/GBP",
					connectToData(connectToSite("EURJPY"),
							findParticularCssPath(2)));

			currencyCharts.put(
					"TL/GBP",
					connectToData(connectToSite("TRYJPY"),
							findParticularCssPath(2)));

			currencyCharts.put(
					"TL/USD",
					connectToData(connectToSite("TRYJPY"),
							findParticularCssPath(1)));

			currencyCharts.put(
					"TL/EUR",
					connectToData(connectToSite("TRYJPY"),
							findParticularCssPath(3)));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public HashMap<String, Double> getCurrencyCharts() {
		return currencyCharts;
	}

	public double connectToData(Document doc, String cssPath) {
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
	public Document connectToSite(String q) {
		String site = "https://www.google.com/finance?q=" + q;
		Document document = null;
		try {
			document = Jsoup.connect(site).get();
		} catch (IOException e) {

			e.printStackTrace();
		}
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
