package dev.service.Restaurant;

import dev.domain.Restaurant.CollectRequest;
import dev.domain.Restaurant.CollectRequestsFoodItem;
import dev.repository.Restaurant.CollectRequestItemRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CollectRequestItemService {

    private CollectRequestItemRepository collectRequestItemRepository;

    public CollectRequestItemService(CollectRequestItemRepository collectRequestItemRepository) {
        this.collectRequestItemRepository = collectRequestItemRepository;
    }
    public List<CollectRequestsFoodItem> getAll() {
        return collectRequestItemRepository.findAll();
    }

   public List<CollectRequestsFoodItem> getItemsByRequestId(int requestId) {
       return collectRequestItemRepository.findByRequestId(requestId);
   }
    public CollectRequestsFoodItem findById(int requestId) {
        return collectRequestItemRepository.findById(requestId);
    }

    public void create(CollectRequestsFoodItem collectRequestsFoodItem) {

        collectRequestItemRepository.create(collectRequestsFoodItem);
    }
    public void delete(int id) {
        collectRequestItemRepository.delete(id);
    }

    public void edit (CollectRequestsFoodItem collectRequestsFoodItem) {
        collectRequestItemRepository.edit(collectRequestsFoodItem);
    }


}

