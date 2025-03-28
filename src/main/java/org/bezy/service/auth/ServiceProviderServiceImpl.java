package org.bezy.service.auth;

import org.bezy.model.auth.ServiceProvider;
import org.bezy.repository.auth.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService{

    @Autowired
    private ServiceProviderRepository providerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ServiceProvider registerProvider(ServiceProvider provider) {
        // validations, password encryption etc. to be added
        provider.setPassword(passwordEncoder.encode(provider.getPassword()));
        return providerRepository.save(provider);
    }

    @Override
    public Optional<ServiceProvider> getProviderByCompanyName(String companyName) {
        return providerRepository.findByCompanyName(companyName);
    }

    @Override
    public Optional<ServiceProvider> getProviderByServiceType(String serviceType) {
        return providerRepository.findByServiceType(serviceType);
    }

    @Override
    public List<ServiceProvider> getProvidersByServiceType(String serviceType) {
        return providerRepository.findByServiceTypeOrderByCompanyNameAsc(serviceType);
    }
}
