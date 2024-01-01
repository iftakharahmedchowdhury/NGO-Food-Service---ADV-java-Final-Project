package dev.repository.Restaurant;

import dev.domain.Restaurant.CollectRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Repository
public class CollectRequestRepository {

    private SessionFactory sessionFactory;

    public CollectRequestRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(CollectRequest collectRequest) {
        Session session = sessionFactory.getCurrentSession();
        session.save(collectRequest);
    }

    public void edit(CollectRequest collectRequest) {
        Session session = sessionFactory.getCurrentSession();
        session.update(collectRequest);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        CollectRequest collectRequest = findById(id);
        session.delete(collectRequest);
    }

    public CollectRequest findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(CollectRequest.class, id);
    }

    public List<CollectRequest> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<CollectRequest> userQuery = session.createQuery("from CollectRequest ", CollectRequest.class);
       /* Query<CollectRequest> query = session.createQuery("SELECT cr FROM CollectRequest cr LEFT JOIN FETCH cr.foodItems", CollectRequest.class);*/
        return userQuery.getResultList();
    }


}

