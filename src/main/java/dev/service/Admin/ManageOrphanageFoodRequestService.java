package dev.service.Admin;


import dev.domain.Orphanage.OrphanageFoodRequest;
import dev.repository.Admin.ManageOrphanageFoodRequestRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ManageOrphanageFoodRequestService {
    private ManageOrphanageFoodRequestRepo manageOrphanageFoodRequestRepo;

    public ManageOrphanageFoodRequestService(ManageOrphanageFoodRequestRepo manageOrphanageFoodRequestRepo) {
        this.manageOrphanageFoodRequestRepo = manageOrphanageFoodRequestRepo;
    }

    public void create(OrphanageFoodRequest of) {
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

    public void edit (OrphanageFoodRequest of) {
        manageOrphanageFoodRequestRepo.edit(of);
    }
}
