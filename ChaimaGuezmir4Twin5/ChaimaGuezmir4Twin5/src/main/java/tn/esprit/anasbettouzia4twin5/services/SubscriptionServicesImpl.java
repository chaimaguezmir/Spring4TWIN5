package tn.esprit.anasbettouzia4twin5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.anasbettouzia4twin5.entities.Subscription;
import tn.esprit.anasbettouzia4twin5.repository.ISubscriptionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServicesImpl implements ISubscriptionServices{

    private final ISubscriptionRepository iSubscriptionRepository;
    @Override
    public Subscription addSubscription(Subscription subscription) {
        return iSubscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription updatedSubscription) {
        Subscription existingSubscription = iSubscriptionRepository.findById(updatedSubscription.getNumSub())
                .orElseThrow(() -> new RuntimeException("Subscription not found with ID: " + updatedSubscription.getNumSub()));

        existingSubscription.setStartDate(updatedSubscription.getStartDate());
        existingSubscription.setEndDate(updatedSubscription.getEndDate());
        existingSubscription.setPrice(updatedSubscription.getPrice());
        existingSubscription.setTypeSub(updatedSubscription.getTypeSub());

        return iSubscriptionRepository.save(existingSubscription);
    }


    @Override
    public Subscription retirerSubscription(Long numSubscription) {
        return iSubscriptionRepository.findById(numSubscription).orElse(null);
    }

    @Override
    public List<Subscription> getAllSubscription() {
        return (List<Subscription>) iSubscriptionRepository.findAll();
    }

    @Override
    public void removeSubscription(Long numSubscription) {
         iSubscriptionRepository.deleteById(numSubscription);

    }
}
