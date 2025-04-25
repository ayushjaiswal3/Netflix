package Netflix.Netflix_Clone.service;

import Netflix.Netflix_Clone.model.Subscription;

import java.util.List;

public interface SubscriptionService {

    Subscription saveSubscription(Subscription subscription);

    Subscription getSubscriptionById(Long id);

    List<Subscription> getSubscriptionByUserId(Long userId);

    List<Subscription> getAllSubscription();

    void deleteSubscription(Long id);

}
