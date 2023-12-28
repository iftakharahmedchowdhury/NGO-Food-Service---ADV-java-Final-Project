package dev.domain.Admin;

import dev.domain.Restaurant.CollectRequest;
import dev.domain.Restaurant.CollectRequestsFoodItem;

import java.util.List;

public class CollectRequestWithItems {
    private CollectRequest collectRequest;
    private List<CollectRequestsFoodItem> items;

    public CollectRequestWithItems() {
        // default constructor
    }

    public CollectRequestWithItems(CollectRequest collectRequest, List<CollectRequestsFoodItem> items) {
        this.collectRequest = collectRequest;
        this.items = items;
    }

    public CollectRequest getCollectRequest() {
        return collectRequest;
    }

    public void setCollectRequest(CollectRequest collectRequest) {
        this.collectRequest = collectRequest;
    }

    public List<CollectRequestsFoodItem> getItems() {
        return items;
    }

    public void setItems(List<CollectRequestsFoodItem> items) {
        this.items = items;
    }
}
