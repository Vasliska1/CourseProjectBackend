package ifmo.ru.CourceWorkBackEnd.repository;

import ifmo.ru.CourceWorkBackEnd.model.Subscription;
import ifmo.ru.CourceWorkBackEnd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository  extends JpaRepository<Subscription, Integer> {

}
