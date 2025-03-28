package org.bezy.controller.auth;

import jakarta.validation.Valid;
import org.bezy.model.auth.Consumer;
import org.bezy.model.auth.ServiceProvider;
import org.bezy.service.auth.ConsumerService;
import org.bezy.service.auth.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class RegistrationController {

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private ServiceProviderService serviceProviderService;

    @PostMapping("/register/consumer")
    public ResponseEntity<?> registerConsumer(@Valid @RequestBody Consumer consumer,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.append(error.getField())
                            .append(": ")
                            .append(error.getDefaultMessage())
                            .append("; ")
            );
            return ResponseEntity.badRequest().body(errors.toString());
        }
        Consumer registeredConsumer = consumerService.registerConsumer(consumer);
        return ResponseEntity.ok(registeredConsumer);
    }

    @PostMapping("/register/provider")
    public ResponseEntity<?> registerProvider(@Valid @RequestBody ServiceProvider provider,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.append(error.getField())
                            .append(": ")
                            .append(error.getDefaultMessage())
                            .append("; ")
            );
            return ResponseEntity.badRequest().body(errors.toString());
        }
        ServiceProvider registeredProvider = serviceProviderService.registerProvider(provider);
        return ResponseEntity.ok(registeredProvider);
    }
}
