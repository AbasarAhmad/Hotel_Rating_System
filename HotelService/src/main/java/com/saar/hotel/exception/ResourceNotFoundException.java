package com.saar.hotel.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException()
	{
		super("Hotel is not Found with id");
	}
	public ResourceNotFoundException(String msg)
	{
		super(msg);
	}

}
