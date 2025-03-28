package org.bezy.service;

import org.bezy.model.services_model.CarRental;

import java.util.List;

public interface CarRentalService {
    List<CarRental> getAvailableCarRentals();
    List<CarRental> filterCarRentalsByRentRange(Double minRent, Double maxRent);


    // Provider listing functionality
    CarRental addCarRental(CarRental carRental);
    CarRental updateCarRental(CarRental carRental);
    void deleteCarRental(Long carRentalId);
}
