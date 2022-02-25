package com.mvc.exception;

public class MailServiceException extends Exception
{
	public MailServiceException(String message)
	{
		super(message);
	}

	public MailServiceException(String message, Throwable cause)
	{
		super(message,cause);
	}
}