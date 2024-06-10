package com.gl.app.BookingService.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private long fieldValue;
    private String Value;

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue){
        super(String.format("%s not found with %s:'%s'",resourceName,fieldName,fieldValue));
        this.fieldName=fieldName;
        this.resourceName=resourceName;
        this.fieldValue=fieldValue;
    }
    public ResourceNotFoundException(String resourceName, String fieldName, String Value){
        super(String.format("%s not found with %s:'%s'",resourceName,fieldName,Value));
        this.fieldName=fieldName;
        this.resourceName=resourceName;
        this.Value=Value;
    }

}
