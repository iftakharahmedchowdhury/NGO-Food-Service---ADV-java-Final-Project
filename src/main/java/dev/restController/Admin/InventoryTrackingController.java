package dev.restController.Admin;

import dev.domain.DeliveryMan.StoredFoodItem;
import dev.service.Admin.InventoryTrackingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryTrackingController {
    private InventoryTrackingService inventoryTrackingService;

    public InventoryTrackingController(InventoryTrackingService inventoryTrackingService) {
        this.inventoryTrackingService = inventoryTrackingService;
    }

    @GetMapping("/storedFoodItem")
    public List<StoredFoodItem> getAllStoredFoodItem() {
        return inventoryTrackingService.getAll();
    }


    @PostMapping("/storedFoodItem/{id}")
    public String insertFoodItem(@PathVariable("id") int id/*,@RequestBody StoredFoodItem storedFoodItem*/) {
        inventoryTrackingService.create(id/*,storedFoodItem*/);
        return "Successful";
    }

    @PutMapping("/storedFoodItem/{id}")
    public String updateFoodItems(@PathVariable("id") int id, @RequestBody StoredFoodItem storedFoodItem) {

        inventoryTrackingService.edit(storedFoodItem);
        return "Successful updated";
    }

    @GetMapping("/storedFoodItem/{id}")
    public StoredFoodItem GetAllRequestById(@PathVariable("id") int id) {
        return inventoryTrackingService.findById(id);
    }

    @DeleteMapping("/storedFoodItem/{id}")
    public String deleteRequestById(@PathVariable("id") int id) {
        inventoryTrackingService.delete(id);
        return "Delete Successful";
    }


}
