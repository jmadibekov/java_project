import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Device> items;

    private BigDecimal totalPrice;

    public Basket() {
        this.items = new ArrayList<>();
        this.totalPrice = new BigDecimal(0);
    }

    public List<Device> getItems() {
        return items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void addItem(Device item) {
        this.items.add(item);
        this.totalPrice = totalPrice.add(item.getPrice());
    }
}
