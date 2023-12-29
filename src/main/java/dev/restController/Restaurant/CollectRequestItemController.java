package dev.restController.Restaurant;

import dev.domain.Restaurant.CollectRequest;
import dev.domain.Restaurant.CollectRequestsFoodItem;
import dev.service.Restaurant.CollectRequestItemService;
import dev.service.Restaurant.CollectRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CollectRequestItemController {

    private CollectRequestItemService collectRequestItemService;

    public CollectRequestItemController(CollectRequestItemService collectRequestItemService) {
        this.collectRequestItemService = collectRequestItemService;
    }

    @GetMapping("/collectRequestItems")
    public List<CollectRequestsFoodItem> getAllItems() {
        return collectRequestItemService.getAll();
    }

    @GetMapping("/collectRequestItemsByReqID/{requestId}")
    public List<CollectRequestsFoodItem> getItemsByRequestId(@PathVariable int requestId) {
        return collectRequestItemService.getItemsByRequestId(requestId);
    }
    @PostMapping("/collectRequestItems")
    public String createItemRequest(@RequestBody CollectRequestsFoodItem collectRequestsFoodItem) {
        collectRequestItemService.create(collectRequestsFoodItem);
        return "Successful";
    }

    @PutMapping("/collectRequestItems/{id}")
    public String updateItemRequest(@PathVariable("id") int id, @RequestBody CollectRequestsFoodItem collectRequestsFoodItem) {

        collectRequestItemService.edit(collectRequestsFoodItem);
        return "Successful";
    }

    @GetMapping("/collectRequestItems/{id}")
    public CollectRequestsFoodItem GetAllRequestById(@PathVariable("id") int id) {
        return collectRequestItemService.findById(id);
    }

    @DeleteMapping("/collectRequestItems/{id}")
    public String deleteRequestById(@PathVariable("id") int id) {
        collectRequestItemService.delete(id);
        return "Successful";
    }



}
