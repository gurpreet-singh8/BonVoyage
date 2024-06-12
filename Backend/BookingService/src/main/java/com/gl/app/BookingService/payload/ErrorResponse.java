package com.gl.app.BookingService.payload;



import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ErrorResponse {
    private LocalDate timestamp;
    private String message;
    private String description;

    public ErrorResponse(LocalDate timestamp, String message, String description) {
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }
}
