package com.cavusoglu.exchange.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cavusoglu.exchange.SumOfCurrencies;

/**
 * This Servlet is designed
 * for convert-and-sum.html
 */
@WebServlet("/SumCurrenciesServlet")
public class SumCurrenciesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SumOfCurrencies sumOfCurrencies = new SumOfCurrencies();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response) 
	 *      When submit button clicked, this doGet method calculates
	 *      sum with inputs that user has given.
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String addentAmount1 = request.getParameter("addentAmountTextBox1");
		String addentCurrency1 = request
				.getParameter("addentCurrencyComboBox1");
		String addentCurrency2 = request
				.getParameter("addentCurrencyComboBox2");
		String addentAmount2 = request.getParameter("addentAmountTextBox2");
		String resultCurrency = request.getParameter("resultCurrencyComboBox");
		String sum = sumOfCurrencies.addCurrencies(addentCurrency1,
				addentCurrency2, Double.parseDouble(addentAmount1),
				Double.parseDouble(addentAmount2), resultCurrency);
		response.getWriter().print(sum);
	}

}
