package dev.restController.User;

import dev.domain.User.Role;
import dev.service.User.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleRestController {

    private RoleService roleService;

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public List<Role> getRoles() {
        return roleService.getAll();
    }

    @PostMapping("/roles")
    public String createUser(@RequestBody Role role) {
        roleService.create(role);
        return "Successful";
    }
}
