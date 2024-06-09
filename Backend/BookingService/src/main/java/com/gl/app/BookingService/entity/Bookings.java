package com.gl.app.BookingService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Bookings {

    String userId;
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String bookingId;
    String packageId;
    String packageName;
    Date bookingDate;
    String packageImage;
    int bookingPerson;
    int bookingRooms;




}
