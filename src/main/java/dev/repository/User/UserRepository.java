package dev.repository.User;

import dev.domain.User.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public void edit(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }
    public void allowUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }
    public void NotallowUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }


    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = get(id);
        session.delete(user);
    }

    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("from User", User.class);
        return userQuery.getResultList();
    }

    public User get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }
}
