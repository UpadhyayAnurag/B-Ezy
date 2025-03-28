package org.bezy.repository.auth;


import org.bezy.model.auth.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
    Optional<Consumer> findByEmail(String email);
    Optional<Consumer> findByUsername(String username);

    // Custom query to search consumers by partial username match
    List<Consumer> findByUsernameContaining(String username);
}
