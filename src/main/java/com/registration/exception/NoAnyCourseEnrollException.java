package com.registration.exception;
/**
 * 
 * @author Sushil
 *
 */
public class NoAnyCourseEnrollException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoAnyCourseEnrollException(String message)
	{
		super(message);
	}

}
