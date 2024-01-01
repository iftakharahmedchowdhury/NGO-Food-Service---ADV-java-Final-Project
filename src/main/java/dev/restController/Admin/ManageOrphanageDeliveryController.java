package dev.restController.Admin;

import dev.domain.Admin.DeliveryConfirmation;
import dev.domain.DeliveryMan.StoredFoodItem;
import dev.service.Admin.InventoryTrackingService;
import dev.service.Admin.ManageOrphanageDeliveryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ManageOrphanageDeliveryController {

    private ManageOrphanageDeliveryService manageOrphanageDeliveryService;
    private InventoryTrackingService inventoryTrackingService;

    public ManageOrphanageDeliveryController(ManageOrphanageDeliveryService manageOrphanageDeliveryService) {
        this.manageOrphanageDeliveryService = manageOrphanageDeliveryService;
    }


    @GetMapping("/deliveryConfirm")
    public List<DeliveryConfirmation> getAllConfirmedDelivery() {
        return manageOrphanageDeliveryService.getAll();
    }

    @PostMapping("/deliveryConfirm")
    public String insertDelivery(@RequestBody DeliveryConfirmation dc) {
        manageOrphanageDeliveryService.create(dc);
        return "Successful";
    }


    @PutMapping("/deliveryConfirm/{id}")
    public String updateDelivery(@PathVariable("id") int id, @RequestBody DeliveryConfirmation dc) {

        manageOrphanageDeliveryService.edit(dc);
        return "Successful updated";
    }

    @GetMapping("/deliveryConfirm/{id}")
    public DeliveryConfirmation GetDeliveryById(@PathVariable("id") int id) {
        return manageOrphanageDeliveryService.findById(id);
    }

    @DeleteMapping("/deliveryConfirm/{id}")
    public String deleteDeliveryDetails(@PathVariable("id") int id) {
        manageOrphanageDeliveryService.delete(id);
        return "Delete Successful";
    }

}
