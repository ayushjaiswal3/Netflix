package Netflix.Netflix_Clone.service;

import Netflix.Netflix_Clone.model.SubscriptionPlan;
import Netflix.Netflix_Clone.repository.SubscriptionPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionPlanServiceImpl implements SubscriptionPlanService{

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    @Override
    public SubscriptionPlan activatePlan(SubscriptionPlan plan) {
        return subscriptionPlanRepository.save(plan);
    }

    @Override
    public List<SubscriptionPlan> getAllPlan() {
        return subscriptionPlanRepository.findAll();
    }

    @Override
    public SubscriptionPlan getPlanById(Long id) {
        return subscriptionPlanRepository.findById(id).orElse(null);
    }

    @Override
    public SubscriptionPlan updatePlan(Long id, SubscriptionPlan updatedPlan) {
        SubscriptionPlan existingPlan = subscriptionPlanRepository.findById(id).orElse(null);
        if (existingPlan != null) {
            existingPlan.setName(updatedPlan.getName());
            existingPlan.setPrice(updatedPlan.getPrice());
            existingPlan.setDescription(updatedPlan.getDescription());
            existingPlan.setDuration(updatedPlan.getDuration());
            return subscriptionPlanRepository.save(existingPlan);
        }
        return null;
    }


    @Override
    public void deletePlan(Long id) {
        subscriptionPlanRepository.deleteById(id);
    }
}
