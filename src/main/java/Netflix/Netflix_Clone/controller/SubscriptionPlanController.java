package Netflix.Netflix_Clone.controller;

import Netflix.Netflix_Clone.model.SubscriptionPlan;
import Netflix.Netflix_Clone.repository.SubscriptionPlanRepository;
import Netflix.Netflix_Clone.service.SubscriptionPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscription-plan")
@RequiredArgsConstructor

public class SubscriptionPlanController {

    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @PostMapping
    public ResponseEntity<SubscriptionPlan> activatePlan(@RequestBody SubscriptionPlan subscriptionPlan) {
        return ResponseEntity.ok(subscriptionPlanService.activatePlan(subscriptionPlan));
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionPlan>> getAllPlans() {
        return ResponseEntity.ok(subscriptionPlanService.getAllPlan());
    }

    // Get a plan by ID
    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionPlan> getPlanById(@PathVariable Long id) {
        SubscriptionPlan plan = subscriptionPlanService.getPlanById(id);
        return plan != null ? ResponseEntity.ok(plan) : ResponseEntity.notFound().build();
    }

    // Update a plan
    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionPlan> updatePlan(@PathVariable Long id, @RequestBody SubscriptionPlan updatedPlan) {
        SubscriptionPlan plan = subscriptionPlanService.updatePlan(id, updatedPlan);
        return plan != null ? ResponseEntity.ok(plan) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        subscriptionPlanService.deletePlan(id);
        return ResponseEntity.ok().build();
    }
}
