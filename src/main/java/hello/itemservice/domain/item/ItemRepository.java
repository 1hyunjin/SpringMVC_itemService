package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    // key는 Long 타입 : 이유 -> item의 id가 Long 타입이여서
    // 실제는 hashmap쓰면 안됨(동시성문제?). (ConcurrentHashMap사용해야함), static 사용
    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;  // static 사용

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }

    public void delete(Long itemId) {
        Item deleteitem = findById(itemId);
        store.remove(itemId);
    }
}
