package org.bezy.repository.services_repo;

import org.bezy.model.services_model.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRentalRepository extends JpaRepository<CarRental, Long> {

    // Retrieve car rentals that are currently available
    List<CarRental> findByAvailabilityTrue();

    // Custom query: Find car rentals within a given daily rent range
    @Query("SELECT c FROM CarRental c WHERE c.dailyRent BETWEEN :minRent AND :maxRent")
    List<CarRental> findCarRentalsByRentRange(@Param("minRent") Double minRent, @Param("maxRent") Double maxRent);
}
