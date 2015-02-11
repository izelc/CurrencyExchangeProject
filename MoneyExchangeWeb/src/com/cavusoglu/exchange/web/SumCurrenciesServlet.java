package com.cavusoglu.exchange.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cavusoglu.exchange.SumOfCurrencies;

/**
 * Servlet implementation class SumCurrenciesServlet
 */
@WebServlet("/SumCurrenciesServlet")
public class SumCurrenciesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SumOfCurrencies sumOfCurrencies=new SumOfCurrencies();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SumCurrenciesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String addentAmount = request.getParameter("addentAmountTextBox");
		String addentCurrency=request.getParameter("addentCurrencyComboBox");
		String resultCurrency=request.getParameter("resultCurrencyComboBox");
		String resultAmount=request.getParameter("resultAmountTextBox");
		String sum = sumOfCurrencies.addCurrencies(addentCurrency, resultCurrency,Double.parseDouble(addentAmount),Double.parseDouble(resultAmount));
		response.getWriter().print(sum);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
