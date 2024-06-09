package com.gl.app.BookingService.payload;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookingsDto {
    String userId;
    String bookingId;
    String packageId;
    String packageName;
    Date bookingDate;
    String packageImage;
    int bookingPerson;
    int bookingRooms;
}
