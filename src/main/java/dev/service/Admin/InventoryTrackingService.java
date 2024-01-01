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

  /*  public void create(int id,StoredFoodItem sf) {
      List <CollectRequestsFoodItem> clrData = collectRequestItemService.getItemsByRequestId(id);

        for (CollectRequestsFoodItem item : clrData) {
            sf.setCollectRequest(clrData);
            inventoryTrackingRepo.create();
        }
    }*/
  public void create(int id/*, StoredFoodItem sf*/) {
      List<CollectRequestsFoodItem> clrData = collectRequestItemService.getItemsByRequestId(id);

      for (CollectRequestsFoodItem collectRequestsFoodItem : clrData) {
          StoredFoodItem storedFoodItem = new StoredFoodItem();
          storedFoodItem.setCollectRequest(collectRequestsFoodItem.getCollectRequest());
          storedFoodItem.setItemName(collectRequestsFoodItem.getItemName());
          storedFoodItem.setQuantity(collectRequestsFoodItem.getQuantity());
          storedFoodItem.setExpiryDate(collectRequestsFoodItem.getExpiryDate());
          storedFoodItem.setDescription(collectRequestsFoodItem.getDescription());

          inventoryTrackingRepo.create(storedFoodItem);
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
