package dev.restController.Restaurant;

import dev.domain.Restaurant.CollectRequest;
import dev.service.Restaurant.CollectRequestItemService;
import dev.service.Restaurant.CollectRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CollectRequestController {

    private CollectRequestService collectRequestService;
    private CollectRequestItemService collectRequestItemService;

    /*@Autowired*/
    public CollectRequestController(CollectRequestService collectRequestService) {
        this.collectRequestService = collectRequestService;
    }

    @GetMapping("/collectRequest")
    public List<CollectRequest> getAllCollectRequests() {
        return collectRequestService.getAll();
    }


   /* @PostMapping("/collectRequest")
    public String createRequest(@RequestBody CollectRequest collectRequest) {
        collectRequestService.create(collectRequest);
        return "Successful";
    }*/
   @PostMapping("/collectRequest")
   public ResponseEntity<String> createRequest(@RequestBody CollectRequest collectRequest) {
       int requestId = collectRequestService.create(collectRequest);
       return ResponseEntity.ok("Your request ID: " + requestId);
   }

    @PutMapping("/collectRequest/{id}")
    public String updateRequest(@PathVariable("id") int id, @RequestBody CollectRequest collectRequest) {

        collectRequestService.edit(collectRequest);
        return "Successful updated";
    }

    @GetMapping("/collectRequest/{id}")
    public CollectRequest GetAllRequestById(@PathVariable("id") int id) {
        return collectRequestService.findById(id);
    }

    @DeleteMapping("/collectRequest/{id}")
    public String deleteRequestById(@PathVariable("id") int id) {
        collectRequestService.delete(id);
        return "Successful";
    }


}
