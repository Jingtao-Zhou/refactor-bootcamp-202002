package cc.xpbootcamp.warmup.cashier;

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
        double totalSalesTax = calculateTax(order);
        double totalAmount = calculateTotalAmount(order);
        double discount = calculateDiscount(totalAmount);
        double totalAmountWithTax = totalAmount + totalSalesTax;
        printTotalSalesTax(output, totalSalesTax);
        if (dayOfWeekIsWednesDay()) {
            printDiscountAmout(output, discount);
        }
        printTotalAmount(output, totalAmountWithTax);

        return output.toString();
    }

    private boolean dayOfWeekIsWednesDay() {
        return LocalDate.now().getDayOfWeek().getValue() == 3;
    }

    private void printDiscountAmout(StringBuilder output, double discount) {
        output.append("折扣：").append("\t").append(String.format("%.2f",discount)).append("\n");
    }

    private double calculateDiscount(double totalAmount) {
        return totalAmount * 0.02;
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
        output.append("总价：").append('\t').append(String.format("%.2f",totalAmount));
    }

    private void printTotalSalesTax(StringBuilder output, double totalSalesTax) {
        output.append("税额：").append('\t').append(String.format("%.2f",totalSalesTax)).append("\n");
    }

    private double calculateTotalAmount(Order order) {
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            totalAmount += lineItem.totalAmount();
        }
        return totalAmount;
    }

    private double calculateTax(Order order) {
        double totalSalesTax = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            double salesTax = lineItem.totalAmount() * .10;
            totalSalesTax += salesTax;
        }
        return totalSalesTax;
    }

    private void printLineItems(StringBuilder output) {
        for (LineItem lineItem : order.getLineItems()) {
            output.append(String.format("%s，%.2f*%d，%.2f",
                    lineItem.getDescription(),
                    lineItem.getPrice(),
                    lineItem.getQuantity(),
                    lineItem.totalAmount()))
                    .append("\n");
        }
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