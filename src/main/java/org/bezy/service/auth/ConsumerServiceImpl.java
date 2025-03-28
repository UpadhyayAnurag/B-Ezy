package org.bezy.service.auth;

import org.bezy.model.auth.Consumer;
import org.bezy.repository.auth.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumerServiceImpl implements ConsumerService{

    @Autowired
    private ConsumerRepository consumerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Consumer registerConsumer(Consumer consumer) {
        // Validation for password encryption etc.
        consumer.setPassword(passwordEncoder.encode(consumer.getPassword()));
        return consumerRepository.save(consumer);
    }

    @Override
    public Optional<Consumer> getConsumerByEmail(String email) {
        return consumerRepository.findByEmail(email);
    }

    @Override
    public Optional<Consumer> getConsumerByUsername(String username) {
        return consumerRepository.findByUsername(username);
    }

    @Override
    public List<Consumer> searchConsumersByUsername(String usernamePart) {
        return consumerRepository.findByUsernameContaining(usernamePart);
    }
}
