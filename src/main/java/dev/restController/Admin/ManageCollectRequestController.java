package dev.restController.Admin;

import dev.domain.Restaurant.CollectRequest;
import dev.service.Admin.ManageCollectRequestService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManageCollectRequestController {
    private ManageCollectRequestService manageCollectRequestService;

    public ManageCollectRequestController(ManageCollectRequestService manageCollectRequestService) {
        this.manageCollectRequestService = manageCollectRequestService;
    }

    @PutMapping("/Admin/AcceptRequest/{id}")
    public String Acceptrequest(@PathVariable("id") int id, @RequestBody CollectRequest collectRequest) {

        manageCollectRequestService.edit(id,collectRequest);
        return "Reqest accepted delivery man assigned";
    }

    @PutMapping("/Admin/RejectRequest/{id}")
    public String RejectRequest(@PathVariable("id") int id/*, @RequestBody CollectRequest collectRequest*/) {

        manageCollectRequestService.editForReject(id/*,collectRequest*/);
        return "Reqest Rejected";
    }
}
