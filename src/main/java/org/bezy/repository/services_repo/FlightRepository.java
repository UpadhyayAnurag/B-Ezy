package org.bezy.repository.services_repo;

import org.bezy.model.services_model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    // Find flights matching specific departure and destination cities
    List<Flight> findByDepartureAndDestination(String departure, String destination);

    // Find flights that depart within a given time range
    @Query("SELECT f FROM Flight f WHERE f.departureTime BETWEEN :start AND :end")
    List<Flight> findFlightsWithinPeriod(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    // Retrieve flights based on custom price range
    @Query("SELECT f FROM Flight f WHERE f.price BETWEEN :minPrice AND :maxPrice")
    List<Flight> findFlightsByPriceRange(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);

}
