package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private String cName;
    private String addr;
    private List<LineItem> lineItemList;

    public Order(String cName, String addr, List<LineItem> lineItemList) {
        this.cName = cName;
        this.addr = addr;
        this.lineItemList = lineItemList;
    }

    String getCustomerName() {
        return cName;
    }

    String getCustomerAddress() {
        return addr;
    }

    List<LineItem> getLineItems() {
        return lineItemList;
    }
}
