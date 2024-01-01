package dev.restController.Admin;

import dev.domain.Orphanage.OrphanageFoodRequest;
import dev.service.Admin.ManageOrphanageFoodRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ManageOrphanageFoodRequestController {
    private ManageOrphanageFoodRequestService manageOrphanageFoodRequestService;

    public ManageOrphanageFoodRequestController(ManageOrphanageFoodRequestService manageOrphanageFoodRequestService) {
        this.manageOrphanageFoodRequestService = manageOrphanageFoodRequestService;
    }

    @GetMapping("/orphanageFoodRequst")
    public List<OrphanageFoodRequest> getAllOrphanagaeRequest() {
        return manageOrphanageFoodRequestService.getAll();
    }


    @PostMapping("/orphanageFoodRequst")
    public String insertOrphanageRequest(@RequestBody OrphanageFoodRequest orphanageFoodRequest) {
        manageOrphanageFoodRequestService.create(orphanageFoodRequest);
        return "Successful";
    }

    @PutMapping("/orphanageFoodRequst/{id}")
    public String updateRequest(@PathVariable("id") int id, @RequestBody OrphanageFoodRequest orphanageFoodRequest) {

        manageOrphanageFoodRequestService.edit(id ,orphanageFoodRequest);
        return "Successful updated";
    }

    @GetMapping("/orphanageFoodRequst/{id}")
    public OrphanageFoodRequest GetAllRequestById(@PathVariable("id") int id) {
        return manageOrphanageFoodRequestService.findById(id);
    }

    @DeleteMapping("/orphanageFoodRequst/{id}")
    public String deleteRequestById(@PathVariable("id") int id) {
        manageOrphanageFoodRequestService.delete(id);
        return "Delete Successful";
    }
}
