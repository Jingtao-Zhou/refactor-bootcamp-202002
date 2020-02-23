package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private static final double TAX_RATE = .10;
    private static final double DISCOUNT = 0.02;
    private String customerName;
    private String address;
    private List<LineItem> lineItemList;

    public Order(String customerName, String address, List<LineItem> lineItemList) {
        this.customerName = customerName;
        this.address = address;
        this.lineItemList = lineItemList;
    }

    String getCustomerName() {
        return customerName;
    }

    String getCustomerAddress() {
        return address;
    }

    String getLineItemInfo() {
        StringBuilder lineItemInfo = new StringBuilder();
        for (LineItem lineItem : this.lineItemList) {
            lineItemInfo.append(String.format("%s，%.2f*%d，%.2f\n",
                    lineItem.getDescription(),
                    lineItem.getPrice(),
                    lineItem.getQuantity(),
                    lineItem.totalAmount()));
        }
        return lineItemInfo.toString();
    }

    double calculateTax() {
        double totalSalesTax = 0d;
        for (LineItem lineItem : this.lineItemList) {
            double salesTax = lineItem.totalAmount() * TAX_RATE;
            totalSalesTax += salesTax;
        }
        return totalSalesTax;
    }

    double calculateTotalAmount() {
        double totalAmount = 0d;
        for (LineItem lineItem : this.lineItemList) {
            totalAmount += lineItem.totalAmount();
        }
        return totalAmount;
    }

    double calculateDiscount() {
        return this.calculateTotalAmount() * DISCOUNT;
    }
}
