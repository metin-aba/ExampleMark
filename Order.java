import java.util.ArrayList;
import java.util.List;

class Order {
    private int orderNumber;
    private int itemNumber;
    private int quantity;
    private double unitPrice;

    public Order(int orderNumber, int itemNumber, int quantity, double unitPrice) {
        this.orderNumber = orderNumber;
        this.itemNumber = itemNumber;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public double getTotalAmount() {
        return quantity * unitPrice;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getQuantity() {
        return quantity;
    }
}

class OrderManager {
    private List<Order> orders = new ArrayList<>();
    private List<Integer> itemQuantities = new ArrayList<>();

    public void addOrder(int orderNumber, int itemNumber, int quantity, double unitPrice) {
        orders.add(new Order(orderNumber, itemNumber, quantity, unitPrice));

        while (itemQuantities.size() <= itemNumber) {
            itemQuantities.add(0);
        }
        itemQuantities.set(itemNumber, itemQuantities.get(itemNumber) + quantity);
    }

    public double getTotalAmount(int orderNumber) {
        double totalAmount = 0.0;
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                totalAmount += order.getTotalAmount();
            }
        }
        return totalAmount;
    }

    public double getAveragePrice() {
        int totalQuantity = 0;
        double totalAmount = 0.0;

        for (Order order : orders) {
            totalQuantity += order.getQuantity();
            totalAmount += order.getTotalAmount();
        }

        return totalQuantity > 0 ? totalAmount / totalQuantity : 0.0;
    }

    public void printItemQuantities() {
        System.out.println("d. Tek tek mal bazlı, malların toplam miktarı:");
        for (int i = 0; i < itemQuantities.size(); i++) {
            int quantity = itemQuantities.get(i);
            if (quantity > 0) {
                System.out.println("Mal No: " + i + ", Toplam Miktar: " + quantity);
            }
        }
    }
}