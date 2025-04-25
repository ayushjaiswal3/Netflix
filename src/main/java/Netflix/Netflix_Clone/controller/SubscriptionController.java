package Netflix.Netflix_Clone.controller;

import Netflix.Netflix_Clone.model.Subscription;
import Netflix.Netflix_Clone.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscription")
@CrossOrigin(origins = "*")

public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<Subscription> saveSubscription(@RequestBody Subscription subscription) {
        return ResponseEntity.ok(subscriptionService.saveSubscription(subscription));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable Long id) {
        return ResponseEntity.ok(subscriptionService.getSubscriptionById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Subscription>> getSubscriptionByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(subscriptionService.getSubscriptionByUserId(userId));
    }

    @GetMapping
    public ResponseEntity<List<Subscription>> getAllSubscription() {
        return ResponseEntity.ok(subscriptionService.getAllSubscription());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.noContent().build();
    }
}
