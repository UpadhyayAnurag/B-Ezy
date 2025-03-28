package org.bezy.service.auth;

import org.bezy.model.auth.ServiceProvider;

import java.util.List;
import java.util.Optional;

public interface ServiceProviderService {
    ServiceProvider registerProvider(ServiceProvider provider);
    Optional<ServiceProvider> getProviderByCompanyName(String companyName);
    Optional<ServiceProvider> getProviderByServiceType(String serviceType);
    List<ServiceProvider> getProvidersByServiceType(String serviceType);
}
