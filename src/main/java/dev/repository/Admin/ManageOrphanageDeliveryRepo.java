package dev.repository.Admin;

import dev.domain.Admin.DeliveryConfirmation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Queue;

import java.util.List;
@Repository
public class ManageOrphanageDeliveryRepo {

    private SessionFactory sessionFactory;

    public ManageOrphanageDeliveryRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(DeliveryConfirmation deliveryConfirmation) {
        Session session = sessionFactory.getCurrentSession();
        session.save(deliveryConfirmation);
    }

    public void edit(DeliveryConfirmation deliveryConfirmation) {
        Session session = sessionFactory.getCurrentSession();
        session.update(deliveryConfirmation);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        DeliveryConfirmation deliveryConfirmation = findById(id);
        session.delete(deliveryConfirmation);
    }

    public List<DeliveryConfirmation> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<DeliveryConfirmation> userQuery = session.createQuery("from DeliveryConfirmation ", DeliveryConfirmation.class);
        return userQuery.getResultList();
    }

    public DeliveryConfirmation findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(DeliveryConfirmation.class, id);
    }

}
