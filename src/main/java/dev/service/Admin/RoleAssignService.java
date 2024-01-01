package dev.service.Admin;

import dev.domain.Admin.UserHasRole;
import dev.domain.User.User;
import dev.repository.Admin.RoleAssignRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleAssignService {
    private RoleAssignRepo roleAssignRepo;

    public RoleAssignService(RoleAssignRepo roleAssignRepo) {
        this.roleAssignRepo = roleAssignRepo;
    }

    public void create(int userId , int roleId) {
        UserHasRole userHasRole = new UserHasRole();
        userHasRole=  roleAssignRepo.get(userId);
        if (userHasRole==null){
            UserHasRole userHasRole2 = new UserHasRole();

            userHasRole2.setUser_id(userId);
            userHasRole2.setRole_id(roleId);
            roleAssignRepo.create(userHasRole2);
        }
        else
        {
            userHasRole.setRole_id(roleId);
            edit(userHasRole);
        }

    }

    public List<UserHasRole> getAll() {
        return roleAssignRepo.getAll();
    }

    public UserHasRole get(int id) {
        return roleAssignRepo.get(id);
    }

    public void delete(int id) {
        roleAssignRepo.delete(id);
    }
    public void edit (UserHasRole userHasRole) {
        roleAssignRepo.edit(userHasRole);
    }
}
