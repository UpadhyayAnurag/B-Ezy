package org.bezy.service;

import org.bezy.model.services_model.Taxi;

import java.util.List;

public interface TaxiService {
    List<Taxi> getAvailableTaxis();
    List<Taxi> findTaxisNearLocation(double latitude, double longitude, double radius);
    List<Taxi> filterTaxisByMaxPrice(double maxPrice);

    // Provider listing functionality
    Taxi addTaxi(Taxi taxi);
    Taxi updateTaxi(Taxi taxi);
    void deleteTaxi(Long taxiId);
}
