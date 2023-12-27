
package dev.repository.User;

import dev.domain.User.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository {

    private SessionFactory sessionFactory;

    public RoleRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Role role) {
        Session session = sessionFactory.getCurrentSession();
        session.save(role);
    }

    public void edit(Role role) {
        Session session = sessionFactory.getCurrentSession();
        session.update(role);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Role role = get(id);
        session.delete(role);
    }

    public List<Role> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Role> userQuery = session.createQuery("from Role", Role.class);
        return userQuery.getResultList();
    }

    public Role get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Role.class, id);
    }
}
