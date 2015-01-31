package com.cavusoglu.exchange;

public class NegativeAmountException extends RuntimeException{
	 public NegativeAmountException(){
	        super();
	    }

	    public NegativeAmountException(String message){
	        super(message);
	    }

}
