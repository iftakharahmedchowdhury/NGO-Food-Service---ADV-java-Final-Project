package dev.service.Admin;

import dev.domain.User.User;
import dev.repository.User.UserRepository;
import dev.service.User.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ManageUserService {
    private UserService userService;

    public ManageUserService(UserService userService) {
        this.userService = userService;
    }
    public List<User> getAll() {

        return userService.getAll()
                .stream()
                .filter(user -> user.getEnabled() == 0)
                .collect(Collectors.toList());

    }
    public String findById(int id) {

        User user = userService.get(id);
         userService.allowUser(user);
         return "user allowed";
    }
    public String findByIdDS(int id) {

        User user = userService.get(id);
        userService.NotallowUser(user);
        return "user allowed";
    }
}
