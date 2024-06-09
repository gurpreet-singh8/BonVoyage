package com.gl.app.BookingService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import com.gl.app.BookingService.BookingServiceApplication;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Bookings {

    String userId;
    @Id
    String bookingId;
    String packageId;
    String packageName;
    String bookingDate;
    String packageImage;
    int bookingPerson;
    int bookingRooms;

    @PrePersist
    private void generateId() {
        if (this.bookingId == null) {
            this.bookingId = BookingServiceApplication.generateId("B");
        }
    }
}
