package dev.restController.Admin;

import dev.domain.Admin.UserHasRole;
import dev.domain.User.Role;
import dev.domain.User.User;
import dev.service.Admin.RoleAssignService;
import dev.service.User.RoleService;
import dev.service.User.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleAssignController {

    private UserService userService;
    private RoleService roleService;
    private RoleAssignService roleAssignService;

    public RoleAssignController(UserService userService, RoleService roleService,RoleAssignService roleAssignService) {
        this.userService = userService;
        this.roleService = roleService;
        this.roleAssignService=roleAssignService;
    }

   /* @PostMapping("/assignRole")
    public ResponseEntity<String> assignRoleToUser(@RequestParam int userId, @RequestParam int roleId) {
        try {
            User user = userService.get(userId);
            Role role = roleService.getRoleById(roleId);

            if (user == null || role == null) {
                return ResponseEntity.badRequest().body("User or Role not found");
            }


            roleAssignService.create(userId,roleId);
            return ResponseEntity.ok("Role assigned successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error assigning role: " + e.getMessage());
        }
    }*/
   @PostMapping("/assignRole")
   public ResponseEntity<String> assignRoleToUser(@RequestBody UserHasRole request) {
       try {
           int userId = request.getUser_id();
           int roleId = request.getRole_id();

           User user = userService.get(userId);
           Role role = roleService.getRoleById(roleId);

           if (user == null || role == null) {
               return ResponseEntity.badRequest().body("User or Role not found");
           }

           roleAssignService.create(userId, roleId);
           return ResponseEntity.ok("Role assigned successfully");
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Error assigning role: " + e.getMessage());
       }
   }

}

