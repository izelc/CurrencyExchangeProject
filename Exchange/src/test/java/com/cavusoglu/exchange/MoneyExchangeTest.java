package com.cavusoglu.exchange;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import com.cavusoglu.exchange.MoneyExchange;
import com.cavusoglu.exchange.NegativeAmountException;

public class MoneyExchangeTest {

	@Test
	public void testCalculate() throws Exception {
		MoneyExchange m = Mockito.spy(new MoneyExchange());
		Mockito.doReturn("1.20").when(m)
				.getParity(Mockito.anyString(), Mockito.anyString());
		assertEquals(2.4, m.convert("EUR", "USD", 2), 0.01);
	}

	
	@Test
	public void testGetParityFromApi() throws Exception {
		MoneyExchange exchange = new MoneyExchange();
	exchange.getParity("USD", "EUR");
		

	}
}
