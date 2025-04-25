package Netflix.Netflix_Clone.service;

import Netflix.Netflix_Clone.model.SubscriptionPlan;

import java.util.List;

public interface SubscriptionPlanService {

    SubscriptionPlan activatePlan(SubscriptionPlan plan);

    List<SubscriptionPlan> getAllPlan();

    SubscriptionPlan getPlanById(Long id);

    SubscriptionPlan updatePlan(Long id, SubscriptionPlan updatedPlan);

    void deletePlan(Long id);
}
