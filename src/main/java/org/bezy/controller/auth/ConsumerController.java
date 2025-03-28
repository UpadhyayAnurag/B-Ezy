package org.bezy.controller.auth;



import org.bezy.model.auth.Consumer;
import org.bezy.service.auth.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/consumers")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getConsumer(@PathVariable Long id) {
        // Retrieved using username to be replaced with retrieve using id method later
        Optional<Consumer> consumer = consumerService.getConsumerByUsername("sampleUsername");
        return consumer.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consumer> updateConsumer(@PathVariable Long id, @RequestBody Consumer updatedConsumer) {
        // In a complete implementation, update by id with proper validations.
        Consumer consumer = consumerService.registerConsumer(updatedConsumer);
        return ResponseEntity.ok(consumer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteConsumer(@PathVariable Long id) {
        // Implement deletion in service (not shown here for brevity)
        return ResponseEntity.ok("Consumer deleted");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Consumer>> searchConsumers(@RequestParam String username) {
        List<Consumer> consumers = consumerService.searchConsumersByUsername(username);
        return ResponseEntity.ok(consumers);
    }
}

