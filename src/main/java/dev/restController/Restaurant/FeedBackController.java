package dev.restController.Restaurant;

import dev.domain.Restaurant.Feedback;
import dev.service.Restaurant.FeedBackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedBackController {
    private FeedBackService feedBackService;


    public FeedBackController(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }


    @GetMapping("/feedBack")
    public List<Feedback> getAllFeedback() {
        return feedBackService.getAll();
    }


    @PostMapping("/feedBack")
    public String insertFeedBack(@RequestBody Feedback fb) {
        feedBackService.create(fb);
        return "Successful";
    }

    @PutMapping("/feedBack/{id}")
    public String updateFeedBack(@PathVariable("id") int id, @RequestBody Feedback fb) {

        feedBackService.edit(fb);
        return "Successful updated";
    }

    @GetMapping("/feedBack/{id}")
    public Feedback GetAllRequestById(@PathVariable("id") int id) {
        return feedBackService.findById(id);
    }

    @DeleteMapping("/feedBack/{id}")
    public String deleteRequestById(@PathVariable("id") int id) {
        feedBackService.delete(id);
        return "Delete Successful";
    }
}
