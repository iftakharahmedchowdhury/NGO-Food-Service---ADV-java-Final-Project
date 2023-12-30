package dev.service.Restaurant;

import dev.domain.Restaurant.Feedback;
import dev.repository.Restaurant.FeedBackRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeedBackService {
    private FeedBackRepo feedBackRepo;

    public FeedBackService(FeedBackRepo feedBackRepo) {
        this.feedBackRepo = feedBackRepo;
    }

    public void create(Feedback fb) {
        feedBackRepo.create(fb);
    }

    public List<Feedback> getAll() {
        return feedBackRepo.getAll();
    }
    public Feedback findById(int requestId) {
        return feedBackRepo.findById(requestId);
    }
    public void delete(int id) {
        feedBackRepo.delete(id);
    }

    public void edit (Feedback fb) {
        feedBackRepo.edit(fb);
    }
}
