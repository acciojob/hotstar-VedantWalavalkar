package com.driver.services;


import com.driver.EntryDto.SubscriptionEntryDto;
import com.driver.model.Subscription;
import com.driver.model.SubscriptionType;
import com.driver.model.User;
import com.driver.repository.SubscriptionRepository;
import com.driver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;
//    SubscriptionRepository subscriptionRepository = new SubscriptionRepository() {
//    @Override
//    public List<Subscription> findAll() {
//        return null;
//    }
//
//    @Override
//    public List<Subscription> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public List<Subscription> findAllById(Iterable<Integer> iterable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Subscription> List<S> saveAll(Iterable<S> iterable) {
//        return null;
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public <S extends Subscription> S saveAndFlush(S s) {
//        return null;
//    }
//
//    @Override
//    public void deleteInBatch(Iterable<Subscription> iterable) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public Subscription getOne(Integer integer) {
//        return null;
//    }
//
//    @Override
//    public <S extends Subscription> List<S> findAll(Example<S> example) {
//        return null;
//    }
//
//    @Override
//    public <S extends Subscription> List<S> findAll(Example<S> example, Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<Subscription> findAll(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Subscription> S save(S s) {
//        return null;
//    }
//
//    @Override
//    public Optional<Subscription> findById(Integer integer) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Integer integer) {
//        return false;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Integer integer) {
//
//    }
//
//    @Override
//    public void delete(Subscription subscription) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Subscription> iterable) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public <S extends Subscription> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends Subscription> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Subscription> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends Subscription> boolean exists(Example<S> example) {
//        return false;
//    }
//};

    @Autowired
    UserRepository userRepository;
//    UserRepository userRepository = new UserRepository() {
//        @Override
//        public List<User> findAll() {
//            return null;
//        }
//
//        @Override
//        public List<User> findAll(Sort sort) {
//            return null;
//        }
//
//        @Override
//        public List<User> findAllById(Iterable<Integer> iterable) {
//            return null;
//        }
//
//        @Override
//        public <S extends User> List<S> saveAll(Iterable<S> iterable) {
//            return null;
//        }
//
//        @Override
//        public void flush() {
//
//        }
//
//        @Override
//        public <S extends User> S saveAndFlush(S s) {
//            return null;
//        }
//
//        @Override
//        public void deleteInBatch(Iterable<User> iterable) {
//
//        }
//
//        @Override
//        public void deleteAllInBatch() {
//
//        }
//
//        @Override
//        public User getOne(Integer integer) {
//            return null;
//        }
//
//        @Override
//        public <S extends User> List<S> findAll(Example<S> example) {
//            return null;
//        }
//
//        @Override
//        public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
//            return null;
//        }
//
//        @Override
//        public Page<User> findAll(Pageable pageable) {
//            return null;
//        }
//
//        @Override
//        public <S extends User> S save(S s) {
//            return null;
//        }
//
//        @Override
//        public Optional<User> findById(Integer integer) {
//            return Optional.empty();
//        }
//
//        @Override
//        public boolean existsById(Integer integer) {
//            return false;
//        }
//
//        @Override
//        public long count() {
//            return 0;
//        }
//
//        @Override
//        public void deleteById(Integer integer) {
//
//        }
//
//        @Override
//        public void delete(User user) {
//
//        }
//
//        @Override
//        public void deleteAll(Iterable<? extends User> iterable) {
//
//        }
//
//        @Override
//        public void deleteAll() {
//
//        }
//
//        @Override
//        public <S extends User> Optional<S> findOne(Example<S> example) {
//            return Optional.empty();
//        }
//
//        @Override
//        public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
//            return null;
//        }
//
//        @Override
//        public <S extends User> long count(Example<S> example) {
//            return 0;
//        }
//
//        @Override
//        public <S extends User> boolean exists(Example<S> example) {
//            return false;
//        }
//    };

    public Integer buySubscription(SubscriptionEntryDto subscriptionEntryDto){

        //Save The subscription Object into the Db and return the total Amount that user has to pay

        // 1. Check for the user
        Optional<User> optionalUser = userRepository.findById(subscriptionEntryDto.getUserId());
        if(!optionalUser.isPresent())
            return 0;
        User user = optionalUser.get();

        // 2. Calculate total amount to be paid

        int total = 0;
        SubscriptionType subscriptionType = subscriptionEntryDto.getSubscriptionType();
        int noOfScreens = subscriptionEntryDto.getNoOfScreensRequired();

        if(subscriptionType == SubscriptionType.BASIC)
            total = 500 + (200 * noOfScreens);
        else if(subscriptionType == SubscriptionType.PRO)
            total = 800 + (250 * noOfScreens);
        else
            total = 1000 + (350 * noOfScreens);


        // 3. Create a subscription
        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setSubscriptionType(subscriptionEntryDto.getSubscriptionType());
        subscription.setNoOfScreensSubscribed(subscriptionEntryDto.getNoOfScreensRequired());
        Date date = new Date();
        subscription.setStartSubscriptionDate(date);
        subscription.setTotalAmountPaid(total);

        user.setSubscription(subscription);

        Subscription savedSubscription = subscriptionRepository.save(subscription);


        return savedSubscription.getTotalAmountPaid();
    }

    public Integer upgradeSubscription(Integer userId)throws Exception{

        //If you are already at an ElITE subscription : then throw Exception ("Already the best Subscription")
        //In all other cases just try to upgrade the subscription and tell the difference of price that user has to pay
        //update the subscription in the repository
        Optional<User> optionalUser = userRepository.findById(userId);
//        if(!optionalUser.isPresent())
//            throw new Exception("User not found");
        User user = optionalUser.get();
        Subscription subscription = user.getSubscription();
//        if(subscription == null)
//            throw new Exception("No subscription");
        if(subscription.getSubscriptionType() == SubscriptionType.ELITE)
            throw new Exception("Already the best Subscription");

        int currentPlanPrice = subscription.getTotalAmountPaid();
        int priceDifference = 0;
        int noOfScreens = subscription.getNoOfScreensSubscribed();

        if(subscription.getSubscriptionType() == SubscriptionType.BASIC){
            subscription.setSubscriptionType(SubscriptionType.PRO);
            int newPlanPrice = 800 + (250 * noOfScreens);
            priceDifference = newPlanPrice - currentPlanPrice;
            subscription.setTotalAmountPaid(newPlanPrice);
        }
        else{
            subscription.setSubscriptionType(SubscriptionType.ELITE);
            int newPlanPrice = 1000 + (350 * noOfScreens);
            priceDifference = newPlanPrice - currentPlanPrice;
            subscription.setTotalAmountPaid(newPlanPrice);
        }

        subscriptionRepository.save(subscription);

        return priceDifference;
    }

    public Integer calculateTotalRevenueOfHotstar(){

        //We need to find out total Revenue of hotstar : from all the subscriptions combined
        //Hint is to use findAll function from the SubscriptionDb
        Integer totalRevenue = 0;
        List<User> users = userRepository.findAll();
        if(users.size()==0) return 0;
        for(User user : users){
            Subscription subscription = user.getSubscription();
            if(subscription != null)
                totalRevenue += subscription.getTotalAmountPaid();
        }

        return totalRevenue;
    }

}
