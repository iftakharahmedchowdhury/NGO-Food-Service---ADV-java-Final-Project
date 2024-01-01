package dev.repository.Restaurant;

import dev.domain.Restaurant.CollectRequest;
import dev.domain.Restaurant.CollectRequestsFoodItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


@Repository
public class CollectRequestItemRepository {

    private SessionFactory sessionFactory;

    public CollectRequestItemRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(CollectRequestsFoodItem collectRequestItem) {
        Session session = sessionFactory.getCurrentSession();
        session.save(collectRequestItem);
    }
    public void edit(CollectRequestsFoodItem collectRequestItem) {
        Session session = sessionFactory.getCurrentSession();
        session.update(collectRequestItem);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        CollectRequestsFoodItem collectRequestsFoodItem = findById(id);
        session.delete(collectRequestsFoodItem);
    }

    public CollectRequestsFoodItem findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(CollectRequestsFoodItem.class, id);
    }

   public List<CollectRequestsFoodItem> findByRequestId(int id) {
       Session session = sessionFactory.getCurrentSession();
       Query<CollectRequestsFoodItem> query = session.createQuery("from CollectRequestsFoodItem where requestId = :id", CollectRequestsFoodItem.class);
       query.setParameter("id", id);
       return query.getResultList();
   }

    public List<CollectRequestsFoodItem> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<CollectRequestsFoodItem> userQuery = session.createQuery("from CollectRequestsFoodItem ", CollectRequestsFoodItem.class);
        return userQuery.getResultList();
    }


}

