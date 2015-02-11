package com.cavusoglu.exchange.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cavusoglu.exchange.MoneyExchange;

/**
 * Servlet implementation class ConvertServlet
 */
@WebServlet("/ConvertServlet")
public class ConvertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConvertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String amount = request.getParameter("amount");
		String fromCurrency = request.getParameter("fromCurrency");
		String toCurrency = request.getParameter("toCurrency");
		MoneyExchange exchange = new MoneyExchange();
		double result = exchange.calculate(fromCurrency, toCurrency,
				Double.parseDouble(amount));
		String html = "<html>\r\n<head>\r\n<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\r\n<script src=\"js/jquery-1.11.2.min.js\"></script>\r\n<script src=\"js/bootstrap.js\"></script>\r\n<script src=\"js/bootstrap.min.js\"></script>\r\n<script src=\"js/ajax.js\"></script>\r\n<script src=\"js/wow.js\"></script>\r\n<style>\r\nh3 {\r\n\tcolor: blue;\r\n}\r\n</style>\r\n</head>\r\n<body>\r\n\t<nav class=\"navbar navbar-default\">\r\n\t\t<div class=\"container-fluid\">\r\n\t\t\t<!-- Brand and toggle get grouped for better mobile display -->\r\n\t\t\t<div class=\"navbar-header\">\r\n\t\t\t\t<ul class=\"nav nav-tabs\" style=\"border-bottom: none;\">\r\n\t\t\t\t\t<li role=\"presentation\" class=\"active\"><a href=\"index.html\">Only\r\n\t\t\t\t\t\t\tConvert</a></li>\r\n\t\t\t\t\t<li role=\"presentation\"><a href=\"convert-and-sum.html\">Convert&Sum</a></li>\r\n\t\t\t\t</ul>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</nav>\r\n\r\n\t<form action=\"ConvertServlet\" method=\"get\">\r\n\t\t<div class=\"container\">\r\n\t\t\t<div class=\"row\">\r\n\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t<h3>Amount:</h3>\r\n\t\t\t\t\t"
				+ "<input type=\"text\" id=\"amountTextBox\" "
				+ "value=\""
				+ amount
				+ "\""
				+ "name=\"amount\"\r\n\t\t\t\t\t\tclass=\"form-control\" aria-label=\"Amount (to the nearest dollar)\">\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t<h3>Currency:</h3>\r\n\t\t\t\t\t<select class=\"form-control\" "
				+ "name=\"fromCurrency\"\r\n\t\t\t\t\t\tid=\"fromCurrencyComboBox\" \r\n\t\t\t\t\t\t"
				+ "value=\""
				+ fromCurrency
				+ "\">"
				+ "<option  value=\"EUR\">EUR</option>"
				+ "<option value=\"USD\">USD</option>"
				+ "<option value=\"GBP\">GBP</option>"
				+ "<option value=\"TL\">TL</option>\r\n\t\t\t\t\t</select>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t<button\r\n\t\t\t\t\t\tstyle=\"margin-top: 53px; background-color: pink; padding: 6px 33px;\"\r\n\t\t\t\t\t\ttype=\"submit\" class=\"btn btn-default\" id=\"calculateButton\">=</button>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t<h3>Result:</h3>\r\n\r\n\t\t\t\t\t"
				+ "<input type=\"text\" "
				+ "value=\""
				+ result
				+ "\""
				+ " class=\"form-control\" id=\"resultTextBox\">"
				+ "\r\n\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t<h3>Currency:</h3>\r\n\r\n\t\t\t\t\t<select class=\"form-control\" "
				+ "value=\""
				+ toCurrency
				+ "\""
				+ "name=\"toCurrency\"\r\n\t\t\t\t\t\tid=\"toCurrencyComboBox\">\r\n\t\t\t\t\t\t<option value=\"EUR\">EUR</option>\r\n\t\t\t\t\t\t<option value=\"USD\">USD</option>\r\n\t\t\t\t\t\t<option value=\"GBP\">GBP</option>\r\n\t\t\t\t\t\t<option value=\"TL\">TL</option>\r\n\t\t\t\t\t</select>\r\n\r\n\t\t\t\t</div>\r\n\r\n\r\n\t\t\t</div>\r\n\r\n\r\n\t\t</div>\r\n\t</form>\r\n</body>\r\n</html>";
		response.getWriter().print(html);
		response.getWriter().flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
