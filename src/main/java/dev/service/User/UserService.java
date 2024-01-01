package dev.service.User;

import dev.domain.User.User;
import dev.repository.User.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        user.setFullname(user.getFullname().toUpperCase());
        user.setEnabled(0);
        userRepository.create(user);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User get(int id) {
        return userRepository.get(id);
    }

    public void delete(int id) {
        userRepository.delete(id);
    }
    public void edit (User user) {

        userRepository.edit(user);
    }
    public void allowUser (User user) {
        user.setEnabled(1);
        userRepository.allowUser(user);
    }
    public void NotallowUser (User user) {
        user.setEnabled(0);
        userRepository.NotallowUser(user);
    }
}
