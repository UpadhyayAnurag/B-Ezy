package org.bezy.repository.services_repo;

import org.bezy.model.services_model.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxiRepository extends JpaRepository<Taxi, Long> {

    // Retrieve taxis that are currently available
    List<Taxi> findByAvailabilityTrue();

    // Custom query: Find taxis with price per km less than or equal to the specified maximum price
    @Query("SELECT t FROM Taxi t WHERE t.pricePerKm <= :maxPrice")
    List<Taxi> findTaxisByMaxPrice(@Param("maxPrice") Double maxPrice);

    // Find taxis within a given radius (in km) from the specified latitude and longitude
    @Query(value = "SELECT *, " +
            "       (6371 * acos( cos( radians(:lat) ) * cos( radians(latitude) ) * " +
            "       cos( radians(longitude) - radians(:lng) ) + sin( radians(:lat) ) * sin( radians(latitude) ) )) AS distance " +
            "FROM taxis " + "WHERE availability = true " + "HAVING distance <= :radius " + "ORDER BY distance", nativeQuery = true)
    List<Taxi> findTaxisNearLocation(@Param("lat") double latitude, @Param("lng") double longitude, @Param("radius") double radius);
}
