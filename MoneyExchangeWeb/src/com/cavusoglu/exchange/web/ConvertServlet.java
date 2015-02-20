package com.cavusoglu.exchange.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cavusoglu.exchange.MoneyExchange;

/**
 * This Servlet is designed for index.html
 */
@WebServlet("/ConvertServlet")
public class ConvertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 *      When submit button clicked this doGet() method prints the result of
	 *      convert operation in resutTextBox(the html element). Also other info
	 *      that user has given to html elements wont fades away after submit
	 *      button clicked.
	 * 
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String amount = request.getParameter("amount");
		String fromCurrency = request.getParameter("fromCurrency");
		String toCurrency = request.getParameter("toCurrency");
		MoneyExchange exchange = new MoneyExchange();
		double result = 0;
		try {
			result = exchange.calculate(fromCurrency, toCurrency,
					Double.parseDouble(amount));
		} catch (NumberFormatException e) {
		} catch (Exception e) {
		}
		response.getWriter().print(result);
		response.getWriter().flush();
	}

}
