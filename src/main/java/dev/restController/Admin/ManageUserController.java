package dev.restController.Admin;

import dev.domain.DeliveryMan.StoredFoodItem;
import dev.domain.User.User;
import dev.service.Admin.ManageUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManageUserController {
    private ManageUserService manageUserService;

    public ManageUserController(ManageUserService manageUserService) {
        this.manageUserService = manageUserService;
    }

    @GetMapping("/disableUsers")
    public List<User> getUsers() {
        return manageUserService.getAll();
    }

    @PostMapping("/enableSpecificUsers/{id}")
    public String EnableSpecificUsers(@PathVariable("id") int id) {
        manageUserService.findById(id);
        return "successfully enable user";
    }
    @PostMapping("/disableSpecificUsers/{id}")
    public String DisableSpecificUsers(@PathVariable("id") int id) {
        manageUserService.findByIdDS(id);
        return "successfully Disable user";
    }
}
