package com.registration.exception;
/**
 * 
 * @author Sushil
 *
 */
public class CourseAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CourseAlreadyExistException(String message)
	{
		super(message);
	}

}
