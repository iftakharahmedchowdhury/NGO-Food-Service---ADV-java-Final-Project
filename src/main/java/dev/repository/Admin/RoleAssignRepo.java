package dev.repository.Admin;

import dev.domain.Admin.UserHasRole;
import dev.domain.User.Role;
import dev.domain.User.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleAssignRepo {


    private SessionFactory sessionFactory;

    public RoleAssignRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }





public void create(UserHasRole userHasRole) {
    Session session = sessionFactory.getCurrentSession();
    session.save(userHasRole);
}

public void edit(UserHasRole userHasRole) {
    Session session = sessionFactory.getCurrentSession();
    session.update(userHasRole);
}
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserHasRole userHasRole = get(id);
        session.delete(userHasRole);
    }
    public List<UserHasRole> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<UserHasRole> userQuery = session.createQuery("from UserHasRole", UserHasRole.class);
        return userQuery.getResultList();
    }
   public UserHasRole get(int userId) {
       Session session = sessionFactory.getCurrentSession();
       Query<UserHasRole> query = session.createQuery(
               "FROM UserHasRole uhr WHERE uhr.user_id = :userId",
               UserHasRole.class
       );
       query.setParameter("userId", userId);
       return query.uniqueResult();
   }




}