package dev.repository.Restaurant;

import dev.domain.Restaurant.Feedback;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeedBackRepo {
    private SessionFactory sessionFactory;

    public FeedBackRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Feedback fb) {
        Session session = sessionFactory.getCurrentSession();
        session.save(fb);
    }

    public void edit(Feedback fb) {
        Session session = sessionFactory.getCurrentSession();
        session.update(fb);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Feedback fb = findById(id);
        session.delete(fb);
    }

    public List<Feedback> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Feedback> userQuery = session.createQuery("from Feedback ", Feedback.class);
        return userQuery.getResultList();
    }

    public Feedback findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Feedback.class, id);
    }

}
