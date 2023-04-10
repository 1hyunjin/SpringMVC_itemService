package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data는 핵심 domain에서 사용하지 않는게 좋다. 주의할 필요가 있다.
@Data //@Data ->  @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;   // Integer를 사용하는 이유 -> null도 들어갈 수 있도록!

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
