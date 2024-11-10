package tn.esprit.anasbettouzia4twin5.services;

import tn.esprit.anasbettouzia4twin5.entities.Subscription;

import java.util.List;

public interface ISubscriptionServices {
    Subscription addSubscription(Subscription subscription);
    Subscription updateSubscription(Subscription subscription);
    Subscription retirerSubscription(Long numSubscription);
    List<Subscription> getAllSubscription();
    void removeSubscription(Long numSubscription);
}
