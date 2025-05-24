package com.saar.rating.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException()
	{
		super("Resource is not found !!!");
	}
	public ResourceNotFoundException(String msg)
	{
		super(msg);
	}
}
