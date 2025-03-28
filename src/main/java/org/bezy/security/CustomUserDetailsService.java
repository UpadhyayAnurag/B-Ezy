package org.bezy.security;

import org.bezy.model.auth.Consumer;
import org.bezy.model.auth.ServiceProvider;
import org.bezy.repository.auth.ConsumerRepository;
import org.bezy.repository.auth.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ConsumerRepository consumerRepository;

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // First try to load as Consumer
        Optional<Consumer> consumerOpt = consumerRepository.findByUsername(username);
        if (consumerOpt.isPresent()) {
            Consumer consumer = consumerOpt.get();
            return new User(consumer.getUsername(), consumer.getPassword(), new ArrayList<>());
        }
        // If not found, try as ServiceProvider (assuming companyName is used as username)
        Optional<ServiceProvider> providerOpt = serviceProviderRepository.findByCompanyName(username);
        if (providerOpt.isPresent()) {
            ServiceProvider provider = providerOpt.get();
            return new User(provider.getCompanyName(), provider.getPassword(), new ArrayList<>());
        }
        throw new UsernameNotFoundException("User not found: " + username);
    }
}

