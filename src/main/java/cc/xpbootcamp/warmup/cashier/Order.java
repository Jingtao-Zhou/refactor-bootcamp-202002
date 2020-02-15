package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
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

    List<LineItem> getLineItems() {
        return lineItemList;
    }
}
