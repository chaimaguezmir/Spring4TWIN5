package tn.esprit.anasbettouzia4twin5.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.anasbettouzia4twin5.entities.Instructor;
import tn.esprit.anasbettouzia4twin5.entities.Registration;
import tn.esprit.anasbettouzia4twin5.entities.Subscription;
import tn.esprit.anasbettouzia4twin5.services.RegistrationServicesImp;
import tn.esprit.anasbettouzia4twin5.services.SubscriptionServicesImpl;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subscription")
public class SubscriptionRestController {
    private final SubscriptionServicesImpl subscriptionServices;

    @PostMapping("/add")
    public Subscription getSubscription(@RequestBody Subscription subscription){
        return subscriptionServices.addSubscription(subscription);
    }

    @GetMapping("/get/{numSubscription}")
    public Subscription getSubscription(@PathVariable Long numSubscription){
        return subscriptionServices.retirerSubscription(numSubscription);
    }

    @PutMapping("/update")
    public Subscription updateSubscription(@RequestBody Subscription subscription){
        return subscriptionServices.updateSubscription(subscription);
    }

    @GetMapping("/all")
    public List<Subscription> getAllSubscriptions(){
        return subscriptionServices.getAllSubscription();
    }

    @DeleteMapping("/remove/{numSubscription}")
    public void removeSubscription(@PathVariable Long numSubscription){
        subscriptionServices.removeSubscription(numSubscription);
    }
}
