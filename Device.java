import java.math.BigDecimal;

public interface Device {
    void discount(int percent);

    BigDecimal getPrice();
}
