package org.start.repository;

import org.start.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ConsumerRepo extends JpaRepository<Consumer, Long> {
    Optional<Consumer> findByUsername(String username);
    boolean existsByUsername(String username);
}

