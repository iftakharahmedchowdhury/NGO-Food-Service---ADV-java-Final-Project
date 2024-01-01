package dev.domain.Admin;

import javax.persistence.*;

@Entity
@Table(name = "user_has_roles")
public class UserHasRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


   /* @JoinColumn(name = "user_id", referencedColumnName = "id")*/
    @Column(name="user_id")
    private int user_id;


/*    @JoinColumn(name = "role_id", referencedColumnName = "id")*/
    @Column(name="role_id")
    private int role_id;

    public UserHasRole() {
    }

    public UserHasRole(int id, int user_id, int role_id) {
        this.id = id;
        this.user_id = user_id;
        this.role_id = role_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
