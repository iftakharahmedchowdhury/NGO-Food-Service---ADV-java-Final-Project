package dev.domain.Restaurant;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "collectrequestsfooditem")
public class CollectRequestsFoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CollectRequestsFoodItemID")
    private int collectRequestsFoodItemId;

    @Column(name = "RequestID")
    private int requestId;

    @Column(name = "ItemName")
    private String itemName;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "ExpiryDate")
    private LocalDate expiryDate;

    @Column(name = "Description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "RequestID"/*, referencedColumnName = "RequestID"*/, insertable = false, updatable = false)
    private CollectRequest collectRequest;

    public CollectRequestsFoodItem() {

    }

    public CollectRequestsFoodItem(int collectRequestsFoodItemId, int requestId, String itemName, int quantity, LocalDate expiryDate, String description, CollectRequest collectRequest) {
        this.collectRequestsFoodItemId = collectRequestsFoodItemId;
        this.requestId = requestId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.description = description;
        this.collectRequest = collectRequest;
    }

    public int getCollectRequestsFoodItemId() {
        return collectRequestsFoodItemId;
    }

    public void setCollectRequestsFoodItemId(int collectRequestsFoodItemId) {
        this.collectRequestsFoodItemId = collectRequestsFoodItemId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
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

    public CollectRequest getCollectRequest() {
        return collectRequest;
    }

    public void setCollectRequest(CollectRequest collectRequest) {
        this.collectRequest = collectRequest;
    }

}
