package org.bezy.repository.services_repo;

import org.bezy.model.services_model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    // Fetch hotels by location
    List<Hotel> findByLocation(String location);

    // Fetch hotels that have at least one available room
    @Query("SELECT h FROM Hotel h JOIN h.rooms r WHERE r.availability = true GROUP BY h")
    List<Hotel> findHotelsWithAvailableRooms();

    // Count available rooms for a specific hotel
    @Query("SELECT COUNT(r) FROM Room r WHERE r.hotel.id = :hotelId AND r.availability = true")
    Long countAvailableRooms(@Param("hotelId") Long hotelId);

    // Fetch rooms by price range
    @Query("SELECT DISTINCT h FROM Hotel h JOIN h.rooms r WHERE r.pricePerNight BETWEEN :minPrice AND :maxPrice AND r.availability = true")
    List<Hotel> findHotelsByRoomPriceRange(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);

    // Fetch Hotels with rooms to accommodate desired number of people
    @Query("SELECT DISTINCT h FROM Hotel h JOIN h.rooms r WHERE r.maxOccupancy >= :requiredPeople AND r.availability = true")
    List<Hotel> findHotelsByRequiredOccupancy(@Param("requiredPeople") Integer requiredPeople);

}
