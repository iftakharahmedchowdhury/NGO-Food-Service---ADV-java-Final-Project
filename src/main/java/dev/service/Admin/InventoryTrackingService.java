package dev.service.Admin;

import dev.domain.DeliveryMan.StoredFoodItem;
import dev.domain.Restaurant.CollectRequest;
import dev.domain.Restaurant.CollectRequestsFoodItem;
import dev.repository.Admin.InventoryTrackingRepo;
import dev.service.Restaurant.CollectRequestItemService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InventoryTrackingService {
    private InventoryTrackingRepo inventoryTrackingRepo;
    private CollectRequestItemService collectRequestItemService;

    public InventoryTrackingService(InventoryTrackingRepo inventoryTrackingRepo, CollectRequestItemService collectRequestItemService) {
        this.inventoryTrackingRepo = inventoryTrackingRepo;
        this.collectRequestItemService=collectRequestItemService;
    }


  public void create(int id/*, StoredFoodItem sf*/) {
      List<CollectRequestsFoodItem> clrData = collectRequestItemService.getItemsByRequestId(id);

      for (CollectRequestsFoodItem collectRequestsFoodItem : clrData) {
          String itemName = collectRequestsFoodItem.getItemName();
          StoredFoodItem existingItem = inventoryTrackingRepo.findByItemName(itemName);

          if (existingItem != null) {

              int newQuantity = existingItem.getQuantity() + collectRequestsFoodItem.getQuantity();
              existingItem.setQuantity(newQuantity);
              inventoryTrackingRepo.edit(existingItem);
          } else {

              StoredFoodItem storedFoodItem = new StoredFoodItem();
              storedFoodItem.setCollectRequest(collectRequestsFoodItem.getCollectRequest());
              storedFoodItem.setItemName(itemName);
              storedFoodItem.setQuantity(collectRequestsFoodItem.getQuantity());
              storedFoodItem.setExpiryDate(collectRequestsFoodItem.getExpiryDate());
              storedFoodItem.setDescription(collectRequestsFoodItem.getDescription());

              inventoryTrackingRepo.create(storedFoodItem);
          }
      }
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
