package com.zaba.booking;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    //A 'bookings' variable is created to save in a list every instance of the class 'HotelBooking'.
    private List<HotelBooking> bookings;


    //BookingController list Constructor using the 'bookings' variable and adding to a ArrayList.
    public BookingController(){
        bookings = new ArrayList<>();

        bookings.add(new HotelBooking("Marriot", 210.5,4));
        bookings.add(new HotelBooking("Estelar", 120.4,3));
    }

    //Method that returns in JSON all the bookings created.
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> getAll() {
        return bookings;
    }

    //Method that filter the hotels with an affordable price given by the user in the variable {price}.
    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price){
        return bookings.stream().filter(x -> x.getPricePerNight() <= price)
                .collect(Collectors.toList());
    }

    //Create a new hotel via POST request in a JSON, the hotel is added to the 'bookings' list.
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
        bookings.add(hotelBooking);
        return bookings;
    }
}
