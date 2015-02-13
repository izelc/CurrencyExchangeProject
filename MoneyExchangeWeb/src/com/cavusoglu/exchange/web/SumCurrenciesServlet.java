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
		String addentAmount1 = request.getParameter("addentAmountTextBox1");
		String addentCurrency1=request.getParameter("addentCurrencyComboBox1");
		String addentCurrency2=request.getParameter("addentCurrencyComboBox2");
		String addentAmount2=request.getParameter("addentAmountTextBox2");
		String resultCurrency= request.getParameter("resultCurrencyComboBox");
		String sum = sumOfCurrencies.addCurrencies(addentCurrency1, addentCurrency2,Double.parseDouble(addentAmount1),Double.parseDouble(addentAmount2),resultCurrency);
		response.getWriter().print(sum);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
