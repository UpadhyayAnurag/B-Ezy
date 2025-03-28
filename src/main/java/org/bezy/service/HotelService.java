package org.bezy.service;

import org.bezy.model.services_model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();
    List<Hotel> searchHotelsByLocation(String location);
    List<Hotel> getHotelsWithAvailableRooms();
    List<Hotel> filterHotelsByPriceRange(Double minPrice, Double maxPrice);
    List<Hotel> filterHotelsByOccupancy(Integer requiredPeople);
    Long countAvailableRooms(Long hotelId);

    // Provider listing functionality
    Hotel addHotel(Hotel hotel);
    Hotel updateHotel(Hotel hotel);
    void deleteHotel(Long hotelId);
}
