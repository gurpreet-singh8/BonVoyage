package com.gl.app.PackageService.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ErrorResponse {
    private Date timestamp;
    private String message;
    private String description;

}
