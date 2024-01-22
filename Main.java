
public class Main {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();

        orderManager.addOrder(1000, 2000, 12, 100.51);
        orderManager.addOrder(1000, 2001, 31, 200);
        orderManager.addOrder(1000, 2002, 22, 150.86);
        orderManager.addOrder(1000, 2003, 41, 250);
        orderManager.addOrder(1000, 2004, 55, 244);

        orderManager.addOrder(1001, 2001, 88, 44.531);
        orderManager.addOrder(1001, 2002, 121, 88.11);
        orderManager.addOrder(1001, 2004, 74, 211);
        orderManager.addOrder(1001, 2002, 14, 88.11);

        orderManager.addOrder(1002, 2003, 2, 12.1);
        orderManager.addOrder(1002, 2004, 3, 22.3);
        orderManager.addOrder(1002, 2003, 8, 12.1);
        orderManager.addOrder(1002, 2002, 16, 94);
        orderManager.addOrder(1002, 2005, 9, 44.1);
        orderManager.addOrder(1002, 2006, 19, 90);

        System.out.println("a. Üç siparişteki toplam tutar: " + orderManager.getTotalAmount(1000) + " TL");
        System.out.println("b. Üç siparişteki bütün malların ortalama fiyatı: " + orderManager.getAveragePrice() + " TL");

        orderManager.printItemQuantities();
    }
}
