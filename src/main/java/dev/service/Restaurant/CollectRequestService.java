package dev.service.Restaurant;

import dev.domain.Restaurant.CollectRequest;
import dev.domain.Restaurant.CollectRequestsFoodItem;
import dev.repository.Restaurant.CollectRequestItemRepository;
import dev.repository.Restaurant.CollectRequestRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class CollectRequestService {

    private CollectRequestRepository collectRequestRepository;
    private CollectRequestItemRepository collectRequestItemRepository;

    public CollectRequestService(CollectRequestRepository collectRequestRepository) {
        this.collectRequestRepository = collectRequestRepository;
    }
    public List<CollectRequest> getAll() {
        return collectRequestRepository.getAll();
    }
    public CollectRequest findById(int requestId) {
        return collectRequestRepository.findById(requestId);
    }

    public void create(CollectRequest collectRequest) {

        collectRequestRepository.create(collectRequest);
    }

    public void delete(int id) {
        collectRequestRepository.delete(id);
    }

    public void edit (CollectRequest collectRequest) {
        collectRequestRepository.edit(collectRequest);
    }


}




