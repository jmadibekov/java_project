import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Salesman extends User {
    public enum LegalEntityType {
        IndividualEntrepreneur, // ИП
        LLP // ТОО
    }

    private LegalEntityType entityType;
    private BigDecimal moneyInBankAccount;
    private List<Laptop> laptops;
    private List<Mobile> mobiles;

    public Salesman(String fullName, long UIN, String phoneNumber, LegalEntityType entityType,
            BigDecimal moneyInBankAccount,
            Laptop[] laptops, Mobile[] mobiles) {
        this.fullName = fullName;
        this.UIN = UIN;
        this.phoneNumber = phoneNumber;

        this.entityType = entityType;
        this.moneyInBankAccount = moneyInBankAccount;

        this.laptops = new ArrayList<>();
        for (Laptop laptop : laptops) {
            this.laptops.add(laptop);
        }

        this.mobiles = new ArrayList<>();
        for (Mobile mobile : mobiles) {
            this.mobiles.add(mobile);
        }
    }

    public List<Mobile> getMobiles() {
        return mobiles;
    }

    public void removeMobile(Mobile mobileToRemove) {
        for (int i = 0; i < mobiles.size(); i++) {
            Mobile mobile = mobiles.get(i);
            if (mobileToRemove.getModel().equals(mobile.getModel())) {
                mobiles.remove(i);
                break;
            }
        }
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void removeLaptop(Laptop laptopToRemove) {
        for (int i = 0; i < laptops.size(); i++) {
            Laptop laptop = laptops.get(i);
            if (laptopToRemove.getModel().equals(laptop.getModel())) {
                laptops.remove(i);
                break;
            }
        }
    }

    public void setMoneyInBankAccount(BigDecimal moneyInBankAccount) {
        this.moneyInBankAccount = moneyInBankAccount;
    }

    public BigDecimal getMoneyInBankAccount() {
        return moneyInBankAccount;
    }

    public LegalEntityType getEntityType() {
        return entityType;
    }

    @Override
    public void changePhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    @Override
    public void changeFullName(String newFullName) {
        this.fullName = newFullName;
    }
}
