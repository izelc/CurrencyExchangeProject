package com.cavusoglu.exchange;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cavusoglu.exchange.MoneyExchange;
import com.cavusoglu.exchange.NegativeAmountException;

public class MoneyExchangeExceptionsTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	// @Test
	// public void
	// throwsExceptionWhenParametersAreNullAtSearchCoefficentMethod() {
	// thrown.expect(NullPointerException.class);
	// new MoneyExchange().searchCurrencyCharts(null, null);
	//
	// }

	// @Test(expected = NullPointerException.class)
	// // other way to test exceptions
	// public void throwsExceptionWhenParametersAreNullAtConcatParityMethod() {
	// new MoneyExchange().concatParity(null, null);
	//
	// }

	// @Test(expected = CurrencyPairDoesntFoundException.class)
	// // other way to test exceptions
	// public void throwsExceptionWhenCoefficentDoesntFound() {
	// new MoneyExchange().searchCurrencyCharts("dcsdsd", "SDFSDF");
	//
	// }

	public void throwsExceptionWhenParametersAreNullAtCalculateMethod()
			throws Exception {
		thrown.expect(NullPointerException.class);

		new MoneyExchange().convert(null, null, 10);

	}

	@Test
	public void testCalculate() { // another and old way to test exceptions

		Exception nullPointerException = null;
		try {
			new MoneyExchange().convert("USD", "EUR", (Double) null);
		} catch (Exception e) {
			nullPointerException = e;
		}

		assertTrue(nullPointerException instanceof NullPointerException);

		Exception a = null;

		try {
			new MoneyExchange().convert("dasdhk", "dasd", 15);

		} catch (Exception e) {
			a = e;
		}

		assertTrue(a instanceof CurrencyPairDoesntFoundException);

	}

	@Test
	public void throwsExceptionWhenAmountIsNegative() throws Exception {
		thrown.expect(NegativeAmountException.class);
		new MoneyExchange().convert("USD", "EUR", -2);

	}

}
