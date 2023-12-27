package dev.restController.User;

import dev.domain.User.User;
import dev.service.User.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User addUser(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "Successful";
    }

    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        userService.create(user);
        return "Successful";
    }
    @PutMapping("/{users}")
    public String updateUser(@PathVariable("users") int users, @RequestBody User user) {

        userService.edit(user);
        return "Successful";
    }

    @PutMapping("/{users}/en")
    public String AllowUser(@PathVariable("users") int users, @RequestBody User user) {

        userService.allowUser(user);
        return "Successful";
    }
    @PutMapping("/{users}/di")
    public String NotAllowUser(@PathVariable("users") int users, @RequestBody User user) {

        userService.NotallowUser(user);
        return "Successful";
    }
}
