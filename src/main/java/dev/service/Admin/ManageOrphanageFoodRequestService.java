package dev.service.Admin;


import dev.domain.Orphanage.OrphanageFoodRequest;
import dev.domain.User.User;
import dev.repository.Admin.ManageOrphanageFoodRequestRepo;
import dev.service.User.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ManageOrphanageFoodRequestService {
    private ManageOrphanageFoodRequestRepo manageOrphanageFoodRequestRepo;
    private UserService userService;

    public ManageOrphanageFoodRequestService(ManageOrphanageFoodRequestRepo manageOrphanageFoodRequestRepo,UserService userService) {
        this.manageOrphanageFoodRequestRepo = manageOrphanageFoodRequestRepo;
        this.userService=userService;
    }

    public void create(OrphanageFoodRequest of) {
        User us =userService.get(of.getOrphanageUserId());
        of.setOrphanageName(us.getFullname());
        of.setStatus("In process");
        of.setOrphanageAddress(us.getAddress());

        manageOrphanageFoodRequestRepo.create(of);
    }

    public List<OrphanageFoodRequest> getAll() {
        return manageOrphanageFoodRequestRepo.getAll();
    }
    public OrphanageFoodRequest findById(int requestId) {
        return manageOrphanageFoodRequestRepo.findById(requestId);
    }
    public void delete(int id) {
        manageOrphanageFoodRequestRepo.delete(id);
    }

    public void edit ( int id,OrphanageFoodRequest of ) {
         OrphanageFoodRequest obj= findById(id);

        obj.setStatus("Employee assigned");
        obj.setAssignEmployee(of.getAssignEmployee());

        manageOrphanageFoodRequestRepo.edit(obj);
    }
}
