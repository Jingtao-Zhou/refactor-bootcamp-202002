package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void shouldPrintCustomerInformationOnOrder() {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<LineItem>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();


        assertThat(output, containsString("Mr X"));
        assertThat(output, containsString("Chicago, 60601"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk，10.00*2，20.00\n"));
        assertThat(output, containsString("biscuits，5.00*5，25.00\n"));
        assertThat(output, containsString("chocolate，20.00*1，20.00\n"));
        assertThat(output, containsString("税额：\t6.5"));
        assertThat(output, containsString("总价：\t71.5"));
    }

    @Test
    void shouldDiscountWhenShoppingOnWednesday() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk，10.00*2，20.00\n"));
        assertThat(output, containsString("税额：\t2.00"));
        if (LocalDate.now().getDayOfWeek().getValue() == 3) {
            assertThat(output, containsString("折扣：\t0.40"));
        }
        assertThat(output, containsString("总价：\t22.00"));
    }
}