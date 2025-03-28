package org.bezy.service.auth;

import org.bezy.model.auth.Consumer;

import java.util.List;
import java.util.Optional;

public interface ConsumerService {
    Consumer registerConsumer(Consumer consumer);
    Optional<Consumer> getConsumerByEmail(String email);
    Optional<Consumer> getConsumerByUsername(String username);
    List<Consumer> searchConsumersByUsername(String usernamePart);
}
