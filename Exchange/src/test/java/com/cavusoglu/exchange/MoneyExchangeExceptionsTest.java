package com.cavusoglu.exchange;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cavusoglu.exchange.MoneyExchange;
import com.cavusoglu.exchange.NegativeAmountException;


public class MoneyExchangeExceptionsTest {

	
	@Rule 
	public ExpectedException thrown= ExpectedException.none();
	
	

	
	@Test
	public void throwsExceptionWhenParametersAreNullAtSearchCoefficentMethod() {
		thrown.expect(NullPointerException.class);
		new MoneyExchange().searchCoefficentMap(null,null); 

	  
	}
	
	
	@Test(expected = NullPointerException.class)      // other way to test exceptions
	public void throwsExceptionWhenParametersAreNullAtConcatParityMethod() {
		new MoneyExchange().concatParity(null,null);
		
		
		
	}
	
	
	
	public void throwsExceptionWhenParametersAreNullAtCalculateMethod() {
		thrown.expect(NullPointerException.class);
		
		new MoneyExchange().calculate(null, null, 10);
	
	}
	
	@Test
	
	public void testCalculate(){     //another and old  way to test exceptions 
		
		Exception ex = null;
		try {
			new MoneyExchange().calculate("USD","EUR",(Double)null);
		} catch (Exception e) {
			ex=e;
		}	
		
		assertTrue(ex instanceof NullPointerException);
		
	   
		
	}
	
	
	@Test
	public void throwsExceptionWhenAmountIsNegative() throws NegativeAmountException{
		thrown.expect(NegativeAmountException.class);
		new MoneyExchange().calculate("USD", "EUR", -2);
		
		
	}
	

}
