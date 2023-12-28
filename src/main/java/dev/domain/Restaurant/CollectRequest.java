package dev.domain.Restaurant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.domain.Admin.DeliveryConfirmation;
import dev.domain.DeliveryMan.StoredFoodItem;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "collectrequests")
public class CollectRequest{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RequestID")
    private int requestId;
    @NotNull
    @Column(name = "ResturentUserID")
    private int restaurantUserId;
    @NotNull
    @Column(name = "MaxPreserveTime")
    private LocalDateTime maxPreserveTime;
    @NotNull
    @Column(name = "Status")
    private String status;
    @NotNull
    @Column(name = "CollectionAddress")
    private String collectionAddress;

    @Column(name = "AssignedEmployeeID")
    private Integer assignedEmployeeId;

    @Column(name = "CollectionTime")
    private LocalDateTime collectionTime;

    @Column(name = "CompletionTime")
    private LocalDateTime completionTime;

    @OneToMany(mappedBy = "requestId",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JsonIgnore
    private List<CollectRequestsFoodItem> foodItems;

    @OneToMany(mappedBy = "collectRequest")

    private List<DeliveryConfirmation> deliveryConfirmations;

    @OneToMany(mappedBy = "collectRequest", cascade = CascadeType.ALL)
    private Set<StoredFoodItem> storedFoodItems;
    public CollectRequest() {
    }

    public CollectRequest(int requestId, int restaurantUserId, LocalDateTime maxPreserveTime, String status, String collectionAddress, Integer assignedEmployeeId, LocalDateTime collectionTime, LocalDateTime completionTime, List<CollectRequestsFoodItem> foodItems) {
        this.requestId = requestId;
        this.restaurantUserId = restaurantUserId;
        this.maxPreserveTime = maxPreserveTime;
        this.status = status;
        this.collectionAddress = collectionAddress;
        this.assignedEmployeeId = assignedEmployeeId;
        this.collectionTime = collectionTime;
        this.completionTime = completionTime;
        this.foodItems = foodItems;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getRestaurantUserId() {
        return restaurantUserId;
    }

    public void setRestaurantUserId(int restaurantUserId) {
        this.restaurantUserId = restaurantUserId;
    }

    public LocalDateTime getMaxPreserveTime() {
        return maxPreserveTime;
    }

    public void setMaxPreserveTime(LocalDateTime maxPreserveTime) {
        this.maxPreserveTime = maxPreserveTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCollectionAddress() {
        return collectionAddress;
    }

    public void setCollectionAddress(String collectionAddress) {
        this.collectionAddress = collectionAddress;
    }

    public Integer getAssignedEmployeeId() {
        return assignedEmployeeId;
    }

    public void setAssignedEmployeeId(Integer assignedEmployeeId) {
        this.assignedEmployeeId = assignedEmployeeId;
    }

    public LocalDateTime getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(LocalDateTime collectionTime) {
        this.collectionTime = collectionTime;
    }

    public LocalDateTime getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(LocalDateTime completionTime) {
        this.completionTime = completionTime;
    }

    public List<CollectRequestsFoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<CollectRequestsFoodItem> foodItems) {
        this.foodItems = foodItems;
    }


}
