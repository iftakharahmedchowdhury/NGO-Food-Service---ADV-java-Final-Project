package dev.domain.DeliveryMan;

import dev.domain.Restaurant.CollectRequest;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "storedfooditems")
public class StoredFoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FoodItemID")
    private int foodItemId;

    @ManyToOne
    @JoinColumn(name = "RequestID")
    private CollectRequest collectRequest;

    @Column(name = "ItemName")
    private String itemName;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "ExpiryDate")
    private LocalDate expiryDate;

    @Column(name = "Description")
    private String description;

    public StoredFoodItem() {
    }

    public StoredFoodItem(int foodItemId, CollectRequest collectRequest, String itemName, int quantity, LocalDate expiryDate, String description) {
        this.foodItemId = foodItemId;
        this.collectRequest = collectRequest;
        this.itemName = itemName;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.description = description;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public CollectRequest getCollectRequest() {
        return collectRequest;
    }

    public void setCollectRequest(CollectRequest collectRequest) {
        this.collectRequest = collectRequest;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

