import java.math.BigDecimal;

public class Buyer extends User {
    public enum CreditCardType {
        VISA, MasterCard
    }

    private CreditCardType cardType;
    private String creditCardNumber;
    private BigDecimal moneyAmount;

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public Buyer(String fullName, long UIN, String phoneNumber, CreditCardType cardType, String creditCardNumber,
            BigDecimal moneyAmount) {
        this.fullName = fullName;
        this.UIN = UIN;
        this.phoneNumber = phoneNumber;
        this.cardType = cardType;
        this.moneyAmount = moneyAmount;

        if (isValidCreditCardNumber(creditCardNumber)) {
            this.creditCardNumber = creditCardNumber;
        } else {
            throw new IllegalArgumentException("Invalid credit card number");
        }
    }

    public CreditCardType getCardType() {
        return cardType;
    }

    public void setCardType(CreditCardType cardType) {
        this.cardType = cardType;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        if (isValidCreditCardNumber(creditCardNumber)) {
            this.creditCardNumber = creditCardNumber;
        } else {
            throw new IllegalArgumentException("Invalid credit card number");
        }
    }

    @Override
    public void changePhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    @Override
    public void changeFullName(String newFullName) {
        this.fullName = newFullName;
    }

    private boolean isValidCreditCardNumber(String number) {
        // Check if the credit card number has exactly 16 digits
        return number.matches("\\d{16}");
    }
}
