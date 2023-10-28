import java.math.BigDecimal;

public class MainConsoleApp {
    private static void printInfo(Buyer buyer, Salesman salesman) {
        // Display buyer information and credit card type
        System.out.println("Buyer Information:");
        System.out.println(buyer);
        System.out.println("His amount of money: " + buyer.getMoneyAmount());

        // Display salesman information, laptops, and mobiles
        System.out.println("\nSalesman Information:");
        System.out.println(salesman);
        System.out.println("His earned money: " + salesman.getMoneyInBankAccount());
        System.out.println("Laptops:");
        for (Laptop laptop : salesman.getLaptops()) {
            System.out.println(laptop);
        }
        System.out.println("Mobiles:");
        for (Mobile mobile : salesman.getMobiles()) {
            System.out.println(mobile);
        }
    }

    public static void main(String[] args) {
        Buyer buyer = new Buyer("Nurbakhyt Madibekov", 123456123456L, "7-707-543-44-32", Buyer.CreditCardType.VISA,
                "1234567890123456", new BigDecimal("10500.50"));

        Laptop[] laptops = { new Laptop("MacBook Pro", new BigDecimal("999.99")),
                new Laptop("Windows Surface", new BigDecimal("799.99")) };

        Mobile[] mobiles = { new Mobile("iPhone 14", new BigDecimal("499.99")),
                new Mobile("Pixel 10", new BigDecimal("349.99")) };

        Salesman salesman = new Salesman("Nurseit Almasov", 123456123456L, "7-707-543-44-32",
                Salesman.LegalEntityType.IndividualEntrepreneur, new BigDecimal("0.00"), laptops, mobiles);

        System.out.println("=== Initial info ==");
        printInfo(buyer, salesman);

        Basket basket = new Basket();
        basket.addItem(salesman.getLaptops().get(0));
        basket.addItem(salesman.getMobiles().get(1));
        if (basket.getTotalPrice().compareTo(buyer.getMoneyAmount()) <= 0) {
            System.out.println("\nBuyer buying:");
            for (Device item : basket.getItems()) {
                System.out.println(item);
            }
            System.out.println("Spent total: " + basket.getTotalPrice());

            buyer.setMoneyAmount(buyer.getMoneyAmount().subtract(basket.getTotalPrice()));
            salesman.setMoneyInBankAccount(salesman.getMoneyInBankAccount().add(basket.getTotalPrice()));
            for (Device item : basket.getItems()) {
                if (item instanceof Laptop) {
                    salesman.removeLaptop((Laptop) item);
                } else {
                    salesman.removeMobile((Mobile) item);
                }
            }

            System.out.println("=== After purchase ==");
            printInfo(buyer, salesman);
        }
    }
}
