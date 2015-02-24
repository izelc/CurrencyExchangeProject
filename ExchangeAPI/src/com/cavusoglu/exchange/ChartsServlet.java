package com.cavusoglu.exchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class ChartsServlet
 */
@WebServlet("/ChartsServlet")
public class ChartsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChartsSearcher chartsSearcher;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String line = readDataFromRequest(req);
		System.err.println(line);
		JsonObject jsonObject = new Gson().fromJson(line, JsonObject.class);
		String fromCurrency = jsonObject.get("fromCurrency").getAsString();
		String toCurrency = jsonObject.get("toCurrency").getAsString();

		Charts currencyCharts = Charts.getInstance();
		chartsSearcher=new ChartsSearcher(currencyCharts);
		double searchCurrencyCharts =chartsSearcher
				.searchCurrencyCharts(fromCurrency, toCurrency);
		resp.getWriter().print(searchCurrencyCharts);
		resp.getWriter().flush();
	}

	private String readDataFromRequest(HttpServletRequest req)
			throws IOException {

		String body = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;

		try {
			InputStream inputStream = req.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(
						inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}

		body = stringBuilder.toString();
		return body;
	}
}
