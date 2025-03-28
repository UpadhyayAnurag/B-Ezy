package org.bezy.service;

import org.bezy.model.services_model.Hotel;
import org.bezy.repository.services_repo.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> searchHotelsByLocation(String location) {
        return hotelRepository.findByLocation(location);
    }

    @Override
    public List<Hotel> getHotelsWithAvailableRooms() {
        return hotelRepository.findHotelsWithAvailableRooms();
    }

    @Override
    public List<Hotel> filterHotelsByPriceRange(Double minPrice, Double maxPrice) {
        return hotelRepository.findHotelsByRoomPriceRange(minPrice, maxPrice);
    }

    @Override
    public List<Hotel> filterHotelsByOccupancy(Integer requiredPeople) {
        return hotelRepository.findHotelsByRequiredOccupancy(requiredPeople);
    }

    @Override
    public Long countAvailableRooms(Long hotelId) {
        return hotelRepository.countAvailableRooms(hotelId);
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    // Provider functionality: update existing hotel listing details
    @Override
    public Hotel updateHotel(Hotel hotel) {
        // Typically you would first check if the hotel exists and if the provider is authorized to update it.
        return hotelRepository.save(hotel);
    }

    // Provider functionality: delete a hotel listing
    @Override
    public void deleteHotel(Long hotelId) {
        hotelRepository.deleteById(hotelId);
    }
}
