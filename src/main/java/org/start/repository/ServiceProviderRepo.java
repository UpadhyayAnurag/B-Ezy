package org.start.repository;

import org.start.entity.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface ServiceProviderRepo extends JpaRepository<ServiceProvider, Long> {
    Optional<ServiceProvider> findByUserName(String userName);
    boolean existsByUserName(String userName);
    List<ServiceProvider> findByService(String service);
}







