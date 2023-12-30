package dev.domain.Orphanage;
import dev.domain.User.User;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orphanagefoodrequest")
public class OrphanageFoodRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RequestID")
    private int requestId;

    @Column(name = "OrphanageUserID")
    private int orphanageUserId;

    @Column(name = "OrphanageName")
    private String orphanageName;

    @Column(name = "Status")
    private String status;

    @Column(name = "OrphanageAddress")
    private String orphanageAddress;
    @Column(name = "PeopleCount")
    private int peopleCount;

    @Column(name = "AssignEmployee")
    private Integer assignEmployee;

    @Column(name = "DeliveryTime")
    private LocalDateTime deliveryTime;

    @ManyToOne
    @JoinColumn(name = "OrphanageUserID", referencedColumnName = "id", insertable = false, updatable = false)
    private User orphanageUser;

    @ManyToOne
    @JoinColumn(name = "AssignEmployee", referencedColumnName = "id", insertable = false, updatable = false)
    private User assignedEmployee;


    public OrphanageFoodRequest() {
    }

    public OrphanageFoodRequest(int requestId, int orphanageUserId, String orphanageName, String status, String orphanageAddress,int peopleCount, Integer assignEmployee, LocalDateTime deliveryTime, User orphanageUser, User assignedEmployee) {
        this.requestId = requestId;
        this.orphanageUserId = orphanageUserId;
        this.orphanageName = orphanageName;
        this.status = status;
        this.orphanageAddress = orphanageAddress;
        this.peopleCount=peopleCount;
        this.assignEmployee = assignEmployee;
        this.deliveryTime = deliveryTime;
        this.orphanageUser = orphanageUser;
        this.assignedEmployee = assignedEmployee;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getOrphanageUserId() {
        return orphanageUserId;
    }

    public void setOrphanageUserId(int orphanageUserId) {
        this.orphanageUserId = orphanageUserId;
    }

    public String getOrphanageName() {
        return orphanageName;
    }

    public void setOrphanageName(String orphanageName) {
        this.orphanageName = orphanageName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrphanageAddress() {
        return orphanageAddress;
    }

    public void setOrphanageAddress(String orphanageAddress) {
        this.orphanageAddress = orphanageAddress;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Integer getAssignEmployee() {
        return assignEmployee;
    }

    public void setAssignEmployee(Integer assignEmployee) {
        this.assignEmployee = assignEmployee;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public User getOrphanageUser() {
        return orphanageUser;
    }

    public void setOrphanageUser(User orphanageUser) {
        this.orphanageUser = orphanageUser;
    }

    public User getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(User assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }
}
