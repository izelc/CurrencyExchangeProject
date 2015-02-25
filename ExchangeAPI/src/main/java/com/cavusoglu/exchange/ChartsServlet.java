package com.cavusoglu.exchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;





import javax.ejb.Startup;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class ChartsServlet
 */
@WebServlet(value="/ChartsServlet", urlPatterns="/ChartsServlet",loadOnStartup=1)
public class ChartsServlet extends HttpServlet implements ServletContextListener {
	private static final long serialVersionUID = 1L;

    private ChartsSearcher chartsSearcher;
    private static final Logger logger = Logger.getLogger(Charts.class);
    
    
    @Override
    public void init() throws ServletException {
    	logger.trace("---------------------------------------------------------------------------");
    	System.err.println("---------------------------------------------------------------------");
       	chartsSearcher= new ChartsSearcher(Charts.getInstance());
    	}
    
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String line = readDataFromRequest(req);
		System.err.println(line);
		JsonObject jsonObject = new Gson().fromJson(line, JsonObject.class);
		String fromCurrency = jsonObject.get("fromCurrency").getAsString();
		String toCurrency = jsonObject.get("toCurrency").getAsString();

		
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



	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.err.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		logger.trace("---------------------------------------------------------------------------");
	}



	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.err.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		logger.trace("---------------------------------------------------------------------------");
	}


	
}
