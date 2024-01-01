package dev.repository.Admin;

import dev.domain.DeliveryMan.StoredFoodItem;
import dev.domain.User.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryTrackingRepo {
    private SessionFactory sessionFactory;

    public InventoryTrackingRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(StoredFoodItem sf) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sf);
    }

    public void edit(StoredFoodItem sf) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sf);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        StoredFoodItem sf = findById(id);
        session.delete(sf);
    }

    public List<StoredFoodItem> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<StoredFoodItem> userQuery = session.createQuery("from StoredFoodItem", StoredFoodItem.class);
        return userQuery.getResultList();
    }

    public StoredFoodItem findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(StoredFoodItem.class, id);
    }


}
