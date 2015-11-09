package com.jpmorgan.interview.utils;

/**
 * This is the Invalid Stock Exception message.
 * 
 * @author Balan
 *
 */
public class InvalidStockEception  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidStockEception(String errorMessage){
	      super(errorMessage);
	   }
}
