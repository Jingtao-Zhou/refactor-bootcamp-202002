package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        printHeaders(output);
        printCustomerInfo(output);
        printLineItems(output);

        double totalSalesTax = calculateTax(order);
        double totalAmount = calculateTotalAmount(order,totalSalesTax);

        printTotalSalesTax(output, totalSalesTax);
        printTotalAmount(output, totalAmount);

        return output.toString();
    }

    private void printTotalAmount(StringBuilder output, double totalAmount) {
        output.append("Total Amount").append('\t').append(totalAmount);
    }

    private void printTotalSalesTax(StringBuilder output, double totalSalesTax) {
        output.append("Sales Tax").append('\t').append(totalSalesTax);
    }

    private double calculateTotalAmount(Order order, double totalSalesTax) {
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            totalAmount +=lineItem.totalAmount();
        }
        return totalAmount+totalSalesTax;
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
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');
        }
    }

    private void printCustomerInfo(StringBuilder output) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }

    private void printHeaders(StringBuilder output) {
        output.append("======Printing Orders======\n");
    }
}