package dev.service.Admin;

import dev.domain.Admin.DeliveryConfirmation;
import dev.domain.DeliveryMan.StoredFoodItem;
import dev.repository.Admin.ManageOrphanageDeliveryRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
@Service
@Transactional
public class ManageOrphanageDeliveryService {
    private ManageOrphanageDeliveryRepo manageOrphanageDeliveryRepo;
    private InventoryTrackingService inventoryTrackingService;

    public ManageOrphanageDeliveryService(ManageOrphanageDeliveryRepo manageOrphanageDeliveryRepo, InventoryTrackingService inventoryTrackingService) {
        this.manageOrphanageDeliveryRepo = manageOrphanageDeliveryRepo;
        this.inventoryTrackingService=inventoryTrackingService;
    }


    public void create(DeliveryConfirmation deliveryConfirmation) {

        int storedItemID=deliveryConfirmation.getFoodItemId();

        StoredFoodItem strItem = inventoryTrackingService.findById(storedItemID);

        manageOrphanageDeliveryRepo.create(deliveryConfirmation);
        strItem.setQuantity(strItem.getQuantity()-deliveryConfirmation.getQuantity());
        inventoryTrackingService.edit(strItem);


    }

    public List<DeliveryConfirmation> getAll() {
        return manageOrphanageDeliveryRepo.getAll();
    }

    public DeliveryConfirmation findById(int id) {
        return manageOrphanageDeliveryRepo.findById(id);
    }

    public void delete(int id) {
        manageOrphanageDeliveryRepo.delete(id);
    }
    public void edit (DeliveryConfirmation deliveryConfirmation) {
        manageOrphanageDeliveryRepo.edit(deliveryConfirmation);
    }


}
