package dev.service.Admin;

import dev.domain.Restaurant.CollectRequest;
import dev.service.Restaurant.CollectRequestItemService;
import dev.service.Restaurant.CollectRequestService;
import org.springframework.stereotype.Service;

@Service
public class ManageCollectRequestService {

    private CollectRequestService collectRequestService;
    private CollectRequestItemService collectRequestItemService;

    public ManageCollectRequestService(CollectRequestService collectRequestService, CollectRequestItemService collectRequestItemService) {
        this.collectRequestService = collectRequestService;

    }

    public void edit(int id ,CollectRequest collectRequest) {
        CollectRequest clrData = collectRequestService.findById(id);
        clrData.setAssignedEmployeeId(collectRequest.getAssignedEmployeeId());
        clrData.setStatus("Delivery man Assigned");
        collectRequestService.edit(clrData);
    }
    public void editForReject(int id) {
        CollectRequest clrData = collectRequestService.findById(id);

        clrData.setStatus("Rejected");
        collectRequestService.edit(clrData);
    }
}
