package hellod.itemservice.domain.item;

import lombok.Data;

// data 위험 -> Getter 나 Setter 정도만 사용 추천
@Data
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
