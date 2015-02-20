package com.cavusoglu.exchange;

@SuppressWarnings("serial")
public class CurrencyPairDoesntFoundException extends RuntimeException {

	public CurrencyPairDoesntFoundException() {
		super();
	}

	public CurrencyPairDoesntFoundException(String message) {
		super(message);
	}

}
