package org.bezy.service;

import org.bezy.model.services_model.CarRental;
import org.bezy.repository.services_repo.CarRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarRentalServieImpl implements CarRentalService{

    @Autowired
    private CarRentalRepository carRentalRepository;

    @Override
    public List<CarRental> getAvailableCarRentals() {
        return carRentalRepository.findByAvailabilityTrue();
    }

    @Override
    public List<CarRental> filterCarRentalsByRentRange(Double minRent, Double maxRent) {
        return carRentalRepository.findCarRentalsByRentRange(minRent, maxRent);
    }

    // Provider functionality: add a new car rental listing
    @Override
    public CarRental addCarRental(CarRental carRental) {
        return carRentalRepository.save(carRental);
    }

    // Update car rental details
    @Override
    public CarRental updateCarRental(CarRental carRental) {
        return carRentalRepository.save(carRental);
    }

    // Delete car rental listing
    @Override
    public void deleteCarRental(Long carRentalId) {
        carRentalRepository.deleteById(carRentalId);
    }
}
