package dev.repository.Admin;

import dev.domain.Orphanage.OrphanageFoodRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ManageOrphanageFoodRequestRepo {
    private SessionFactory sessionFactory;

    public ManageOrphanageFoodRequestRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void create(OrphanageFoodRequest of) {
        Session session = sessionFactory.getCurrentSession();
        session.save(of);
    }

    public void edit(OrphanageFoodRequest of) {
        Session session = sessionFactory.getCurrentSession();
        session.update(of);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        OrphanageFoodRequest of = findById(id);
        session.delete(of);
    }

    public List<OrphanageFoodRequest> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<OrphanageFoodRequest> userQuery = session.createQuery("from OrphanageFoodRequest ", OrphanageFoodRequest.class);
        return userQuery.getResultList();
    }

    public OrphanageFoodRequest findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(OrphanageFoodRequest.class, id);
    }
}
