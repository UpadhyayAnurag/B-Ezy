package org.bezy.service;

import org.bezy.model.services_model.Taxi;
import org.bezy.repository.services_repo.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaxiServiceImpl implements TaxiService{

    @Autowired
    private TaxiRepository taxiRepository;

    @Override
    public List<Taxi> getAvailableTaxis() {
        return taxiRepository.findByAvailabilityTrue();
    }

    @Override
    public List<Taxi> findTaxisNearLocation(double latitude, double longitude, double radius) {
        return taxiRepository.findTaxisNearLocation(latitude, longitude, radius);
    }

    @Override
    public List<Taxi> filterTaxisByMaxPrice(double maxPrice) {
        return taxiRepository.findTaxisByMaxPrice(maxPrice);
    }

    // Provider functionality: add a new taxi listing
    @Override
    public Taxi addTaxi(Taxi taxi) {
        return taxiRepository.save(taxi);
    }

    // Update taxi details
    @Override
    public Taxi updateTaxi(Taxi taxi) {
        return taxiRepository.save(taxi);
    }

    // Delete taxi listing
    @Override
    public void deleteTaxi(Long taxiId) {
        taxiRepository.deleteById(taxiId);
    }
}
