package dev.service.Admin;

import dev.domain.DeliveryMan.StoredFoodItem;
import dev.domain.Restaurant.CollectRequest;
import dev.repository.Admin.InventoryTrackingRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InventoryTrackingService {
    private InventoryTrackingRepo inventoryTrackingRepo;

    public InventoryTrackingService(InventoryTrackingRepo inventoryTrackingRepo) {
        this.inventoryTrackingRepo = inventoryTrackingRepo;
    }

    public void create(StoredFoodItem sf) {
        inventoryTrackingRepo.create(sf);
    }

    public List<StoredFoodItem> getAll() {
        return inventoryTrackingRepo.getAll();
    }
    public StoredFoodItem findById(int requestId) {
        return inventoryTrackingRepo.findById(requestId);
    }
    public void delete(int id) {
        inventoryTrackingRepo.delete(id);
    }

    public void edit (StoredFoodItem sf) {
        inventoryTrackingRepo.edit(sf);
    }
}
