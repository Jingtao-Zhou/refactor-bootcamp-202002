package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        printHeaders(output);
        printDateAndWeek(output);
        printCustomerInfo(output);
        printLineItems(output);
        printSplitLine(output);
        printAmount(output);

        return output.toString();
    }

    private void printAmount(StringBuilder output) {
        double totalSalesTax = order.calculateTax();
        double totalAmount = order.calculateTotalAmount();
        double discount = order.calculateDiscount();
        double totalAmountWithTax = totalAmount + totalSalesTax;

        printTotalSalesTax(output, totalSalesTax);
        if (dayOfWeekIsWednesday()) {
            printDiscountAmout(output, discount);
        }
        printTotalAmount(output, totalAmountWithTax);
    }

    private boolean dayOfWeekIsWednesday() {
        return DayOfWeek.WEDNESDAY.equals(LocalDate.now().getDayOfWeek());
    }

    private void printDiscountAmout(StringBuilder output, double discount) {
        output.append(String.format("折扣：\t%.2f\n",discount));
    }

    private void printSplitLine(StringBuilder output) {
        output.append("---------------------").append("\n");
    }

    private void printDateAndWeek(StringBuilder output) {
        output.append("\n");
        LocalDate now = LocalDate.now();
        output.append(now.getYear())
                .append("年")
                .append(now.getMonth().getValue())
                .append("月")
                .append(now.getDayOfMonth())
                .append("日");
        output.append("，")
                .append(now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.CHINESE))
                .append("\n\n");
    }

    private void printTotalAmount(StringBuilder output, double totalAmount) {
        output.append(String.format("总价：\t%.2f",totalAmount));
    }

    private void printTotalSalesTax(StringBuilder output, double totalSalesTax) {
        output.append(String.format("税额：\t%.2f\n",totalSalesTax));
    }

    private void printLineItems(StringBuilder output) {
        output.append(order.getLineItemInfo());
    }

    private void printCustomerInfo(StringBuilder output) {
        if (order.getCustomerName() != null) {
            output.append(order.getCustomerName());
        }
        if (order.getCustomerAddress() != null) {
            output.append(order.getCustomerAddress());
        }
    }

    private void printHeaders(StringBuilder output) {
        output.append("======老王超市，值得信赖======\n");
    }
}