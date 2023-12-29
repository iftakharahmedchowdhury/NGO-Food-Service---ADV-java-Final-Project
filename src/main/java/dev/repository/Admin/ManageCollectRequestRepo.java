package dev.repository.Admin;

import dev.domain.Restaurant.CollectRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ManageCollectRequestRepo {
    private SessionFactory sessionFactory;

    public ManageCollectRequestRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void edit(CollectRequest collectRequest) {
        Session session = sessionFactory.getCurrentSession();
        session.update(collectRequest);
    }
}
