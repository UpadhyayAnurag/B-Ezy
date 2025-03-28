package org.bezy.controller.auth;

import org.bezy.model.auth.ServiceProvider;
import org.bezy.service.auth.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/providers")
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService serviceProviderService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getProvider(@PathVariable Long id) {
        Optional<ServiceProvider> provider = serviceProviderService.getProviderByCompanyName("sampleCompany");
        return provider.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceProvider> updateProvider(@PathVariable Long id, @RequestBody ServiceProvider updatedProvider) {
        ServiceProvider provider = serviceProviderService.registerProvider(updatedProvider);
        return ResponseEntity.ok(provider);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProvider(@PathVariable Long id) {
        return ResponseEntity.ok("Provider deleted");
    }

    @GetMapping("/search")
    public ResponseEntity<List<ServiceProvider>> searchProviders(@RequestParam String companyName) {
        Optional<ServiceProvider> provider = serviceProviderService.getProviderByCompanyName(companyName);
        return provider.map(p -> ResponseEntity.ok(List.of(p)))
                .orElse(ResponseEntity.notFound().build());
    }
}

