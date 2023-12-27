package dev.service.User;

import dev.domain.User.Role;
import dev.repository.User.RoleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void create(Role role) {
        roleRepository.create(role);
    }

    public List<Role> getAll() {
        return roleRepository.getAll();
    }
}
