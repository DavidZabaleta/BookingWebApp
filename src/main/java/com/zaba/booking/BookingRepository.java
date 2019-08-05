package com.zaba.booking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<HotelBooking, Long> {
    /**The interface is use to filter the hotel prices per night using a JpaRepository,
     * applying the method findBy<atributeName>LessThan. The method it's called on the
     * BookingController.
     **/
    List<HotelBooking> findByPricePerNightLessThan(double price);
}
