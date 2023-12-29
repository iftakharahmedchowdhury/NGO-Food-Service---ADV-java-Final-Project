package dev.domain.Admin;

import dev.domain.Restaurant.CollectRequest;
import dev.domain.User.User;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "deliveryconfirmation")
public class DeliveryConfirmation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ConfirmationID")
    private int confirmationId;

    @Column(name = "ItemName", nullable = false)
    private String itemName;
    @Column(name="FoodItemId",nullable = false)
    private int foodItemId;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "ExpiryDate", nullable = false)
    private java.sql.Date expiryDate;

    @Column(name = "DeliveryLocation", nullable = false, length = 200)
    private String deliveryLocation;

    @Column(name = "ConfirmationTime")
    private LocalDateTime confirmationTime;

    @Column(name = "CompletionTime")
    private LocalDateTime completionTime;

    @Column(name = "DetailsComments", nullable = false, length = 50)
    private String detailsComments;

    @Column(name = "DeliveryStatus", nullable = false, length = 50)
    private String deliveryStatus;

    @ManyToOne
    @JoinColumn(name = "ConfirmingEmployeeID")
    private User confirmingEmployee;

    @ManyToOne
    @JoinColumn(name = "RequestID")
    private CollectRequest collectRequest;



    public DeliveryConfirmation() {
    }

    public DeliveryConfirmation(int confirmationId, String itemName,int foodItemId, int quantity, Date expiryDate, String deliveryLocation, LocalDateTime confirmationTime, LocalDateTime completionTime, String detailsComments, String deliveryStatus, User confirmingEmployee, CollectRequest collectRequest) {
        this.confirmationId = confirmationId;
        this.itemName = itemName;
        this.foodItemId = foodItemId;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.deliveryLocation = deliveryLocation;
        this.confirmationTime = confirmationTime;
        this.completionTime = completionTime;
        this.detailsComments = detailsComments;
        this.deliveryStatus = deliveryStatus;
        this.confirmingEmployee = confirmingEmployee;
        this.collectRequest = collectRequest;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public int getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(int confirmationId) {
        this.confirmationId = confirmationId;
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

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public LocalDateTime getConfirmationTime() {
        return confirmationTime;
    }

    public void setConfirmationTime(LocalDateTime confirmationTime) {
        this.confirmationTime = confirmationTime;
    }

    public LocalDateTime getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(LocalDateTime completionTime) {
        this.completionTime = completionTime;
    }

    public String getDetailsComments() {
        return detailsComments;
    }

    public void setDetailsComments(String detailsComments) {
        this.detailsComments = detailsComments;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public User getConfirmingEmployee() {
        return confirmingEmployee;
    }

    public void setConfirmingEmployee(User confirmingEmployee) {
        this.confirmingEmployee = confirmingEmployee;
    }

    public CollectRequest getCollectRequest() {
        return collectRequest;
    }

    public void setCollectRequest(CollectRequest collectRequest) {
        this.collectRequest = collectRequest;
    }
}
