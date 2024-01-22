public class AveragePriceCalculator {

    public static void main(String[] args) {
        int[][] orderDetails = {
                {1000, 2000, 12, 10051},
                {1000, 2001, 31, 20000},
                {1000, 2002, 22, 15086},
                // Diğer sipariş detayları buraya eklenebilir
        };

        double averagePrice = calculateAveragePrice(orderDetails);

        System.out.println("Siparişlerin ortalaması: " + averagePrice);
    }

    private static double calculateAveragePrice(int[][] orderDetails) {
        double totalPrice = 0;
        int totalQuantity = 0;

        for (int i = 0; i < orderDetails.length; i++) {
            int quantity = orderDetails[i][2];
            double unitPrice = orderDetails[i][3] / 100.0; // Convert to TL by dividing by 100
            totalPrice += quantity * unitPrice;
            totalQuantity += quantity;
        }

        double averagePrice = totalQuantity == 0 ? 0 : totalPrice / totalQuantity;
        return averagePrice;
    }
}
