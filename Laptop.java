import java.math.BigDecimal;
import java.math.RoundingMode;

public class Laptop implements Device {
    private String model;
    private BigDecimal price;

    public Laptop(String model, BigDecimal price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void discount(int percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }

        BigDecimal discountAmount = price.multiply(BigDecimal.valueOf(percent)).divide(BigDecimal.valueOf(100));
        price = price.subtract(discountAmount);
        price = price.setScale(2, RoundingMode.HALF_EVEN);

    }

    @Override
    public String toString() {
        return "Laptop{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
