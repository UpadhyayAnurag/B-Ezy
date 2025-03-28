package org.bezy.repository.auth;


import org.bezy.model.auth.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

    // Add custom queries as needed, e.g. find by companyName or serviceType
    Optional<ServiceProvider> findByCompanyName(String companyName);

    // Find service providers by serviceType
    Optional<ServiceProvider> findByServiceType(String serviceType);

    // Retrieve all providers of a given service type ordered by company name
    List<ServiceProvider> findByServiceTypeOrderByCompanyNameAsc(String serviceType);
}
